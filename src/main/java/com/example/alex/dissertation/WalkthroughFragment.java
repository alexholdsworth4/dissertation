package com.example.alex.dissertation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alex.dissertation.Common.Common;
import com.example.alex.dissertation.Interface.ItemClickListener;
import com.example.alex.dissertation.Model.Walkthrough;
import com.example.alex.dissertation.ViewHolder.WalkthroughViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class WalkthroughFragment extends Fragment {

    View myFragment;

    RecyclerView listWalkthrough;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Walkthrough, WalkthroughViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference walkthroughs;

    public static WalkthroughFragment newInstance(){
        WalkthroughFragment walkthroughFragment = new WalkthroughFragment();
        return walkthroughFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        walkthroughs = database.getReference("Walkthrough");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_walkthrough,container,false);
        listWalkthrough = (RecyclerView)myFragment.findViewById(R.id.listWalkthrough);
        listWalkthrough.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listWalkthrough.setLayoutManager(layoutManager);

        loadWalkthroughs();

        return myFragment;

    }

    private void loadWalkthroughs() {
        adapter = new FirebaseRecyclerAdapter<Walkthrough, WalkthroughViewHolder>(
                Walkthrough.class,
                R.layout.walkthrough_layout,
                WalkthroughViewHolder.class,
                walkthroughs
        ) {
            @Override
            protected void populateViewHolder(WalkthroughViewHolder viewHolder, final Walkthrough model, int position) {
                viewHolder.walkthrough_name.setText(model.getName());
                Picasso.with(getActivity())
                        .load(model.getImage())
                        .into(viewHolder.walkthrough_image);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        // Toast.makeText(getActivity(),String.format("%d|%s",adapter.getRef(position).getKey(),model.getName()), Toast.LENGTH_SHORT).show();
                        Intent startGame = new Intent(getActivity(),Start.class);
                        Common.walkthroughId = adapter.getRef(position).getKey();
                        Common.walkthroughName = model.getName();
                        startActivity(startGame);

                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        listWalkthrough.setAdapter(adapter);

    }
}
