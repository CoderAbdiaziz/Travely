package com.example.travely;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import org.json.JSONArray;

@ParseClassName("Post")
public class Feed extends ParseObject {
    public static final String PLACE_NAME = "placeName";
    public static final String FAVORITE_LIST = "favoritelist";
    public static final String KEY_CREATED_AT = "createdAt";
    public static final String PROFILE_PIC = "profilepic";

    public String getPlaceName() {
        return getString(PLACE_NAME);
    }

    public void setPlaceName(String placeName) {
        put(PLACE_NAME, placeName);
    }

    public JSONArray getFavoriteList(){
        return getJSONArray(FAVORITE_LIST);
    }



}
