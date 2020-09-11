package com.example.ta_2020.modal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ta_2020.MainActivity;
import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MakeOrderModal extends BottomSheetDialogFragment {

    Button btnOrder;

    PrefManager prefManager;
    ApiInterface apiInterface;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_modal, container, false);

        btnOrder = view.findViewById(R.id.btnMakeOrder);

        apiInterface = UtilsApi.getApiService();
        prefManager = new PrefManager(view.getContext());
        context =view.getContext();

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               makeOrder();
            }
        });
        return view;
    }

    private void makeOrder() {
        Bundle bundle = getArguments();
        final int idjasa =  bundle.getInt("idJasa", 1);
        apiInterface.makeOrder(prefManager.getTokenUser(), prefManager.getId(), idjasa, prefManager.getIdAdd()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    Log.i("debug", "onResponse: SUCCESS");
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            Intent intent = new Intent(context, MainActivity.class);
                            intent.putExtra("FLAGPAGE", 1);
                            startActivity(intent);
                            getActivity().finish();
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }else {
                    Log.e("debug", "onResponse: ERR");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

}
