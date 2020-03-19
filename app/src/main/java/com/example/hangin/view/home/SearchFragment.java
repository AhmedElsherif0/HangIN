package com.example.hangin.view.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangin.R;

import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {


    public SearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_search, container, false);

        return  view;
    }

}
