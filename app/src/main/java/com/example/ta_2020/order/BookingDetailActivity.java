package com.example.ta_2020.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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
    @BindView(R.id.txtDate)
    TextView txtDate;
    @BindView(R.id.txtTime)
    TextView txtTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_detail);
        ButterKnife.bind(this);

        btnPayment = findViewById(R.id.btnPaymentMethode);
        btnPaid = findViewById(R.id.btnPaid);

        context = this;
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
                        if (response.isSuccessful()) {
                            try {
                                JSONObject jsonObject = new JSONObject(response.body().string());
                                if (jsonObject.getString("code").equals("0")) {
                                    Toast.makeText(context, "please check your email", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), PaymentMethodActivity.class));
                                } else {
                                    startActivity(new Intent(getApplicationContext(), PaymentMethodActivity.class));
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
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {

                            JSONObject data = jsonObject.getJSONObject("data");
                            txtCodeBooking.setText("#" + data.getString("invoice_no"));

                            String dtc = data.getString("createdAt");
                            SimpleDateFormat readDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            readDate.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
                            Date date = readDate.parse(dtc);
                            SimpleDateFormat writeDate = new SimpleDateFormat("HH");
                            SimpleDateFormat writeDateM = new SimpleDateFormat("mm");
                            SimpleDateFormat writeDateS = new SimpleDateFormat("ss");
                            writeDate.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            writeDateM.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            writeDateS.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            String hour = writeDate.format(date);
                            String minutes = writeDateM.format(date);
                            String second = writeDateS.format(date);

                            int totalDetikOrder = (Integer.parseInt(hour) * 3600) + (Integer.parseInt(minutes) * 60) + Integer.parseInt(second);
                            countdownPayment(totalDetikOrder);

                            tvPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(data.getJSONObject("Jasa").getInt("jasa_price")) + ""));
                            tvSubName.setText(data.getJSONObject("Jasa").getJSONObject("Sub_category").getString("sub_category_name"));
                            txtCategory.setText(data.getJSONObject("Jasa").getJSONObject("Sub_category").getJSONObject("Category").getString("category_name"));
                            txtProdukJasaName.setText(data.getJSONObject("Jasa").getString("jasa_name"));


                            String dtc2 = data.getString("working_date");
                            SimpleDateFormat readDate2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            readDate2.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
                            Date date2 = readDate2.parse(dtc2);
                            SimpleDateFormat writeDate2 = new SimpleDateFormat("dd-MM-yyyy");
                            writeDate2.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            String s2 = writeDate2.format(date2);
                            txtDate.setText(s2);

                            String dtc3 = data.getString("working_date");
                            SimpleDateFormat readDate3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                            readDate3.setTimeZone(TimeZone.getTimeZone("GMT")); // missing line
                            Date time = readDate3.parse(dtc3);
                            SimpleDateFormat writeDate3 = new SimpleDateFormat("HH:mm");
                            writeDate2.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
                            txtTime.setText(writeDate3.format(time)+" WIB");

                            Glide.with(context)
                                    .load(data.getJSONObject("Jasa").getJSONObject("Sub_category").getString("img_url"))
                                    .centerCrop()
                                    .into(imItem);
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

    private void countdownPayment(int totalDetikOrder) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date = simpleDateFormat.format(calendar.getTime());
        String hour1 = date.substring(0, 2);
        String menit1 = date.substring(3, 5);
        String detik1 = date.substring(6);
        int totalDetikOrderNow = (Integer.parseInt(hour1) * 3600) + (Integer.parseInt(menit1) * 60) + Integer.parseInt(detik1);
        if (totalDetikOrderNow < totalDetikOrder) {
            totalDetikOrderNow += 86400;
        }
        int total = (totalDetikOrderNow - totalDetikOrder);

        new CountDownTimer(3600000 - (total * 1000), 1000) {

            public void onTick(long millisUntilFinished) {

                long i = millisUntilFinished;
                updateTime(i);
                //here you can have your logic to set text to edittext
            }

            private void updateTime(long i) {
                int minute = (int) i / 60000;
                int secons = (int) i % 60000 / 1000;

                String timerLeft = "" + minute;
                timerLeft += ":";
                if (secons < 10) timerLeft += "0";
                timerLeft += secons;
                txtCoundown.setText(timerLeft);


            }

            public void onFinish() {
                txtCoundown.setText("Expired");
            }

        }.start();
    }
}