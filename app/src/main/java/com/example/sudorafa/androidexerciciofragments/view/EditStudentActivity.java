package com.example.sudorafa.androidexerciciofragments.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sudorafa.androidexerciciofragments.R;
import com.example.sudorafa.androidexerciciofragments.model.Student;

import org.parceler.Parcels;

public class EditStudentActivity extends AppCompatActivity {

    public static final String EXTRA_STUDENT = "student";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Student student = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_STUDENT));

        EditStudentFragment detailBookFragment = EditStudentFragment.newInstance(student);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.edit, detailBookFragment, "edit")
                .commit();
    }
}
