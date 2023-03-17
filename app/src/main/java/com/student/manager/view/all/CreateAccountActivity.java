package com.student.manager.view.all;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.student.manager.R;
import com.student.manager.databinding.ActivityCreateAccountBinding;
import com.student.manager.ui.login.signin.SignInActivity;
import com.student.manager.view.admin.home.AdminActivity;
import com.student.manager.view.lecturer.LecturerActivity;
import com.student.manager.view.staff.StaffActivity;
import com.student.manager.view.student.StudentActivity;

public class CreateAccountActivity extends AppCompatActivity {

    ActivityCreateAccountBinding binding;

    String roleAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initData();
        initListener();
    }

    private void initData() {
        roleAccount = getIntent().getStringExtra("type_account");
        switch (roleAccount) {
            case "admin":
                binding.accountType.setText("Admin");
                break;
            case "staff":
                binding.accountType.setText("Staff");
                break;
            case "lecturer":
                binding.accountType.setText("Lecturer");
                break;
            default:
                binding.accountType.setText("Student");

                break;
        }
    }

    private void initListener() {
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}