package com.student.manager.view.staff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.student.manager.R;
import com.student.manager.databinding.ActivityStaffBinding;
import com.student.manager.view.student.StudentClassListFragment;
import com.student.manager.view.student.StudentNotificationFragment;
import com.student.manager.view.student.StudentProfileFragment;
import com.student.manager.view.student.StudentTimeTableFragment;

public class StaffActivity extends AppCompatActivity {

    ActivityStaffBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStaffBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_container, new StudentTimeTableFragment(), "StatisticalFragment")
                .commit();

        binding.navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_time_table:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_container, new StudentTimeTableFragment(), "TimeTable")
                                .commit();
                        break;
                    case R.id.navigation_class_list:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_container, new StudentClassListFragment(), "ClassList")
                                .commit();
                        break;
                    case R.id.navigation_noti:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_container, new StudentNotificationFragment(), "Notification")
                                .commit();
                        break;
                    case R.id.navigation_profile:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame_container, new StudentProfileFragment(), "Profile")
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
            Toast.makeText(this, getString(R.string.click_again_back), Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    clickBack = false;
                }
            }, 1000L);
        }
    }
}