package com.example.student.workoutprogram.views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText distanceText;
    private EditText unitText;
    private EditText hoursText;
    private EditText minutesText;
    private EditText secondsText;
    private Button addSetBtn;
    private ListView setList;

    private int distance;
    private String units;
    private int hours;
    private int minutes;
    private int seconds;

    private int routineNumb;
    private int sessionNumb;
    private int workoutNumb;

    private Model model = Model.getInstance();

    private OnFragmentInteractionListener mListener;

    public CardioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardioFragment newInstance(String param1, String param2) {
        CardioFragment fragment = new CardioFragment();
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

            distanceText = getActivity().findViewById(R.id.distinceEditText);
            unitText = getActivity().findViewById(R.id.dUnitEditText);
            hoursText =getActivity().findViewById(R.id.cTimeHrEditText);
            minutesText = getActivity().findViewById(R.id.cTimeMEditText);
            secondsText = getActivity().findViewById(R.id.cTimeSEditText);
            addSetBtn = getActivity().findViewById(R.id.addSetBtn);
            setList = getActivity().findViewById(R.id.cSetList);

            addSetBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    distance = Integer.parseInt(distanceText.getText().toString());
                    units = unitText.getText().toString();
                    hours = Integer.parseInt(hoursText.getText().toString());
                    minutes =Integer.parseInt(minutesText.getText().toString());
                    seconds = Integer.parseInt(secondsText.getText().toString());

                    model.getList().get(routineNumb).getList().get(sessionNumb).getList().get(workoutNumb).addSet(new CardioSet(hours,minutes,seconds,distance,units));

                }
            });

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cardio, container, false);
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
