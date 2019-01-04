package com.example.student.workoutprogram.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.student.workoutprogram.R;
import com.example.student.workoutprogram.models.CardioSet;
import com.example.student.workoutprogram.models.Model;
import com.example.student.workoutprogram.models.Routine;
import com.example.student.workoutprogram.models.Session;
import com.example.student.workoutprogram.models.StrengthSet;
import com.example.student.workoutprogram.models.Workout;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link StrengthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StrengthFragment extends DialogFragment {
    private EditText repsText;
    private EditText unitText;
    private EditText hoursText;
    private EditText minutesText;
    private EditText secondsText;
    private Button addSetBtn;
    private ListView setList;

    private int reps;
    private int weight;
    private String units;
    private int hours;
    private int minutes;
    private int seconds;

    private Model model = Model.getInstance();


    public StrengthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment StrengthFragment.
     */
    public static StrengthFragment newInstance() {
        StrengthFragment fragment = new StrengthFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        repsText = getActivity().findViewById(R.id.repsEditText);
        unitText = getActivity().findViewById(R.id.wUnitEditText);
        hoursText =getActivity().findViewById(R.id.sTimeHrEditText);
        minutesText = getActivity().findViewById(R.id.sTimeMEditText);
        secondsText = getActivity().findViewById(R.id.sTimeSEditText);
        addSetBtn = getActivity().findViewById(R.id.addSSetBtn);
        setList = getActivity().findViewById(R.id.sSetList);

        addSetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reps = Integer.parseInt(repsText.getText().toString());
                units = unitText.getText().toString();
                hours = Integer.parseInt(hoursText.getText().toString());
                minutes =Integer.parseInt(minutesText.getText().toString());
                seconds = Integer.parseInt(secondsText.getText().toString());

//                model.getWorkouts().get(Workout.current).addSet(new StrengthSet(hours,minutes,seconds,reps,weight,units));

            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_strength, container, false);
        //return inflater.inflate(R.layout.fragment_strength, container, false);
        getDialog().setTitle("Temporary Title");
        return rootView;
    }


}
