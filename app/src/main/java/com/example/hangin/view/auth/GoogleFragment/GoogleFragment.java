package com.example.hangin.view.auth.GoogleFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangin.R;
import androidx.fragment.app.Fragment;

public class GoogleFragment extends Fragment {


    public GoogleFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_google, container, false);

        return view;
    }
}
