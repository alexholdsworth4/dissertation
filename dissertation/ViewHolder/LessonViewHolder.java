package com.example.alex.dissertation.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alex.dissertation.Interface.ItemClickListener;
import com.example.alex.dissertation.R;

public class LessonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView lesson_name;
    public ImageView lesson_image;

    private ItemClickListener itemClickListener;

    public LessonViewHolder(@NonNull View itemView) {
        super(itemView);
        lesson_image = (ImageView)itemView.findViewById(R.id.lesson_image);
        lesson_name = (TextView)itemView.findViewById(R.id.lesson_name);

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
