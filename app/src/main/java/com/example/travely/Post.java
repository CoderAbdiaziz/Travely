package com.example.travely;

import com.parse.GetCallback;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import org.json.JSONArray;

import java.util.Date;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String FAVORITE_LIST = "favoriteList";
    public static final String KEY_CREATED_AT = "createdAt";
    public static final String PROFILE_PIC = "profilePic";
    public static final String KEY_USER = "username";

    public Post() {

    }

    public static void getPost() {
        ParseUser.getCurrentUser();
        // Specify which class to query
        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
// Specify the object id
        query.getInBackground("gYsSH4SVkn", new GetCallback<Post>() {
            public void done(Post post, ParseException e) {
                if (e == null) {
                    // Access data using the `get` methods for the object
                    JSONArray favorites = post.getFavoriteList();
                    // Access special values that are built-in to each object
                    String objectId = post.getObjectId();

                    Date createdAt = post.getCreatedAt();
                    // Do whatever you want with the data...
//                    Toast.makeText(DetailsActivity.class, "Favorites added", Toast.LENGTH_SHORT).show();
                } else {
                    // something went wrong
                }
            }
        });
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
