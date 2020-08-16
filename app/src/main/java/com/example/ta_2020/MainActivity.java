package com.example.ta_2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ta_2020.home.HomeFragment;
import com.example.ta_2020.order.OrderFragment;
import com.example.ta_2020.profil.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initBottomView();

    }

    private void initBottomView() {
        Intent intent = getIntent();
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        changeFragment(new HomeFragment(), HomeFragment.class
                                .getSimpleName());
                        break;
                    case R.id.nav_order:
                        changeFragment(new OrderFragment(), OrderFragment.class
                                .getSimpleName());
                        break;
                    case R.id.nav_profil:
                        changeFragment(new ProfileFragment(), ProfileFragment.class
                                .getSimpleName());
                        break;
                }
                return true;
            }
        });
        int flag = intent.getIntExtra("FLAGPAGE", 0);
        if (flag == 1) {
            changeFragment(new OrderFragment(), OrderFragment.class
                    .getSimpleName());
            bottomNav.setSelectedItemId(R.id.nav_order);
        } else if (flag == 2) {
            changeFragment(new ProfileFragment(), ProfileFragment.class
                    .getSimpleName());
            bottomNav.setSelectedItemId(R.id.nav_profil);
        }else {
            changeFragment(new HomeFragment(), HomeFragment.class
                    .getSimpleName());

            bottomNav.setSelectedItemId(R.id.nav_home);
        }
    }
    public void changeFragment(Fragment fragment, String tagFragmentName) {

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        Fragment currentFragment = mFragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragmentTemp = mFragmentManager.findFragmentByTag(tagFragmentName);
        if (fragmentTemp == null) {
            fragmentTemp = fragment;
            fragmentTransaction.add(R.id.fragment_container, fragmentTemp, tagFragmentName);
        } else {
            fragmentTransaction.show(fragmentTemp);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragmentTemp);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNowAllowingStateLoss();
    }
}
