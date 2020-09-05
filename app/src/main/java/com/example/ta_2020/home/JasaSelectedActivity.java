package com.example.ta_2020.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;
import com.example.ta_2020.home.adapter.JasaAdapter;
import com.example.ta_2020.home.model.Jasa;
import com.example.ta_2020.interfaces.ProductJasaInterface;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JasaSelectedActivity extends AppCompatActivity {

    @BindView(R.id.txtDetailJasa)
    TextView txtDetailJasa;
    @BindView(R.id.recyclerJasa)
    RecyclerView rvJasa;
    @BindView(R.id.tHarga)
    TextView tHarga;
    @BindView(R.id.tPrice)
    TextView tPrice;

    Button btnOrder;

    boolean flags = false;
    int idJasaSelected;

    Toolbar toolbar;
    ApiInterface apiInterface;
    Context context;

    PrefManager prefManager;

    List<Jasa.DataBean.JasasBean> dataBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jasa_selected);
        ButterKnife.bind(this);

        btnOrder= findViewById(R.id.buttonPesan);
        toolbar = findViewById(R.id.toolbarDetailJasa);
        tPrice = findViewById(R.id.tPrice);
        context = this;
        apiInterface = UtilsApi.getApiService();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");

        prefManager = new PrefManager(context);

        Intent intent = getIntent();

        fetchJasa(intent);


    }

    private void fetchJasa(Intent intent) {
        final String name = intent.getStringExtra("eNAME");
        final int id = intent.getIntExtra("eID", 1);
        apiInterface.getJasa(prefManager.getTokenUser(), id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            final JSONArray jsonArray1 = new JSONArray(jsonArray.getJSONObject(0).getString("Jasas"));

                            dataBeans = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = 0; i < jsonArray1.length(); i++){
                                Jasa.DataBean.JasasBean dataBean = gson.fromJson(jsonArray1.get(i).toString(), Jasa.DataBean.JasasBean.class);
                                dataBeans.add(dataBean);
                            }

                            txtDetailJasa.setText(name);

                            JasaAdapter jasaAdapter = new JasaAdapter(context, dataBeans, new ProductJasaInterface() {
                                @Override
                                public void onItemClick(int id, boolean flag) {
                                    if (id != -1) {
                                        tPrice.setText((NumberFormat.getCurrencyInstance(new Locale("in", "ID")).format(dataBeans.get(id).getJasa_price()) + ""));
                                        idJasaSelected = dataBeans.get(id).getJasa_id();
                                        flags = flag;
                                    }

                                }
                            });
                            rvJasa.setAdapter(jasaAdapter);
                            rvJasa.setHasFixedSize(true);
                            rvJasa.setLayoutManager(new LinearLayoutManager(context));
                            rvJasa.setNestedScrollingEnabled(false);

                            btnOrder.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    if (flags) {
//                                        MakeOrderModal orderModalSheet = new MakeOrderModal();
//                                        Bundle bundle = new Bundle();
//                                        bundle.putInt("idJasa", idJasaSelected);
//                                        orderModalSheet.setArguments(bundle);
//                                        orderModalSheet.show(getSupportFragmentManager(), "");
                                        Intent intent = new Intent(getApplicationContext(), MakeOrderActivity.class);
                                        intent.putExtra("idJasa", idJasaSelected);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(JasaSelectedActivity.this, "Jasa not found", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
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