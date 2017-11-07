package com.example.sudorafa.androidexerciciofragments.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sudorafa.androidexerciciofragments.R;
import com.example.sudorafa.androidexerciciofragments.model.Student;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListStudentFragment extends Fragment {

    @BindView(R.id.listViewStudent)
    ListView mListViewStudent;

    List<Student> mStudents;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStudents = new ArrayList<>();

        mStudents.add(new Student("Rafa", "paracafa@gmail.com", "81-996006450"));
        mStudents.add(new Student("Rafa", "paracafa@gmail.com", "81-996006450"));
        mStudents.add(new Student("Rafa", "paracafa@gmail.com", "81-996006450"));
    }


    public ListStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the view for this fragment
        View view = inflater.inflate(R.layout.fragment_list_student, container, false);

        ButterKnife.bind(this, view);

        mListViewStudent.setAdapter(new ArrayAdapter<Student>(getActivity(), android.R.layout.simple_list_item_1, mStudents));

        return view;
    }

    @OnItemClick(R.id.listViewStudent)
    public void itemSelectedBook(int position){
        Student student = mStudents.get(position);
        if(getActivity() instanceof ClickStudentListener){
            ClickStudentListener listener = (ClickStudentListener)getActivity();
            listener.studentClicked(student);
        }
    }

    public interface ClickStudentListener{
        void studentClicked(Student student);
    }

}
