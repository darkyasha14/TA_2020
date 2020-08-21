package com.example.ta_2020.order;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;
import com.example.ta_2020.order.adapter.BookingListAdapter;

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

public class BookingDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbarOrderWaiting)
    Toolbar toolbarOrderWaiting;
    @BindView(R.id.txtCoundown)
    TextView txtCoundown;
    @BindView(R.id.txtCodeBooking)
    TextView txtCodeBooking;
    @BindView(R.id.imItem)
    ImageView imItem;
    @BindView(R.id.tvSubName)
    TextView tvSubName;
    @BindView(R.id.tvPrice)
    TextView tvPrice;
    @BindView(R.id.txtCategory)
    TextView txtCategory;
    @BindView(R.id.txtProdukJasaName)
    TextView txtProdukJasaName;

    Context context;
    ApiInterface apiInterface;

    PrefManager prefManager;

    Button btnPayment, btnPaid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);
        ButterKnife.bind(this);

        btnPayment = findViewById(R.id.btnPaymentMethode);
        btnPaid = findViewById(R.id.btnPaid);

        context=this;
        apiInterface = UtilsApi.getApiService();

        prefManager = new PrefManager(context);

        componentDidMount();

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                apiInterface.getPaymentMethod(prefManager.getTokenUser(), prefManager.getId(), intent.getStringExtra("eINVOICE")).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            try {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                if (jsonObject.getString("code").equals("0")){
                                    Toast.makeText(context, "please check your email", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(context, "we have been send payment method to your email", Toast.LENGTH_SHORT).show();
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
        });

        btnPaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ConfirmPaymentActivity.class);
                startActivity(intent);
            }
        });
    }

    private void componentDidMount() {
        Intent intent = getIntent();
        final String invoice = intent.getStringExtra("eINVOICE");
        apiInterface.getBookingDetail(prefManager.getTokenUser(), invoice).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){

                            JSONObject data = jsonObject.getJSONObject("data");
                            txtCodeBooking.setText("#"+data.getString("invoice_no"));

                            tvPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getJSONObject("Jasa").getInt("jasa_price"))+ ""));
                            tvSubName.setText(data.getJSONObject("Jasa").getJSONObject("Sub_category").getString("sub_category_name"));
                            txtCategory.setText(data.getJSONObject("Jasa").getJSONObject("Sub_category").getJSONObject("Category").getString("category_name"));
                            txtProdukJasaName.setText(data.getJSONObject("Jasa").getString("jasa_name"));

                            Glide.with(context)
                                    .load(data.getJSONObject("Jasa").getJSONObject("Sub_category").getString("img_url"))
                                    .centerCrop()
                                    .into(imItem);
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
}