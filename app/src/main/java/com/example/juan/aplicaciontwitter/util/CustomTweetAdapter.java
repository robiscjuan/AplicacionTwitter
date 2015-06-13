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
import com.twitter.sdk.android.core.models.Tweet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan on 14/04/2015.
 */
public class CustomTweetAdapter extends CustomMainAdapter<Tweet> {

    public CustomTweetAdapter(List<Tweet> tweets) {
        this.list = tweets;
    }

    @Override
    public long getItemId(int position) {
        return this.list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Tweet tweet = this.list.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tweetRow;
        final String statusText;

        if (tweet.retweetedStatus != null) {
            tweetRow = inflater.inflate(R.layout.row_retweet, parent, false);
            TextView retweetUserScreenName = (TextView) tweetRow.findViewById(R.id.retweetUserScreenName);
            retweetUserScreenName.setText("Retwiteado por @" + tweet.user.screenName);

            tweet = tweet.retweetedStatus;
        } else {
            tweetRow = inflater.inflate(R.layout.row_tweet, parent, false);
        }

        statusText = tweet.text;

        ImageView miniImagenPerfil = (ImageView) tweetRow.findViewById(R.id.miniImagenPerfil);
        TextView userScreenName = (TextView) tweetRow.findViewById(R.id.userScreenName);
        TextView userFullName = (TextView) tweetRow.findViewById(R.id.userFullName);
        TextView tweetText = (TextView) tweetRow.findViewById(R.id.tweetText);
        final Button button = (Button) tweetRow.findViewById(R.id.button);

        Picasso.with(this.context).load(tweet.user.profileImageUrl).into(miniImagenPerfil);
        userScreenName.setText("@" + tweet.user.screenName);
        userFullName.setText(tweet.user.name);
        tweetText.setText(statusText);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Publicar Tweet
                Map<String, String> options = new HashMap<>();
                options.put("status", statusText);
                TwitterApi.postStatus(options, new Callback<Tweet>() {
                    @Override
                    public void success(Result<Tweet> tweetResult) {
                        Log.d("Debug", "Se ha publicado el tweet");
                        Log.d("Debug", tweetResult.data.text);
                        button.setText("Publicado");
                        button.setEnabled(false);
                        Toast.makeText(context, "Publicado", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(TwitterException e) {
                        Log.e("Error", e.getMessage());
                    }
                });
            }
        });

        return tweetRow;
    }
}
