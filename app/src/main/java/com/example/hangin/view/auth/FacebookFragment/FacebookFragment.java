package com.example.hangin.view.auth.FacebookFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.hangin.R;

import androidx.fragment.app.Fragment;

public class FacebookFragment extends Fragment {


    public FacebookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_facebook, container, false);

        return view;
    }

}
