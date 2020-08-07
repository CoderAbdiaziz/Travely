package Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.travely.ChangePictureActivity;
import com.example.travely.LoginActivity;
import com.example.travely.Post;
import com.example.travely.R;
import com.parse.ParseFile;
import com.parse.ParseUser;

import java.io.File;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static android.app.Activity.RESULT_OK;


public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";
    private Button btnLogout;
    private Button btnEdit;
    private TextView tvUsername;
    private ImageView ivProfilePic;
    public static Context profileContext = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        profileContext = getContext();

        ParseUser user = ParseUser.getCurrentUser();
        ivProfilePic = view.findViewById(R.id.ivProfilePic);

        int radius = 30; // corner radius, higher value = more rounded
        int margin = 10; // crop margin, set to 0 for corners with no crop
            Glide.with(getContext())
                    .load(user.getParseFile(Post.PROFILE_PIC).getUrl())
                    .transform(new RoundedCornersTransformation(radius, margin))
                    .into(ivProfilePic);



        tvUsername = view.findViewById(R.id.tvUsername);
        // grab current users username
        String Username = ParseUser.getCurrentUser().getUsername();
        // bind the username onto the profile page
        tvUsername.setText(Username);




        btnEdit = view.findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangePictureActivity.class);
                startActivity(intent);
            }
        });


        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOutInBackground();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


}