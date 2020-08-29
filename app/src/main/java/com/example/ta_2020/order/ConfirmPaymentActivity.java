package com.example.ta_2020.order;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.loader.content.CursorLoader;

import com.example.ta_2020.MainActivity;
import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmPaymentActivity extends AppCompatActivity {

    @BindView(R.id.toolbarFormPemesanan)
    Toolbar toolbarFormPemesanan;
    @BindView(R.id.tvName)
    EditText tvName;
    @BindView(R.id.tvEmail)
    EditText tvEmail;
    @BindView(R.id.txtFormDate)
    EditText txtFormDate;
    @BindView(R.id.idTotalPrice)
    EditText idTotalPrice;
    @BindView(R.id.idPaymentMethod)
    EditText idPaymentMethod;
    @BindView(R.id.idInvoice)
    EditText idInvoice;
    @BindView(R.id.tvDesc)
    EditText tvDesc;
    @BindView(R.id.btnPaid)
    Button btnPaid;
    @BindView(R.id.relativeBottom)
    RelativeLayout relativeBottom;

    Uri mImageUri;
    String imagePath;

    ImageView ibPhoto;

    ApiInterface apiInterface;
    PrefManager prefManager;
    Context context;

    Toolbar toolbar;
    Calendar calendar;
    DatePickerDialog dialog;
    Context mContext = this;



    private static final int PICK_IMAGE_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_onfirm_payment);
        ButterKnife.bind(this);

        ibPhoto=findViewById(R.id.idPhoto);

        apiInterface = UtilsApi.getApiService();
        prefManager = new PrefManager(this);
        context =this;

        ibPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        txtFormDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                final int month = calendar.get(Calendar.MONTH);
                final int year = calendar.get(Calendar.YEAR);

                dialog = new DatePickerDialog(ConfirmPaymentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String bulan = "" + i1;
                        String tgl = "" + i2;
                        if (i1 < 10) {
                            bulan = "0" + (i1 + 1);
                        }
                        if (i2 < 10) {
                            tgl = "0" + i2;
                        }
                        txtFormDate.setText(i + "-" + bulan + "-" + tgl);
                    }
                }, year, month, day);
                dialog.show();
            }
        });

        btnPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imagePath == null){
                    Toast.makeText(context, "Mohon upload bukti transfer", Toast.LENGTH_SHORT).show();
                }else{
                    uploadImage();
                }

            }
        });

    }
    private void openFileChooser() {
        final CharSequence[] options = {"Choose from Gallery", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Add Photo");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (options[i].equals("Choose from Gallery")) {
                    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                    photoPickerIntent.setType("image/*");
                    startActivityForResult(photoPickerIntent, PICK_IMAGE_REQUEST);

                } else if (options[i].equals("Cancel")) {
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            mImageUri = data.getData();
            Toast.makeText(context, "" + mImageUri, Toast.LENGTH_SHORT).show();


            imagePath = getRealPathFromUri(mImageUri);

            ibPhoto.setImageURI(Uri.parse(imagePath));

        }
    }

    private void uploadImage() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Authorization", prefManager.getTokenUser());
        Map<String, RequestBody> bodyMap = new HashMap<>();
        bodyMap.put("name", createPartFromString(tvName.getText().toString()));
        bodyMap.put("email", createPartFromString(tvEmail.getText().toString()));
        bodyMap.put("payment_date", createPartFromString(txtFormDate.getText().toString() + " "));
        bodyMap.put("total_price", createPartFromString(idTotalPrice.getText().toString()));
        bodyMap.put("payment_method", createPartFromString(idPaymentMethod.getText().toString()));
        bodyMap.put("invoice_no", createPartFromString(idInvoice.getText().toString()));
        bodyMap.put("description", createPartFromString(tvDesc.getText().toString()));


        File file = new File(imagePath);
        RequestBody reqFile = RequestBody.create(MediaType.parse("multipart/from-data"), file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("img_pay", file.getName(), reqFile);

        apiInterface.requestConfirmPayment(map, bodyMap, body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {
                            Toast.makeText(mContext, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("FLAGPAGE", 1);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(mContext, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Toast.makeText(mContext, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("ERROR", String.valueOf(t));

            }
        });
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(context, uri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_idx = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_idx);
        cursor.close();
        return result;
    }



    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }
}