package com.example.sudorafa.androidexerciciofragments.view;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sudorafa.androidexerciciofragments.R;
import com.example.sudorafa.androidexerciciofragments.model.Student;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditStudentFragment extends Fragment {

    private static final String EXTRA_STUDENT = "param1";

    @BindView(R.id.editName)
    EditText editName;
    @BindView(R.id.editEmail)
    EditText editEmail;
    @BindView(R.id.editPhone)
    EditText editPhone;
    @BindView(R.id.buttonSave)
    Button buttonSave;

    private Student mStudent;


    public EditStudentFragment() {
        // Required empty public constructor
    }

    public static EditStudentFragment newInstance(Student student) {
        EditStudentFragment fragment = new EditStudentFragment();
        Bundle args = new Bundle();
        Parcelable p = Parcels.wrap(student);
        args.putParcelable(EXTRA_STUDENT, p);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcelable p = getArguments().getParcelable(EXTRA_STUDENT);
            mStudent = Parcels.unwrap(p);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_student, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

}
