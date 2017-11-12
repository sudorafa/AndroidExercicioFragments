package com.example.sudorafa.androidexerciciofragments.view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sudorafa.androidexerciciofragments.R;
import com.example.sudorafa.androidexerciciofragments.model.Student;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ClickStudentListener {

    @BindView(R.id.viewPagerListStudent)
    ViewPager mViewPagerListStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewPagerListStudent.setAdapter(new StudentPager(getSupportFragmentManager()));
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

    class StudentPager extends FragmentPagerAdapter {

        public StudentPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ListStudentFragment();
            } else if (position == 1) {
                return new ListStudentPhoneFragment();
            } else {
                return new ListStudentReproFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {


            if (position == 0) {
                return getString(R.string.listStudent);
            } else if (position == 1) {
                return getString(R.string.listPhone);
            } else {
                return getString(R.string.listReproo);
            }
        }
    }

}
