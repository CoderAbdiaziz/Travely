package com.example.travely;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import java.util.Arrays;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    public static final String TAG = "DetailsActivity";
    ImageView ivPlaceImage;
    TextView tvPlaceName;
    TextView tvDescription;
    Button btnFavorite;
    String placeID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivPlaceImage = findViewById(R.id.ivPlaceImage);
        tvPlaceName = findViewById(R.id.tvPlaceName);
        tvDescription = findViewById(R.id.tvDescription);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: add the designated place to the users favorites list by appending to the array in the parse database
            }
        });
        querypost();


    }

    private void querypost() {
        String query = getIntent().getStringExtra("search text");

        // Create a new token for the autocomplete session. Pass this to FindAutocompletePredictionsRequest,
        // and once again when the user makes a selection (for example when calling fetchPlace()).
        AutocompleteSessionToken token = AutocompleteSessionToken.newInstance();


        // Use the builder to create a FindAutocompletePredictionsRequest.
        FindAutocompletePredictionsRequest request = FindAutocompletePredictionsRequest.builder()
                .setTypeFilter(TypeFilter.ESTABLISHMENT)
                .setSessionToken(token)
                .setQuery(query)
                .build();

        Places.initialize(getApplicationContext(), "AIzaSyAZ0awcpunwA1bcM5tUajHj_XXeRfg9hZw");
        PlacesClient placesClient = Places.createClient(this);

        placesClient.findAutocompletePredictions(request).addOnSuccessListener(new OnSuccessListener<FindAutocompletePredictionsResponse>() {
            @Override
            public void onSuccess(FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
                for (AutocompletePrediction prediction : findAutocompletePredictionsResponse.getAutocompletePredictions()) {
                    placeID = prediction.getPlaceId();
                    Log.i(TAG, prediction.getPlaceId());
                    Log.i(TAG, prediction.getPrimaryText(null).toString());
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ApiException) {
                    ApiException apiException = (ApiException) e;
                    Log.e(TAG, "Place not found: " + apiException.getStatusCode());
                }
            }
        });
    }
}