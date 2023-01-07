package com.example.labmvvm;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository studentRepository;

    public MutableLiveData<String> first = new MutableLiveData<>();
    public MutableLiveData<String> last = new MutableLiveData<>();

    public StudentViewModel(@NonNull Application application) {
        super(application);
        this.studentRepository = new StudentRepository();
    }

    public LiveData<List<Student>> getAllStudent() {
        return studentRepository.getMutableLiveData();
    }

    public void addStudent() {
        studentRepository.addStudent(new Student(first.getValue(), last.getValue()));
    }

}

