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
 * {@link StrengthFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StrengthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StrengthFragment extends DialogFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText repsText;
    private EditText unitText;
    private EditText hoursText;
    private EditText minutesText;
    private EditText secondsText;
    private Button addSetBtn;
    private ListView setList;

    private int reps;
    private String units;
    private int hours;
    private int minutes;
    private int seconds;

    private Model model = Model.getInstance();

    private OnFragmentInteractionListener mListener;

    public StrengthFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StrengthFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StrengthFragment newInstance(String param1, String param2) {
        StrengthFragment fragment = new StrengthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

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

                model.getList().get(Routine.current).getSessions().get(Session.current).getWorkouts().get(Workout.current).addSet(new StrengthSet(hours,minutes,seconds,reps,units));

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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
