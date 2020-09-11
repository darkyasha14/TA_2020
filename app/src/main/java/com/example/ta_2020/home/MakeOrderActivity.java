package com.example.ta_2020.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.ta_2020.MainActivity;
import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakeOrderActivity extends AppCompatActivity {

    @BindView(R.id.tvCategory)
    TextView tvCategory;
    @BindView(R.id.ivSub)
    ImageView ivSub;
    @BindView(R.id.tvSubName)
    TextView tvSubName;
    @BindView(R.id.tvJasa)
    TextView tvJasa;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.tHarga)
    TextView tHarga;
    @BindView(R.id.tvTotal)
    TextView tPrice;

    PrefManager prefManager;
    ApiInterface apiInterface;
    Context context;
    @BindView(R.id.tvAddress)
    TextView tvAddress;
    @BindView(R.id.chkValid)
    CheckBox chkValid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        ButterKnife.bind(this);

        Button btnOrder = findViewById(R.id.buttonPesan);
        Toolbar toolbar = findViewById(R.id.toolbarOrder);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Checkout");

        context = this;
        apiInterface = UtilsApi.getApiService();


        prefManager = new PrefManager(context);

        tvAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddAddressActivity.class));
                finish();
            }
        });

        fecthAddress();
        fecthItem();

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chkValid.isChecked()) {
                    makeOrder();
                }else {
                    Toast.makeText(context, "make sure add your address, and check the checkbox", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void fecthItem() {
        Intent intent = getIntent();
        final int idjasa = intent.getIntExtra("idJasa", 1);
        apiInterface.getjasaDetail(prefManager.getTokenUser(), idjasa).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {
                            JSONObject data = jsonObject.getJSONObject("data");

                            tvJasa.setText(data.getString("jasa_name"));
                            tvSubName.setText(data.getJSONObject("Sub_category").getString("sub_category_name"));
                            tvCategory.setText(data.getJSONObject("Sub_category").getJSONObject("Category").getString("category_name"));
                            Glide.with(context)
                                    .load(data.getJSONObject("Sub_category").getString("img_url"))
                                    .centerCrop()
                                    .into(ivSub);
                            tvPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getInt("jasa_price")) + ""));
                            tPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getInt("jasa_price")) + ""));

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void fecthAddress() {
        apiInterface.getAddress(prefManager.getId(), prefManager.getIdAdd()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            JSONObject jsonData = jsonObject.getJSONObject("data");

                            tvAddress.setText(jsonData.getString("detail_address")+",\n"+
                                    jsonData.getJSONObject("Kelurahan").getString("nama")+",\n"+
                                    jsonData.getJSONObject("Kelurahan").getJSONObject("Kecamatan").getString("nama")+",\n"+
                                    jsonData.getJSONObject("Kelurahan").getJSONObject("Kecamatan").getJSONObject("Kotum").getString("nama")+", ID "+
                                    jsonData.getString("kota_id"));

                        }else{

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void makeOrder() {
        Intent intent = getIntent();
        final int idjasa = intent.getIntExtra("idJasa", 1);
        apiInterface.makeOrder(prefManager.getTokenUser(), prefManager.getId(), idjasa, prefManager.getIdAdd()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Log.i("debug", "onResponse: SUCCESS");
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {
                            Intent intent = new Intent(context, MainActivity.class);
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
                    Log.e("debug", "onResponse: ERR");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}