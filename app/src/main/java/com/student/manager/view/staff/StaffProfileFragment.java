package com.student.manager.view.staff;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.manager.R;
import com.student.manager.databinding.FragmentLecturerProfileBinding;
import com.student.manager.databinding.FragmentStaffProfileBinding;
import com.student.manager.model.Staff;

public class StaffProfileFragment extends Fragment {

    FragmentStaffProfileBinding binding;

    Staff staff;

    public StaffProfileFragment(Staff staff) {
        this.staff = staff;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStaffProfileBinding.inflate(inflater, container, false);

        binding.edtName.setText(staff.getName());
        binding.edtDateOfBirth.setText(staff.getDate_of_birth());
        binding.edtAddress.setText(staff.getAddress());
        binding.edtPhone.setText(staff.getPhone_number());

        if (staff.getGender() == 1) {
            binding.rdgGender.setText("Male");
        } else {
            binding.rdgGender.setText("Female");
        }

        return binding.getRoot();
    }
}