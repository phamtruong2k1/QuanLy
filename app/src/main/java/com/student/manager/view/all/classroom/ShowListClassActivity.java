package com.student.manager.view.all.classroom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.student.manager.R;
import com.student.manager.dao.ClassRoomDAO;
import com.student.manager.databinding.ActivityShowListClassBinding;
import com.student.manager.model.ClassRoom;

import java.util.ArrayList;

public class ShowListClassActivity extends AppCompatActivity {

    ActivityShowListClassBinding binding;

    ClassroomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowListClassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter = new ClassroomAdapter(ShowListClassActivity.this, new ArrayList<>(), new ClickClassroom() {
            @Override
            public void clickClassroom(ClassRoom classroom) {

            }
        });

        binding.rcyList.setAdapter(adapter);

        initData();
        initListener();
    }

    private void initListener() {
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShowListClassActivity.this, CreateClassActivity.class));
            }
        });
    }

    private void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setData(ClassRoomDAO.getListClassRoom());
    }
}