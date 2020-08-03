package Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travely.FavoritesAdapter;
import com.example.travely.R;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    RecyclerView rvFavorites;
    protected FavoritesAdapter adapter;
    List<String> allPlaces;




    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvFavorites = view.findViewById(R.id.rvFavorites);

        allPlaces = new ArrayList<String>();
        adapter = new FavoritesAdapter(getContext(), allPlaces);

        rvFavorites.setAdapter(adapter);

        rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));

        // TODO: currently the recyclerview list is empty. I have to update it and add to the list


    }
}