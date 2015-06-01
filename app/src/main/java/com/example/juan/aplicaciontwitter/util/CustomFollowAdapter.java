package com.example.juan.aplicaciontwitter.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.juan.aplicaciontwitter.R;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.User;

import java.util.List;

/**
 * Created by Juan on 12/05/2015.
 */
public class CustomFollowAdapter extends CustomMainAdapter<User> {

    public CustomFollowAdapter(List<User> users) {
        this.list = users;
    }

    @Override
    public long getItemId(int position) {
        return this.list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = this.list.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View userRow = inflater.inflate(R.layout.row_user, parent, false);

        ImageView miniImagenPerfil = (ImageView) userRow.findViewById(R.id.miniImagenPerfil);
        TextView userScreenName = (TextView) userRow.findViewById(R.id.userScreenName);
        TextView userFullName = (TextView) userRow.findViewById(R.id.userFullName);
        Button actionButton = (Button) userRow.findViewById(R.id.actionButton);

        actionButton.setText("Follow");
        Picasso.with(this.context).load(user.profileImageUrl).into(miniImagenPerfil);
        userScreenName.setText("@" + user.screenName);
        userFullName.setText(user.name);

        return userRow;
    }
}
