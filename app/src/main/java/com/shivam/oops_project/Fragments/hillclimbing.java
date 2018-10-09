package com.shivam.oops_project.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shivam.oops_project.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class hillclimbing extends Fragment {


    public hillclimbing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_hillclimbing, container, false);



        return rootview;
    }

}
