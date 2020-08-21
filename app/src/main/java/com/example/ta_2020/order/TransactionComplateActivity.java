package com.example.ta_2020.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
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

public class TransactionComplateActivity extends AppCompatActivity {


    @BindView(R.id.toolbarOrderWaiting)
    Toolbar toolbarOrderWaiting;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.tvSelesai)
    TextView tvSelesai;
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
    @BindView(R.id.tvPaymentMethod)
    TextView tvPaymentMethod;

    Context context;
    ApiInterface apiInterface;

    PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_complate);
        ButterKnife.bind(this);

        context=this;
        apiInterface = UtilsApi.getApiService();

        prefManager = new PrefManager(context);

        componentDidMount();


    }

    private void componentDidMount() {
        Intent intent = getIntent();
        final String invoice = intent.getStringExtra("INVOICE");
        apiInterface.getTransactionComplateDetail(prefManager.getTokenUser(), invoice).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){

                            JSONObject data = jsonObject.getJSONObject("data");
                            txtCodeBooking.setText("#"+data.getString("invoice_no"));

                            tvPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getJSONObject("Booking").getJSONObject("Jasa").getInt("jasa_price"))+ ""));
                            tvSubName.setText(data.getJSONObject("Booking").getJSONObject("Jasa").getJSONObject("Sub_category").getString("sub_category_name"));
                            txtCategory.setText(data.getJSONObject("Booking").getJSONObject("Jasa").getJSONObject("Sub_category").getJSONObject("Category").getString("category_name"));
                            txtProdukJasaName.setText(data.getJSONObject("Booking").getJSONObject("Jasa").getString("jasa_name"));
                            tvPaymentMethod.setText(data.getJSONObject("ConPayment").getString("payment_method"));

                            Glide.with(context)
                                    .load(data.getJSONObject("Booking").getJSONObject("Jasa").getJSONObject("Sub_category").getString("img_url"))
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