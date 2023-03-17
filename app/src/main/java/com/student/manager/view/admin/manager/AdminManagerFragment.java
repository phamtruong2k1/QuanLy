package com.student.manager.view.admin.manager;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.manager.databinding.FragmentAdminManagerBinding;
import com.student.manager.view.all.CreateAccountActivity;

public class AdminManagerFragment extends Fragment {


    FragmentAdminManagerBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAdminManagerBinding.inflate(inflater, container, false);

        binding.addStaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(requireContext(), CreateAccountActivity.class));
                intent.putExtra("type_account", "staff");
                startActivity(intent);
            }
        });

        return binding.getRoot();
    }
}