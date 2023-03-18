package com.student.manager.view.lecturer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.manager.R;
import com.student.manager.databinding.FragmentLecturerProfileBinding;
import com.student.manager.databinding.FragmentStudentProfileBinding;
import com.student.manager.model.Lecturer;

public class LecturerProfileFragment extends Fragment {

    FragmentLecturerProfileBinding binding;

    Lecturer lecturer;

    public LecturerProfileFragment(Lecturer lecturer) {
        this.lecturer = lecturer;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLecturerProfileBinding.inflate(inflater, container, false);

        binding.edtName.setText(lecturer.getName());
        binding.edtDateOfBirth.setText(lecturer.getDate_of_birth());
        binding.edtAddress.setText(lecturer.getAddress());
        binding.edtPhone.setText(lecturer.getPhone_number());

        if (lecturer.getGender() == 1) {
            binding.rdgGender.setText("Male");
        } else {
            binding.rdgGender.setText("Female");
        }

        return binding.getRoot();
    }
}