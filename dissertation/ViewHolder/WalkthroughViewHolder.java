package com.example.alex.dissertation.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.dissertation.Interface.ItemClickListener;
import com.example.alex.dissertation.R;

public class WalkthroughViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView walkthrough_name;
    public ImageView walkthrough_image;

    private ItemClickListener itemClickListener;

    public WalkthroughViewHolder(@NonNull View itemView) {
        super(itemView);
        walkthrough_image = (ImageView)itemView.findViewById(R.id.walkthrough_image);
        walkthrough_name = (TextView)itemView.findViewById(R.id.walkthrough_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
