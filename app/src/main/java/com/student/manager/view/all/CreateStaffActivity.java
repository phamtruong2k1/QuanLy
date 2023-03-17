package com.student.manager.view.all;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.student.manager.R;
import com.student.manager.dao.AccountDAO;
import com.student.manager.dao.StaffDAO;
import com.student.manager.dao.StudentDAO;
import com.student.manager.databinding.ActivityCreateStaffBinding;
import com.student.manager.databinding.ActivityCreateStudentBinding;
import com.student.manager.model.Staff;
import com.student.manager.model.Student;
import com.student.manager.util.DataUtil;

public class CreateStaffActivity extends AppCompatActivity {

    ActivityCreateStaffBinding binding;

    int accountId;
    int gender = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateStaffBinding.inflate(getLayoutInflater());
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
                    Toast.makeText(CreateStaffActivity.this, "Enter Name!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtDateOfBirth.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStaffActivity.this, "Enter Date Of Birth!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtAddress.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStaffActivity.this, "Enter Address!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtPhone.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateStaffActivity.this, "Enter Phone!", Toast.LENGTH_SHORT).show();
                } else {
                    Staff staff = new Staff(
                            0,
                            accountId,
                            binding.edtName.getText().toString().trim(),
                            gender,
                            binding.edtDateOfBirth.getText().toString().trim(),
                            binding.edtAddress.getText().toString().trim(),
                            binding.edtPhone.getText().toString().trim(),
                            DataUtil.getDate(),
                            1
                    );
                    StaffDAO.insertStaff(staff);
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