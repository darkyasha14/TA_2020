package com.example.ta_2020.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        ButterKnife.bind(this);

        Button btnOrder = findViewById(R.id.buttonPesan);
        Toolbar toolbar = findViewById(R.id.toolbarDetailJasa);

        context = this;
        apiInterface = UtilsApi.getApiService();


        prefManager = new PrefManager(context);

        fecthAddress();
        fecthItem();

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tvAddress.getText().toString())) {
                    tvAddress.setError("please add your address");
                    return;
                }else {
                    makeOrder();
                }


            }
        });
    }

    private void fecthItem() {
        Intent intent = getIntent();
        final int idjasa = intent.getIntExtra("idJasa", 1);
        apiInterface.getjasaDetail(prefManager.getTokenUser(),idjasa).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            JSONObject data = jsonObject.getJSONObject("data");

                            tvJasa.setText(data.getString("jasa_name"));
                            tvSubName.setText(data.getJSONObject("Sub_category").getString("sub_category_name"));
                            tvCategory.setText(data.getJSONObject("Sub_category").getJSONObject("Category").getString("category_name"));
                            Glide.with(context)
                                    .load(data.getJSONObject("Sub_category").getString("img_url"))
                                    .centerCrop()
                                    .into(ivSub);
                            tvPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getInt("jasa_price"))+ ""));
                            tPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getInt("jasa_price"))+ ""));

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
//        apiInterface.getAddress(prefManager.getId()).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()){
//                    try {
//                        JSONObject jsonObject = new JSONObject(response.body().string());
//                        if (jsonObject.getString("code").equals("0")){
//                            JSONObject data = jsonObject.getJSONObject("data");
//
//                            tvAddress.setText(data.getString("detail_address") +"/n"+ data.getString("kelurahan_id") );
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
    }

    private void makeOrder() {
        Intent intent = getIntent();
        final int idjasa = intent.getIntExtra("idJasa", 1);
        apiInterface.makeOrder(prefManager.getTokenUser(), prefManager.getId(), idjasa).enqueue(new Callback<ResponseBody>() {
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
}