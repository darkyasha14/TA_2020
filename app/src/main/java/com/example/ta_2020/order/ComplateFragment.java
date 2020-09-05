package com.example.ta_2020.order;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;
import com.example.ta_2020.order.adapter.BookingListAdapter;
import com.example.ta_2020.order.adapter.TransactionComplateAdapter;
import com.example.ta_2020.order.model.BookingList;
import com.example.ta_2020.order.model.TransactionComplate;
import com.example.ta_2020.profil.ProgressDialog;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComplateFragment extends Fragment {

    RecyclerView rvComplate;
    Context context;
    ApiInterface apiInterface;

    TransactionComplateAdapter transactionComplateAdapter;

    List<TransactionComplate.DataBean> dataBeans;

    PrefManager prefManager;

    ProgressDialog progressDialog;

    public ComplateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complate, container, false);
        rvComplate=view.findViewById(R.id.rvComplateList);
        context=view.getContext();
        apiInterface = UtilsApi.getApiService();

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.showDialog();


        prefManager = new PrefManager(view.getContext());

        apiInterface.getTransactionComplateList(prefManager.getTokenUser(), prefManager.getId()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            progressDialog.hideDialog();
                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            dataBeans = new ArrayList<>();
                            Gson gson = new Gson();
                            for (int i = jsonArray.length() - 1; i>=0; i--){
                                TransactionComplate.DataBean dataBean = gson.fromJson(jsonArray.getJSONObject(i).toString(), TransactionComplate.DataBean.class);
                                dataBeans.add(dataBean);
                            }

                            transactionComplateAdapter = new TransactionComplateAdapter(context, dataBeans);
                            rvComplate.setLayoutManager(new LinearLayoutManager(context));
                            rvComplate.setAdapter(transactionComplateAdapter);

                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        Toast.makeText(context, "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        progressDialog.hideDialog();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progressDialog.hideDialog();

            }
        });

        return view;
    }
}
