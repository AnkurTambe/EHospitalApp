package com.example.ehospitalapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ehospitalapp.R;
import com.example.ehospitalapp.adapter.DashboardAdapter;
import com.example.ehospitalapp.model.DashboardModel;


public class DashboardFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_dashboard, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rv_db);

        DashboardModel[] projects = {
                new DashboardModel(R.drawable.admin, "Admin"),
                new DashboardModel(R.drawable.doctor, "Doctor"),
                new DashboardModel(R.drawable.human_resource, "HR"),
                new DashboardModel(R.drawable.jr_doctor, "Jr. Doctor"),
                new DashboardModel(R.drawable.patient, "Patient"),
                new DashboardModel(R.drawable.department, "Department"),
                new DashboardModel(R.drawable.lab, "Lab"),
                new DashboardModel(R.drawable.lab_tech, "Lab Tech."),
                new DashboardModel(R.drawable.maintenance, "Maintena."),
                new DashboardModel(R.drawable.equipment, "Equipment")
        };

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(true);
        DashboardAdapter pA = new DashboardAdapter(projects);
        recyclerView.setAdapter(pA);

        return root;
    }
}
