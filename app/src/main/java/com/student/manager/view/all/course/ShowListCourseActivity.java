package com.student.manager.view.all.course;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.student.manager.R;
import com.student.manager.databinding.ActivityShowListCourseBinding;

public class ShowListCourseActivity extends AppCompatActivity {

    ActivityShowListCourseBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowListCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}