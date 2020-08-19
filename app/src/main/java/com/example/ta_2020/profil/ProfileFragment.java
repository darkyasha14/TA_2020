package com.example.ta_2020.profil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.ta_2020.PrefManager;
import com.example.ta_2020.R;
import com.example.ta_2020.apihelper.ApiInterface;
import com.example.ta_2020.apihelper.UtilsApi;
import com.example.ta_2020.auth.LoginActivity;
import com.example.ta_2020.modal.EmailModal;
import com.example.ta_2020.modal.NameModal;
import com.example.ta_2020.modal.PasswordModal;
import com.example.ta_2020.modal.PhoneModal;
import com.example.ta_2020.modal.UsernameModal;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    ApiInterface apiInterface;
    PrefManager prefManager;
    @BindView(R.id.ivUser)
    ImageView ivUser;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvUsername)
    TextView tvUsername;
    @BindView(R.id.cvUsername)
    CardView cvUsername;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.cvEmaik)
    CardView cvEmaik;
    @BindView(R.id.tvPhone)
    TextView tvPhone;
    @BindView(R.id.cvPhone)
    CardView cvPhone;
    @BindView(R.id.tvPasswd)
    TextView tvPasswd;
    @BindView(R.id.cvPasswd)
    CardView cvPasswd;
    @BindView(R.id.tvAbout)
    TextView tvAbout;
    @BindView(R.id.cvAbout)
    CardView cvAbout;

    CardView cvExit;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_profil, container, false);
        apiInterface = UtilsApi.getApiService();
        prefManager = new PrefManager(view.getContext());
        ButterKnife.bind(this, view);

        cvExit = view.findViewById(R.id.cvExit);

        cvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Are you sure?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                PrefManager prefManager = new PrefManager(view.getContext());
                                prefManager.removeSession();
                                prefManager.spString(PrefManager.SP_TOKEN_USER, "");
                                prefManager.spInt(PrefManager.SP_ID, -1);
                                getActivity().finish();
                                Intent intent = new Intent(view.getContext(), LoginActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        initGetUserProfile();
        return view;
    }

    private void initGetUserProfile() {
        apiInterface.getUserData(prefManager.getTokenUser(),
                prefManager.getId()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getString("code").equals("0")) {
                            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                            JSONObject jsonObject2 = jsonObject1.getJSONObject("User");
                            tvName.setText(jsonObject2.getString("name"));
                            tvUsername.setText(jsonObject2.getString("username"));
                            tvEmail.setText(jsonObject2.getString("email"));
                            if (jsonObject1.getString("phone").equals("null")){
                                tvPhone.setText("update phone number");
                            }else{
                                tvPhone.setText(jsonObject1.getString("phone"));
                            }

                            cvUsername.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    UsernameModal dialog = new UsernameModal();
                                    dialog.show(getFragmentManager(), "UsernameModal");
                                }
                            });
                            cvEmaik.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    EmailModal dialog = new EmailModal();
                                    dialog.show(getFragmentManager(), "NameModal");
                                }
                            });
                            cvPasswd.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PasswordModal dialog = new PasswordModal();
                                    dialog.show(getFragmentManager(), "PasswordModal");
                                }
                            });
                            cvPhone.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    PhoneModal dialog = new PhoneModal();
                                    dialog.show(getFragmentManager(), "PhoneModal");
                                }
                            });

                            tvName.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    NameModal dialog = new NameModal();
                                    dialog.show(getFragmentManager(), "NameModal");
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
                Toast.makeText(getContext(), "Internet Problem", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
