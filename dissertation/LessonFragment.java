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
import com.example.alex.dissertation.Model.Lesson;
import com.example.alex.dissertation.ViewHolder.LessonViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class LessonFragment extends Fragment {

    View myFragment;

    RecyclerView listLesson;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Lesson, LessonViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference lessons;

    public static LessonFragment newInstance(){
        LessonFragment lessonFragment = new LessonFragment();
        return lessonFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        lessons = database.getReference("Lesson");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_lesson,container,false);
        listLesson = (RecyclerView)myFragment.findViewById(R.id.listLesson);
        listLesson.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listLesson.setLayoutManager(layoutManager);

        loadLessons();

        return myFragment;

    }

    private void loadLessons() {
        adapter = new FirebaseRecyclerAdapter<Lesson, LessonViewHolder>(
                Lesson.class,
                R.layout.lesson_layout,
                LessonViewHolder.class,
                lessons
        ) {
            @Override
            protected void populateViewHolder(LessonViewHolder viewHolder, final Lesson model, int position) {
                viewHolder.lesson_name.setText(model.getName());
                Picasso.with(getActivity())
                        .load(model.getImage())
                        .into(viewHolder.lesson_image);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        // Toast.makeText(getActivity(),String.format("%d|%s",adapter.getRef(position).getKey(),model.getName()), Toast.LENGTH_SHORT).show();
                        Intent startGame = new Intent(getActivity(),Start.class);
                        Common.categoryId = adapter.getRef(position).getKey();
                        Common.lessonName = model.getName();
                        startActivity(startGame);

                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        listLesson.setAdapter(adapter);

    }
}
