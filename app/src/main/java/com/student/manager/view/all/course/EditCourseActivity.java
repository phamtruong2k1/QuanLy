package com.student.manager.view.all.course;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.student.manager.R;
import com.student.manager.databinding.ActivityEditCourseBinding;

public class EditCourseActivity extends AppCompatActivity {

    ActivityEditCourseBinding binding;
    int course_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
    }

    private void initData() {
        course_id = getIntent().getIntExtra("course_id", 0);
    }
}