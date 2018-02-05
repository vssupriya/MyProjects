package com.example.supriya.githubapp;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.squareup.picasso.Picasso;

        import java.util.ArrayList;

/**
 * Created by supriya on 1/14/18.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.MyHolder> {

    private ArrayList<GithubUser> users;
    private Context context;

    public GithubAdapter(ArrayList<GithubUser> users) {
        this.users = users;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrow,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        final GithubUser currentuser = users.get(position);
        Picasso.with(context)
                .load(currentuser.getAvatar_url())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher_round)
                //.transform(new CircleTransform())
                .into(holder.image);
        holder.login.setText(currentuser.getLogin());
        holder.score.setText(""+currentuser.getScore());
        holder.id.setText(currentuser.getId());
        holder.url.setText(currentuser.getUrl());


    }

    @Override
    public int getItemCount() {
        if (users != null)
            return users.size();
        else
            return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView login, id, score, url;
        ImageView image;

        public MyHolder(View itemView) {
            super(itemView);
            login = (TextView) itemView.findViewById(R.id.login);
            id = (TextView) itemView.findViewById(R.id.id);
            score = (TextView) itemView.findViewById(R.id.score);
            url = (TextView) itemView.findViewById(R.id.url);
            image = (ImageView) itemView.findViewById(R.id.imageViewUser);
        }
    }

}
