package com.hardtopcrm.metaldud.daggertest.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hardtopcrm.metaldud.daggertest.R;
import com.hardtopcrm.metaldud.daggertest.model.response.UserResponse;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by user on 12.02.18.
 */

public class RecyclerViewUserAdapter extends
    RecyclerView.Adapter<RecyclerViewUserAdapter.ViewUserHolder> {

    private Picasso picasso;
    private Context context;
    private ViewUserHolder holder;
    private List<? extends UserResponse> responses;


    public RecyclerViewUserAdapter(List<? extends UserResponse> list, Context context) {
        this.responses = list;
        this.context = context;

    }

    @Override
    public ViewUserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tempView = LayoutInflater.from(context).inflate(R.layout.rv_item, parent);
        return new ViewUserHolder(tempView);
    }

    @Override
    public void onBindViewHolder(ViewUserHolder holder, int position) {
        UserResponse response = responses.get(position);
        holder.firstName
            .setText(String.valueOf(response.getResults().get(position).getName().getFirst()));
        holder.lastName
            .setText(String.valueOf(response.getResults().get(position).getName().getLast()));
        holder.email
            .setText(String.valueOf(response.getResults().get(position).getEmail()));
        Picasso.with(context)
            .load(Uri.parse(response.getResults().get(position).getPicture().getMedium()))
            .centerCrop()
            .into(holder.photo);

    }

    @Override
    public int getItemCount() {
        return responses.size();
    }


    static class ViewUserHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvFirstName)
        TextView firstName;
        @BindView(R.id.tvLastName)
        TextView lastName;
        @BindView(R.id.tvEmail)
        TextView email;
        @BindView(R.id.ivUserPhoto)
        ImageView photo;

        public ViewUserHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }


}
