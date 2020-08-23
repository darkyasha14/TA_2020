package com.example.ta_2020.modal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ta_2020.MainActivity;
import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneModal extends BottomSheetDialogFragment {
    ApiInterface apiInterface;
    PrefManager prefManager;
    @BindView(R.id.txtData)
    TextView txtData;
    @BindView(R.id.editNama)
    EditText editNama;
    @BindView(R.id.btnSaveName)
    Button btnSaveName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.phone_modal, container, false);
        prefManager = new PrefManager(view.getContext());
        apiInterface = UtilsApi.getApiService();
        ButterKnife.bind(this, view);
        getDataUser();
        return view;
    }

    private void getDataUser() {
        apiInterface.getUserData(prefManager.getTokenUser(),
                prefManager.getId()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            final JSONObject jsonObject2 = jsonObject1.getJSONObject("User");

                            editNama.setText(jsonObject1.getString("phone"));

                            btnSaveName.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    updatePhone();
                                }
                            });


                        } else {
                            Toast.makeText(getContext(), "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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

    private void updatePhone() {
        Map<String, String> map = new HashMap<>();
        map.put("Authorization", prefManager.getTokenUser());

        Map<String, RequestBody> bodyMap = new HashMap<>();
        bodyMap.put("user_id", createPartFromString(prefManager.getId() + ""));
        bodyMap.put("phone", createPartFromString(editNama.getText().toString()));

        apiInterface.updateProfile(map, bodyMap, null).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            Intent intent1 = new Intent(getContext(), MainActivity.class);
                            intent1.putExtra("FLAGPAGE", 2);
                            startActivity(intent1);
                            getActivity().finish();
                        }else{
                            Toast.makeText(getContext(), "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
                Log.d(TAG, "onFailure: " + t.getStackTrace());
            }
        });

        /*apiInterface.updatePhone(map,
                bodyMap,
                null).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")){
                            Toast.makeText(getContext(), "Update Phone number success", Toast.LENGTH_SHORT).show();
                            Intent intent1 = new Intent(getContext(), MainActivity.class);
                            intent1.putExtra("FLAGPAGE", 2);
                            startActivity(intent1);
                            getActivity().finish();
                        }else{
                            Toast.makeText(getContext(), "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getContext(), "Internet Problem", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                MediaType.parse("text/plain"), descriptionString);
    }
}
