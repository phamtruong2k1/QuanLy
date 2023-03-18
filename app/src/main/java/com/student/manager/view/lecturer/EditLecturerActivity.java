package com.student.manager.view.lecturer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.student.manager.R;
import com.student.manager.dao.AccountDAO;
import com.student.manager.dao.LecturerDAO;
import com.student.manager.databinding.ActivityEditLecturerBinding;
import com.student.manager.model.Lecturer;

public class EditLecturerActivity extends AppCompatActivity {

    ActivityEditLecturerBinding binding;

    int lecturer_id ;
    Lecturer lecturer;
    int gender = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditLecturerBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        initData();
        initListener();
    }

    private void initListener() {
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
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();
            }
        });

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtName.getText().toString().trim().equals("")) {
                    Toast.makeText(EditLecturerActivity.this, "Enter Name!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtDateOfBirth.getText().toString().trim().equals("")) {
                    Toast.makeText(EditLecturerActivity.this, "Enter Date Of Birth!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtAddress.getText().toString().trim().equals("")) {
                    Toast.makeText(EditLecturerActivity.this, "Enter Address!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtPhone.getText().toString().trim().equals("")) {
                    Toast.makeText(EditLecturerActivity.this, "Enter Phone!", Toast.LENGTH_SHORT).show();
                } else {
                    Lecturer lecturerNew = new Lecturer(
                            lecturer.getLecturer_id(),
                            lecturer.getAccountId(),
                            binding.edtName.getText().toString().trim(),
                            gender,
                            binding.edtDateOfBirth.getText().toString().trim(),
                            binding.edtAddress.getText().toString().trim(),
                            binding.edtPhone.getText().toString().trim(),
                            lecturer.getDate_of_join(),
                            lecturer.getStatus()
                    );
                    LecturerDAO.updateLecturer(lecturerNew);
                    finish();
                }
            }
        });
    }

    private void initData() {
        lecturer_id = getIntent().getIntExtra("lecturer_id", 0);
        lecturer = LecturerDAO.getLecturerById(lecturer_id);
        binding.edtName.setText(lecturer.getName());
        binding.edtDateOfBirth.setText(lecturer.getDate_of_birth());
        binding.edtAddress.setText(lecturer.getAddress());
        binding.edtPhone.setText(lecturer.getPhone_number());
        gender = lecturer.getGender();
        if (gender == 1) {
            binding.rdMale.setChecked(true);
        } else  {
            binding.rdFemale.setChecked(true);
        }
    }

    void delete(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Delete!!!");
        alertDialogBuilder.setMessage("Delete this Staff?");
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                AccountDAO.deleteAccount(lecturer.getAccountId());
                LecturerDAO.deleteLecturer(lecturer_id);
                finish();
            }
        });
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {}
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}