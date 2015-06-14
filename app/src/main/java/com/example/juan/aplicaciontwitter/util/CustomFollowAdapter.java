package com.example.juan.aplicaciontwitter.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.juan.aplicaciontwitter.R;
import com.example.juan.aplicaciontwitter.util.retrofit.TwitterApi;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan on 12/05/2015.
 */
public class CustomFollowAdapter extends CustomMainAdapter<User> {
    private boolean follow;

    public CustomFollowAdapter(List<User> users, boolean follow) {
        this.list = users;
        this.follow = follow;
    }

    @Override
    public long getItemId(int position) {
        return this.list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final User user = this.list.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View userRow = inflater.inflate(R.layout.row_user, parent, false);

        ImageView miniImagenPerfil = (ImageView) userRow.findViewById(R.id.miniImagenPerfil);
        TextView userScreenName = (TextView) userRow.findViewById(R.id.userScreenName);
        TextView userFullName = (TextView) userRow.findViewById(R.id.userFullName);
        final Button actionButton = (Button) userRow.findViewById(R.id.actionButton);

        if (follow) {
            actionButton.setText("Follow");
            actionButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Map<String, String> options = new HashMap<>();
                    options.put("user_id", String.valueOf(user.id));
                    TwitterApi.postFollow(options, new Callback<User>() {
                        @Override
                        public void success(Result<User> userResult) {
                            Log.d("Debug", "Se ha empezado a seguir al usuario");
                            Log.d("Debug", userResult.data.name);
                            actionButton.setText("Followed");
                            actionButton.setEnabled(false);
                            Toast.makeText(context, "Followed", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void failure(TwitterException e) {
                            Log.e("Error", e.getMessage());
                        }
                    });
                }
            });
        } else {
            actionButton.setText("Unfollow");
            actionButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Map<String, String> options = new HashMap<>();
                    options.put("user_id", String.valueOf(user.id));
                    TwitterApi.postUnfollow(options, new Callback<User>() {
                        @Override
                        public void success(Result<User> userResult) {
                            Log.d("Debug", "Se ha dejado de seguir al usuario");
                            Log.d("Debug", userResult.data.name);
                            actionButton.setText("Unfollowed");
                            actionButton.setEnabled(false);
                            Toast.makeText(context, "Unfollowed", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void failure(TwitterException e) {
                            Log.e("Error", e.getMessage());
                        }
                    });
                }
            });
        }
        Picasso.with(this.context).load(user.profileImageUrl).into(miniImagenPerfil);
        userScreenName.setText("@" + user.screenName);
        userFullName.setText(user.name);
        return userRow;
    }
}
