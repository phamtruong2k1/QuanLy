package com.student.manager.view.student;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.manager.R;
import com.student.manager.databinding.FragmentStaffManagerBinding;
import com.student.manager.databinding.FragmentStudentProfileBinding;
import com.student.manager.model.Student;

public class StudentProfileFragment extends Fragment {

    FragmentStudentProfileBinding binding;

    Student student;

    public StudentProfileFragment(Student student) {
        this.student = student;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStudentProfileBinding.inflate(inflater, container, false);


        binding.edtName.setText(student.getName());
        binding.edtDateOfBirth.setText(student.getDate_of_birth());
        binding.edtAddress.setText(student.getAddress());
        binding.edtPhone.setText(student.getPhone_number());

        if (student.getGender() == 1) {
            binding.rdgGender.setText("Male");
        } else {
            binding.rdgGender.setText("Female");
        }

        return binding.getRoot();
    }
}