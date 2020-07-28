package com.example.travely;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.widget.SearchView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import Fragments.FavoritesFragment;
import Fragments.FeedFragment;
import Fragments.MapFragment;
import Fragments.ProfileFragment;

import static androidx.core.view.MenuItemCompat.getActionView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    final FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.action_map:
                        fragment = new MapFragment();
                        break;
                    case R.id.action_fav:
                        fragment = new FavoritesFragment();
                        break;
                    case R.id.action_feed:
                        fragment = new FeedFragment();
                        break;
                    case R.id.action_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                // TODO: What does this line do?
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // set default selection to be the map since that is what the user will see first.
        bottomNavigationView.setSelectedItemId(R.id.action_map);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // in our case, the search bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        // locate the id of the search item and store in variable
        MenuItem searchItem = menu.findItem(R.id.action_search);
        // tried MenuItemCompat.getActionView(search) but getActionView was depecrated(crossed out)
        // stack overflow told me to use this instead since this method was deprecated in API level 26.0.0
        // a method being deprecated means it should no longer be used since a better one was created
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here

                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599

                searchView.clearFocus();
                // once something has been searched go to the places list activity
                // TODO: create an if statement for if the user searches for something that google cant provide a place list for
                goPlaceActivity();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void goPlaceActivity() {
        Intent intent = new Intent(this, PlacesActivity.class);
        startActivity(intent);
    }

}