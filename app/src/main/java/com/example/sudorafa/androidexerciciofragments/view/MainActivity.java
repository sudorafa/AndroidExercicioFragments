package com.example.sudorafa.androidexerciciofragments.view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sudorafa.androidexerciciofragments.R;
import com.example.sudorafa.androidexerciciofragments.model.Student;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity implements ListStudentFragment.ClickStudentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void studentClicked(Student student) {
        if (getResources().getBoolean(R.bool.land)) {
            EditStudentFragment detailBookFragment = EditStudentFragment.newInstance(student);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.edit, detailBookFragment, "edit")
                    .commit();
        } else {
            Intent intent = new Intent(this, EditStudentActivity.class);
            Parcelable parcelable = Parcels.wrap(student);
            intent.putExtra(EditStudentActivity.EXTRA_STUDENT, parcelable);
            startActivity(intent);
        }
    }
}
