package com.example.travely;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    public static final String TAG = "DetailsActivity";
    ImageView ivPlaceImage;
    TextView tvPlaceName;
    TextView tvRating;
    TextView tvUserRating;
    Button btnFavorite;
    String placeID;
    PlacesClient placesClient;
    String placeName;
    List<String> favoritesList = new ArrayList<String>();
    protected FavoritesAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivPlaceImage = findViewById(R.id.ivPlaceImage);
        tvPlaceName = findViewById(R.id.tvPlaceName);
        tvRating = findViewById(R.id.tvRating);
        tvUserRating = findViewById(R.id.tvUserRating);
        btnFavorite = findViewById(R.id.btnFavorite);
        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: add the designated place to the users favorites list by appending to the array in the parse database
                if(placeName != null) {
                    adapter.add(placeName);
                }
                // tester if my list is actually getting updated on the click of the favorites button
                for (int counter = 0; counter < favoritesList.size(); counter ++) {
                    Log.i(TAG, "List: " + favoritesList.get(counter));
                }
            }
        });
        queryPost();



    }

    private void queryPost() {
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
        placesClient = Places.createClient(this);

        placesClient.findAutocompletePredictions(request).addOnSuccessListener(new OnSuccessListener<FindAutocompletePredictionsResponse>() {
            @Override
            public void onSuccess(FindAutocompletePredictionsResponse findAutocompletePredictionsResponse) {
                for (AutocompletePrediction prediction : findAutocompletePredictionsResponse.getAutocompletePredictions()) {
                    placeID = prediction.getPlaceId();
                    Log.i(TAG, prediction.getPlaceId());
                    Log.i(TAG, prediction.getPrimaryText(null).toString());
                }
                placeGet();

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

    private void placeGet() {
        // Construct a request object, passing the place ID and fields array.

        List<com.google.android.libraries.places.api.model.Place.Field> placeMoreFields = Arrays.asList(Place.Field.ID, Place.Field.NAME, Place.Field.PHOTO_METADATAS, Place.Field.RATING, Place.Field.USER_RATINGS_TOTAL);

        final FetchPlaceRequest request = FetchPlaceRequest.newInstance(placeID, placeMoreFields);

        placesClient.fetchPlace(request).addOnSuccessListener(new OnSuccessListener<FetchPlaceResponse>() {
            @Override
            public void onSuccess(FetchPlaceResponse fetchPlaceResponse) {
                Place place = fetchPlaceResponse.getPlace();
                Log.i(TAG, "Place found: " + place.getName());
                tvPlaceName.setText(place.getName());
                placeName = place.getName();
                tvRating.setText("Google Place Rating: " + place.getRating().toString());
                tvUserRating.setText("Number of User Ratings: " + place.getUserRatingsTotal());


                // image request
                final List<PhotoMetadata> metadata = place.getPhotoMetadatas();

                PhotoMetadata photoMetadata = metadata.get(0);
                // Create a FetchPhotoRequest.
                final FetchPhotoRequest photoRequest = FetchPhotoRequest.builder(photoMetadata)
                        .setMaxWidth(500) // Optional.
                        .setMaxHeight(300) // Optional.
                        .build();

                placesClient.fetchPhoto(photoRequest).addOnSuccessListener(new OnSuccessListener<FetchPhotoResponse>() {
                    @Override
                    public void onSuccess(FetchPhotoResponse fetchPhotoResponse) {
                        Bitmap bitmap = fetchPhotoResponse.getBitmap();
                        ivPlaceImage.setImageBitmap(bitmap);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        final ApiException apiException = (ApiException) e;
                        Log.e(TAG, "Place not found: " + e.getMessage());
                        final int statusCode = apiException.getStatusCode();
                        // TODO: Handle error with given status code.
                    }
                });

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ApiException) {
                    final ApiException apiException = (ApiException) e;
                    Log.e(TAG, "Place not found: " + e.getMessage());
                    final int statusCode = apiException.getStatusCode();
                    // TODO: Handle error with given status code.
                }
            }
        });
    }
}