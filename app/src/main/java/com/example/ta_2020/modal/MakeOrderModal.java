package com.example.ta_2020.modal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ta_2020.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MakeOrderModal extends BottomSheetDialogFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_modal, container, false);

        return view;
    }

}
