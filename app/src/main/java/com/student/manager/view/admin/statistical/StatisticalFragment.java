package com.student.manager.view.admin.statistical;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.student.manager.R;
import com.student.manager.databinding.FragmentStatisticalBinding;

public class StatisticalFragment extends Fragment {

    FragmentStatisticalBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_statistical, container, false);
    }
}