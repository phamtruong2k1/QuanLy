package com.student.manager.view.admin.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.student.manager.R;
import com.student.manager.databinding.ActivityAdminBinding;
import com.student.manager.view.admin.manager.AdminManagerFragment;
import com.student.manager.view.admin.statistical.StatisticalFragment;

public class AdminActivity extends AppCompatActivity {


    ActivityAdminBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, new StatisticalFragment(), "StatisticalFragment")
                .commit();

        binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_thong_ke:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_container, new StatisticalFragment(), "StatisticalFragment")
                                .commit();
                        break;
                    case R.id.navigation_admin_manager:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_container, new AdminManagerFragment(), "AdminManagerFragment")
                                .commit();
                        break;
                }
                return true;
            }
        });


    }

    private boolean clickBack = false;
    @Override
    public void onBackPressed() {
        if (clickBack) {
            finish();
        } else {
            clickBack = true;
            Toast.makeText(this, "Nhấn lần nữa để thoát.", Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickBack = false;
                }
            }, 1000L);
        }
    }
}