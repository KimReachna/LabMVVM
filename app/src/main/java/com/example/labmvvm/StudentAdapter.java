package com.example.labmvvm;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.labmvvm.databinding.StudentItemViewBinding;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{
    private ArrayList<Student> studentsData = new ArrayList<>();

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student currentStudent = studentsData.get(position);
        holder.studentListItemBinding.setStudentModel(currentStudent);
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        StudentItemViewBinding studentViewItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()
                ), R.layout.student_item_view, parent, false);
        return new StudentViewHolder(studentViewItemBinding);
    }

    public void setStudentList(ArrayList<Student> students) {
        this.studentsData = students;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return studentsData.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        StudentItemViewBinding studentListItemBinding;

        public StudentViewHolder(@NonNull StudentItemViewBinding studentListItemBinding) {
            super(studentListItemBinding.getRoot());
            this.studentListItemBinding = studentListItemBinding;
        }
    }
}
