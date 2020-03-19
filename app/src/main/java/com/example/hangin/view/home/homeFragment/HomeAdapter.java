package com.example.hangin.view.home.homeFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.hangin.R;
import com.example.hangin.data.Model.Places;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {



  private   List<Places> PlacesList;
  private   Context context;


    public HomeAdapter(List<Places> PlacesList, Context context) {
        this.PlacesList = PlacesList;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_places_card, parent, false);

        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
          Places item = PlacesList.get(position);
          holder.bind(item);

    }

    @Override
    public int getItemCount() {
        return PlacesList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvWorkShop, tvAddress;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.placeName);
            tvWorkShop = itemView.findViewById(R.id.wordShop);
            tvAddress = itemView.findViewById(R.id.placesAddress);
        }


            void bind(Places places){

                String placeName = tvName.getText().toString().trim();
                String placeAddress = tvAddress.getText().toString().trim();
                String workShop = tvWorkShop.getText().toString().trim();

            }

        }
    }
