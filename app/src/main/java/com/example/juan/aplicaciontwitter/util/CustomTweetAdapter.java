package com.example.juan.aplicaciontwitter.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.aplicaciontwitter.R;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

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

        if (tweet.retweetedStatus != null) {
            tweetRow = inflater.inflate(R.layout.row_retweet, parent, false);
            TextView retweetUserScreenName = (TextView) tweetRow.findViewById(R.id.retweetUserScreenName);
            retweetUserScreenName.setText("@" + tweet.user.screenName);

            tweet = tweet.retweetedStatus;
        } else {
            tweetRow = inflater.inflate(R.layout.row_tweet, parent, false);
        }

        ImageView miniImagenPerfil = (ImageView) tweetRow.findViewById(R.id.miniImagenPerfil);
        TextView userScreenName = (TextView) tweetRow.findViewById(R.id.userScreenName);
        TextView userFullName = (TextView) tweetRow.findViewById(R.id.userFullName);
        TextView tweetText = (TextView) tweetRow.findViewById(R.id.tweetText);

        Picasso.with(this.context).load(tweet.user.profileImageUrl).into(miniImagenPerfil);
        userScreenName.setText("@" + tweet.user.screenName);
        userFullName.setText(tweet.user.name);
        tweetText.setText(tweet.text);
        return tweetRow;
    }
}
