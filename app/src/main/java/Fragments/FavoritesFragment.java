package Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travely.FavoritesAdapter;
import com.example.travely.Post;
import com.example.travely.R;
import com.google.gson.JsonArray;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class FavoritesFragment extends Fragment {

    public static final String TAG = "FavoritesFragment";
    RecyclerView rvFavorites;
    protected FavoritesAdapter adapter;
    JSONArray allPlaces = new JSONArray();
    private Button btnShare;




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

        btnShare = view.findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                newPost();
            }
        });

        rvFavorites = view.findViewById(R.id.rvFavorites);
        adapter = new FavoritesAdapter(getContext(), allPlaces);

        rvFavorites.setAdapter(adapter);

        rvFavorites.setLayoutManager(new LinearLayoutManager(getContext()));
//
//        // TODO: currently the recyclerview list is empty. I have to update it and add to the list

        ParseUser user = ParseUser.getCurrentUser();
        allPlaces = user.getJSONArray(Post.FAVORITE_LIST);
        adapter.addAll(allPlaces);
        adapter.notifyDataSetChanged();

    }

    private void newPost() {
        ParseUser currentUser = ParseUser.getCurrentUser();
        JSONArray favorites = currentUser.getJSONArray(Post.FAVORITE_LIST);
        ParseFile photo = currentUser.getParseFile(Post.PROFILE_PIC);
        Post post = new Post();
        post.put("username", currentUser);
        post.put("profilePic", photo);
        post.put("favoriteList", favorites);
        post.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e!=null){
                    Log.e(TAG, "error while sharing", e);
                    Toast.makeText(getContext(), "Error while saving!", Toast.LENGTH_SHORT).show();
                }
                Log.i(TAG, "Post save was successful!!");
                Toast.makeText(getContext(), "You have shared your list!", Toast.LENGTH_SHORT).show();


            }
        });
    }

}