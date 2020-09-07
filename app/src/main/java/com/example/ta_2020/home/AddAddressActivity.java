package com.example.ta_2020.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddAddressActivity extends AppCompatActivity {

    Button btnSimpan;
    Spinner spinnerKabKota, spinnerKec, spinnerKel;
    EditText editLokasi;
    Toolbar toolbar;
    ApiInterface apiHelper;
    String idKab,idKec,idKel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        toolbar = findViewById(R.id.toolbarFormAddress);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Checkout");
        btnSimpan = findViewById(R.id.btnSimpan);

        spinnerKabKota = findViewById(R.id.spinnerKabKota);
        spinnerKec = findViewById(R.id.spinnerKecamatan);
        spinnerKel = findViewById(R.id.spinnerKelurahan);

        editLokasi = findViewById(R.id.editLokasi);


        apiHelper = UtilsApi.getApiService();

        fetchKota();

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAddress();
            }
        });

    }

    private void saveAddress() {
        PrefManager manager = new PrefManager(getApplicationContext());
        apiHelper.addAddress(
                manager.getId(),
                idKab,
                idKec,
                idKel,
                editLokasi.getText().toString()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            Toast.makeText(AddAddressActivity.this, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Toast.makeText(AddAddressActivity.this, ""+idKab, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MakeOrderActivity.class);

                            startActivity(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Toast.makeText(AddAddressActivity.this, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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


    private void fetchKota() {
        final ArrayList<String> kota = new ArrayList<>();
        apiHelper.getKota().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject object = new JSONObject(response.body().string());
                        if (object.getString("code").equals("0")) {
                            final JSONArray array = object.getJSONArray("data");
                            for (int i = 0; i <array.length() ; i++) {
                                kota.add(array.getJSONObject(i).getString("nama"));
                            }

                            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.spinner_align, kota);
                            adapter.setDropDownViewResource(R.layout.spinner_align);
                            spinnerKabKota.setAdapter(adapter);

                            spinnerKabKota.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    try {
                                        idKab = array.getJSONObject(position).getString("kota_id");     //untuk addAddress
                                        fetchKecamatan(idKab);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

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

    private void fetchKecamatan(String idKab) {
        final ArrayList<String> kec = new ArrayList<>();
        apiHelper.getKecamatan(idKab).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            final JSONArray array = jsonObject.getJSONArray("data");
                            for (int i = 0; i < array.length(); i++) {
                                kec.add(array.getJSONObject(i).getString("nama"));
                            }

                            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.spinner_align,kec);
                            adapter.setDropDownViewResource(R.layout.spinner_align);
                            spinnerKec.setAdapter(adapter);

                            spinnerKec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    try {
                                        idKec = array.getJSONObject(i).getString("kecamatan_id");
                                        fetchKelurangan(idKec);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });

                        }else {
                            Toast.makeText(getApplicationContext(), "" + jsonObject.getString("message"), Toast.LENGTH_LONG).show();
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

    private void fetchKelurangan(String idKec) {
        final ArrayList<String> kel = new ArrayList<>();
        apiHelper.getKelurahan(idKec).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            final JSONArray array = jsonObject.getJSONArray("data");
                            for (int i = 0; i < array.length(); i++) {
                                kel.add(array.getJSONObject(i).getString("nama"));
                            }

                            ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),R.layout.spinner_align,kel);
                            adapter.setDropDownViewResource(R.layout.spinner_align);
                            spinnerKel.setAdapter(adapter);

                            spinnerKel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    try {
                                        idKel = array.getJSONObject(i).getString("kelurahan_id");
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });
                        }else {
                            Toast.makeText(getApplicationContext(), "" + jsonObject.getString("message"), Toast.LENGTH_LONG).show();
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