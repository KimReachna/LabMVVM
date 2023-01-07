package com.example.labmvvm;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labmvvm.databinding.ActivityStudentsBinding;

import java.util.ArrayList;
import java.util.List;

public class StudentsActivity extends AppCompatActivity  {
    ActivityStudentsBinding activityStudentsBinding;
    private StudentViewModel studentViewModel;
    private StudentAdapter studentAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStudentsBinding = DataBindingUtil.setContentView(this, R.layout.activity_students);
        RecyclerView recyclerView = activityStudentsBinding.studentList;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentViewModel = new ViewModelProvider(this).get(StudentViewModel.class);
        activityStudentsBinding.setStudentViewModel(studentViewModel);
        activityStudentsBinding.setLifecycleOwner(this);
        studentAdapter = new StudentAdapter();
        recyclerView.setAdapter(studentAdapter);
        getStudents();
    }

    private void getStudents() {
        studentViewModel.getAllStudent().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                studentAdapter.setStudentList((ArrayList<Student>) students);
            }
        });
    }
}
