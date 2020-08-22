package com.example.ta_2020.order;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

    private int STORAGE_PERMISSION_CODE = 1;

    ImageButton ibPhoto;

    ApiInterface apiInterface;
    PrefManager prefManager;
    Context context;

    Toolbar toolbar;
    Calendar calendar, calender1;
    DatePickerDialog dialog;
    Time time;
    TimePickerDialog dialog1;
    Context mContext = this;

    private static final int CAMERA_REQUEST = 1888;

    Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_onfirm_payment);
        ButterKnife.bind(this);

        ibPhoto=findViewById(R.id.ibPhoto);

        apiInterface = UtilsApi.getApiService();
        prefManager = new PrefManager(this);
        context =this;

        ibPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeImage();
            }
        });


    }
    private File createTempFile(Bitmap bitmap) {
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                , System.currentTimeMillis() +"_image.webp");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.WEBP,0, bos);
        byte[] bitmapdata = bos.toByteArray();
        //write the bytes in file

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bitmapdata);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private void takeImage() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }
    //untuk mengambil gambar hasil capture camera tadi kita harus override onActivityResult dan membaca resultCode apakah sukses dan requestCode apakah dari Camera_Request
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap gambarbitmap = (Bitmap) data.getExtras().get("data");
            //panggil method uploadImage
            uploadImage(gambarbitmap);


        }
    }

    private void uploadImage(final Bitmap gambarbitmap) {

        btnPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                //convert gambar jadi File terlebih dahulu dengan memanggil createTempFile yang di atas tadi.
                File file = createTempFile(gambarbitmap);
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
        });



    }

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }
}