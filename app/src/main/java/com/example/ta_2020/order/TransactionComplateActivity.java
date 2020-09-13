package com.example.ta_2020.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
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
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.txtTime)
    TextView txtTime;

    Button btnOrderAgain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_complate);
        ButterKnife.bind(this);

        btnOrderAgain = findViewById(R.id.btnOrderAgain);

        context = this;
        apiInterface = UtilsApi.getApiService();

        prefManager = new PrefManager(context);

        componentDidMount();

        btnOrderAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });


    }

    private void componentDidMount() {
        Intent intent = getIntent();
        final String invoice = intent.getStringExtra("INVOICE");
        apiInterface.getTransactionComplateDetail(prefManager.getTokenUser(), invoice).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {

                            JSONObject data = jsonObject.getJSONObject("data");
                            txtCodeBooking.setText("#" + data.getString("invoice_no"));

                            tvPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getJSONObject("Booking").getJSONObject("Jasa").getInt("jasa_price")) + ""));
                            tvSubName.setText(data.getJSONObject("Booking").getJSONObject("Jasa").getJSONObject("Sub_category").getString("sub_category_name"));
                            txtCategory.setText(data.getJSONObject("Booking").getJSONObject("Jasa").getJSONObject("Sub_category").getJSONObject("Category").getString("category_name"));
                            txtProdukJasaName.setText(data.getJSONObject("Booking").getJSONObject("Jasa").getString("jasa_name"));
                            tvPaymentMethod.setText(data.getJSONObject("ConPayment").getString("payment_method"));

                            Glide.with(context)
                                    .load(data.getJSONObject("Booking").getJSONObject("Jasa").getJSONObject("Sub_category").getString("img_url"))
                                    .centerCrop()
                                    .into(imItem);

                            String dtc2 = data.getJSONObject("Booking").getString("working_date");
                            SimpleDateFormat readDate2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            readDate2.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
                            Date date2 = readDate2.parse(dtc2);
                            SimpleDateFormat writeDate2 = new SimpleDateFormat("dd-MM-yyyy");
                            writeDate2.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            String s2 = writeDate2.format(date2);
                            txtDate.setText(s2);

                            String dtc3 = data.getJSONObject("Booking").getString("working_date");
                            SimpleDateFormat readDate3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            readDate3.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
                            Date time = readDate3.parse(dtc3);
                            SimpleDateFormat writeDate3 = new SimpleDateFormat("HH:mm");
                            writeDate2.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            txtTime.setText(writeDate3.format(time) + " WIB");
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ParseException e) {
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