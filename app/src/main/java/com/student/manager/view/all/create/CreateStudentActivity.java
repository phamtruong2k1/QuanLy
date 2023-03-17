package com.student.manager.view.all.create;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.student.manager.R;
import com.student.manager.dao.AccountDAO;
import com.student.manager.dao.StudentDAO;
import com.student.manager.databinding.ActivityCreateStudentBinding;
import com.student.manager.model.Student;
import com.student.manager.util.DataUtil;

public class CreateStudentActivity extends AppCompatActivity {

    ActivityCreateStudentBinding binding;

    int accountId;
    int gender = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        initData();
        initView();
        initListener();
        
    }

    private void initListener() {
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountDAO.deleteAccount(accountId);
                finish();
            }
        });
        binding.rdgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rdMale:
                        gender = 1;
                        break;
                    case R.id.rdFemale:
                        gender = 2;
                        break;
                }
            }
        });
        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtName.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStudentActivity.this, "Enter Name!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtDateOfBirth.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStudentActivity.this, "Enter Date Of Birth!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtAddress.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStudentActivity.this, "Enter Address!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtPhone.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStudentActivity.this, "Enter Phone!", Toast.LENGTH_SHORT).show();
                } else {
                    Student student = new Student(
                            0,
                            accountId,
                            binding.edtName.getText().toString().trim(),
                            gender,
                            binding.edtDateOfBirth.getText().toString().trim(),
                            binding.edtAddress.getText().toString().trim(),
                            binding.edtPhone.getText().toString().trim(),
                            1,
                            DataUtil.getDate(),
                            1
                    );
                    StudentDAO.insertStudent(student);
                    finish();
                }
            }
        });
    }

    private void initView() {
        gender = 1;
        binding.rdMale.setChecked(true);
    }

    private void initData() {
        accountId = getIntent().getIntExtra("accountId", 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AccountDAO.deleteAccount(accountId);
    }
}