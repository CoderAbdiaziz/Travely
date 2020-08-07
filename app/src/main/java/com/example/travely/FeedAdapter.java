package com.example.travely;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseUser;

import org.w3c.dom.Text;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public FeedAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUser;
        private TextView tvFavoriteList;
        private ImageView ivprofilepicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUser = itemView.findViewById(R.id.tvUser);
            tvFavoriteList = itemView.findViewById(R.id.tvFavoriteList);
            ivprofilepicture = itemView.findViewById(R.id.ivprofilepicture);
        }

        public void bind(Post post) {
            tvUser.setText(ParseUser.getCurrentUser().getUsername());
            tvFavoriteList.setText(ParseUser.getCurrentUser().getJSONArray(Post.FAVORITE_LIST).toString());
            Glide.with(context)
                    .load(ParseUser.getCurrentUser().getParseFile(Post.PROFILE_PIC).getUrl())
                    .into(ivprofilepicture);
        }
    }
}
