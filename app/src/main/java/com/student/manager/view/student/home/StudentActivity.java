package com.student.manager.view.student.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.student.manager.R;
import com.student.manager.databinding.ActivitySignInBinding;
import com.student.manager.databinding.ActivityStudentBinding;
import com.student.manager.view.admin.manager.AdminManagerFragment;
import com.student.manager.view.admin.statistical.StatisticalFragment;
import com.student.manager.view.student.classlist.StudentClassListFragment;
import com.student.manager.view.student.noti.StudentNotificationFragment;
import com.student.manager.view.student.profile.StudentProfileFragment;
import com.student.manager.view.student.timetable.StudentTimeTableFragment;

public class StudentActivity extends AppCompatActivity {

    ActivityStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentBinding.inflate(getLayoutInflater());
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