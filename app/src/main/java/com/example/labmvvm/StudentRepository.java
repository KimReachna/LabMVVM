package com.example.labmvvm;


import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();
    private MutableLiveData<List<Student>> mutableLiveData = new MutableLiveData<>();


    public StudentRepository() {
        Student student1 = new Student("Ким", "Реачна");
        Student student2 = new Student("Астахова", "Марина");
        studentList.add(student1);
        studentList.add(student2);
    }

    public MutableLiveData<List<Student>> getMutableLiveData() {
        mutableLiveData.setValue(studentList);
        return mutableLiveData;
    }

    public void addStudent(Student student) {
        studentList.add(student);
        mutableLiveData.setValue(studentList);
    }

}
