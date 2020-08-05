package com.example.travely;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.location.places.Place;
import com.google.gson.JsonArray;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private Context context;
    private JsonArray places;

    public FavoritesAdapter(Context context, JsonArray places) {
        this.context = context;
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String place = places.get(position).toString();
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public void addAll() {

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvPlace;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPlace = itemView.findViewById(R.id.tvPlace);
        }

        public void bind(String place) {
            // bind the place name data to the view elements
            tvPlace.setText(place);
        }
    }

}
