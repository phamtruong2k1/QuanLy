package com.student.manager.view.all.classroom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.student.manager.R;
import com.student.manager.dao.ClassRoomDAO;
import com.student.manager.dao.CourseDAO;
import com.student.manager.dao.LecturerDAO;
import com.student.manager.databinding.ActivityCreateClassBinding;
import com.student.manager.model.ClassRoom;
import com.student.manager.model.Course;
import com.student.manager.util.DataUtil;
import com.student.manager.view.all.course.CreateCoureActivity;

public class CreateClassActivity extends AppCompatActivity {

    ActivityCreateClassBinding binding;

    int course_id = 0;
    int lecturer_id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initData();
        initListener();
    }

    private void initListener() {
        binding.btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edtName.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateClassActivity.this, "Enter Name!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtStartDate.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateClassActivity.this, "Enter Start Date!", Toast.LENGTH_SHORT).show();
                } else if (binding.edtEndDate.getText().toString().trim().equals("")) {
                    Toast.makeText(CreateClassActivity.this, "Enter End Date!", Toast.LENGTH_SHORT).show();
                } else {
                    ClassRoomDAO.insertClassRoom(new ClassRoom(
                            0,
                            course_id,
                            lecturer_id,
                            binding.edtName.getText().toString().trim(),
                            binding.edtStartDate.getText().toString().trim(),
                            binding.edtEndDate.getText().toString().trim()
                    ));
                    finish();
                }
            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        binding.spCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                course_id = CourseDAO.getListCourse().get(i).getCourse_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.spLecturer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lecturer_id = LecturerDAO.getListLecturer().get(i).getLecturer_id();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initData() {
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                CourseDAO.getListCourse());
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        binding.spCourse.setAdapter(ad);

        ArrayAdapter ad2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                LecturerDAO.getListLecturer());
        ad2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        binding.spLecturer.setAdapter(ad2);
    }
}