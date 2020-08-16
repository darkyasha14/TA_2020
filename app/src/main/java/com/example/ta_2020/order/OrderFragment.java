package com.example.ta_2020.order;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.ta_2020.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

public class OrderFragment extends Fragment {


    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order, container, false);
//        getActivity().getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
//                        View.SYSTEM_UI_FLAG_FULLSCREEN);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPager viewPager = view.findViewById(R.id.vPager);
        TabLayout tabLayout = view.findViewById(R.id.tablayout);

        tabLayout.setupWithViewPager(viewPager);

        PagerOrderAdapter adapter = new PagerOrderAdapter(getChildFragmentManager());
        adapter.addFrag(new ActiveFragment(), "ORDER");
        adapter.addFrag(new ComplateFragment(), "COMPLATE");
        viewPager.setAdapter(adapter);
    }
}
