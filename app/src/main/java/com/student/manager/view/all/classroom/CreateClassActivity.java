package com.student.manager.view.all.classroom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import com.student.manager.R;
import com.student.manager.databinding.ActivityCreateClassBinding;

public class CreateClassActivity extends AppCompatActivity {

    ActivityCreateClassBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}