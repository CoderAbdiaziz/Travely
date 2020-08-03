package com.example.travely;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import org.json.JSONArray;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String FAVORITE_LIST = "favoritelist";
    public static final String KEY_CREATED_AT = "createdAt";
    public static final String PROFILE_PIC = "profilepic";
    public static final String KEY_USER = "username";

    public Post() {

    }

    public JSONArray getFavoriteList(){
        return getJSONArray(FAVORITE_LIST);
    }

    public void setFavoriteList(JSONArray favoriteList){
        put(FAVORITE_LIST, favoriteList);
    }

    public ParseFile getProfilePic() {
        return getParseFile(PROFILE_PIC);
    }

    public void setProfilePic(ParseFile parseFile){
        put(PROFILE_PIC, parseFile);
    }

    public ParseUser getUser() {
        return getParseUser(KEY_USER);
    }

    public void setUser(ParseUser user) {
        put(KEY_USER, user);
    }
}
