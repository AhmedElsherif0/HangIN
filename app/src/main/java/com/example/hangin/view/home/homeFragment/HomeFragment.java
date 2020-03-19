package com.example.hangin.view.home.homeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangin.R;
import com.example.hangin.data.Model.Places;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

    @BindView(R.id.profile_tb_toolbar)
    Toolbar profileTbToolbar;
    @BindView(R.id.home_rv_recycleView)
    RecyclerView homeRvRecycleView;
    private Unbinder unbinder;

    private GridLayoutManager gridLayoutManager;
    private HomeAdapter homeAdapter;
    private List<Places> placesList = new ArrayList<>();


    public  HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        initRecyclerView();

        return view;
    }

    private void initRecyclerView() {

        for (int i = 0; i < 100; i++) {
            placesList.add(new Places("Address" + i, "Name" + i, "WorkShop" + i));

            gridLayoutManager = new GridLayoutManager(getActivity(), 2,
                    GridLayoutManager.VERTICAL, false);
            homeRvRecycleView.setLayoutManager(gridLayoutManager);

            homeAdapter = new HomeAdapter(placesList, getActivity().getApplicationContext());

            homeRvRecycleView.setAdapter(homeAdapter);

        }
    }
}
