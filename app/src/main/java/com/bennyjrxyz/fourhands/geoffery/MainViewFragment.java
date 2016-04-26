package com.bennyjrxyz.fourhands.geoffery;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainViewFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GeofferyApplication app;


    private EditText editItemName, editItemCal, editItemPrice;
    private Button addFoodBtn;

    private OnFragmentInteractionListener mListener;

    public MainViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainViewFragment newInstance(String param1, String param2) {
        MainViewFragment fragment = new MainViewFragment();
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main_view, container, false);
        // Inflate the layout for this fragment

        editItemName = (EditText) view.findViewById(R.id.editText_item_Name);
        editItemCal = (EditText) view.findViewById(R.id.editText_item_cal);
        editItemPrice = (EditText) view.findViewById(R.id.editText_item_price);
        addFoodBtn = (Button) view.findViewById(R.id.button_add_food);

        addFoodBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getActivity() instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) getActivity();
        } else {
            throw new RuntimeException(getActivity().toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        Log.d("On Click", "Inside on click method");

        boolean isInserted = app.insertData(editItemName.getText().toString(),
                editItemCal.getText().toString(),
                editItemPrice.getText().toString());

        if(isInserted){
            Toast.makeText(getActivity().getApplicationContext(), "Data Inserted", Toast.LENGTH_LONG).show();
            Log.d("Database", "Data Inserted");

        } else
            Toast.makeText(getActivity().getApplicationContext(), "Error!", Toast.LENGTH_LONG).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}