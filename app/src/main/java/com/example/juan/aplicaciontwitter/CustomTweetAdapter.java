package com.example.juan.aplicaciontwitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

/**
 * Created by Juan on 14/04/2015.
 */
public class CustomTweetAdapter extends BaseAdapter {
    private final Context context;
    private  int layout;
    private List<Tweet> tweets;

    public CustomTweetAdapter(Context context, int layout, List<Tweet> tweets) {
        this.context = context;
        this.layout = layout;
        this.tweets = tweets;
    }

    @Override
    public int getCount() {
        return this.tweets.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tweets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.tweets.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tweetRow = inflater.inflate(this.layout, parent, false);
        ImageView miniImagenPerfil = (ImageView) tweetRow.findViewById(R.id.miniImagenPerfil);
        TextView userScreenName = (TextView) tweetRow.findViewById(R.id.userScreenName);
        TextView userFullName = (TextView) tweetRow.findViewById(R.id.userFullName);
        TextView tweetText = (TextView) tweetRow.findViewById(R.id.tweetText);

        Tweet tweet = tweets.get(position);

        //TODO tratar retweets

        Picasso.with(this.context).load(tweet.user.profileImageUrl).into(miniImagenPerfil);
        userScreenName.setText("@"+tweet.user.screenName);
        userFullName.setText(tweet.user.name);
        tweetText.setText(tweet.text);
        return tweetRow;
    }
}
