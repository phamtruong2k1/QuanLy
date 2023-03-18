package com.student.manager.view.student;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.student.manager.databinding.ActivityEditStudentBinding;

public class EditStudentActivity extends AppCompatActivity {

    private ActivityEditStudentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}