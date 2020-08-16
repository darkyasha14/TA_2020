package com.example.ta_2020.profil;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.ta_2020.R;
import com.example.ta_2020.modal.NameModal;
import com.example.ta_2020.modal.PasswordModal;
import com.example.ta_2020.modal.PhoneModal;
import com.example.ta_2020.modal.UsernameModal;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    @BindView(R.id.ivUser)
    ImageView ivUser;
    @BindView(R.id.tvUsername)
    TextView tvUsername;
    @BindView(R.id.tvEmail)
    TextView tvEmail;
    @BindView(R.id.tvPhone)
    TextView tvPhone;
    @BindView(R.id.tvPasswd)
    TextView tvPasswd;
    @BindView(R.id.tvAbout)
    TextView tvAbout;
    TextView tvName;
    CardView cvUsername, cvEmail, cvPhone, cvPasswd, cvAbout;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        cvUsername= view.findViewById(R.id.cvUsername);
        cvEmail= view.findViewById(R.id.cvEmaik);
        cvPhone= view.findViewById(R.id.cvPhone);
        cvPasswd= view.findViewById(R.id.cvPasswd);
        tvName= view.findViewById(R.id.tvName);

        cvUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsernameModal dialog = new UsernameModal();
                dialog.show(getFragmentManager(),"UsernameModal");
            }
        });
        cvEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NameModal dialog = new NameModal();
                dialog.show(getFragmentManager(),"NameModal");
            }
        });
        cvPasswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PasswordModal dialog = new PasswordModal();
                dialog.show(getFragmentManager(),"PasswordModal");
            }
        });
        cvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneModal dialog = new PhoneModal();
                dialog.show(getFragmentManager(),"PhoneModal");
            }
        });

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NameModal dialog = new NameModal();
                dialog.show(getFragmentManager(),"NameModal");
            }
        });
        return view;
    }
}
