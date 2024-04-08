package com.example.languageapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.languageapp.Adapters.AvailableCoureseAdapter;
import com.example.languageapp.Models.Languages;
import com.example.languageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AvailableCourses extends Fragment {

    private AvailableCoureseAdapter courseAdapter;
    private final ArrayList<Languages> languageList = new ArrayList<>();
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_available_courses, container, false);
        recyclerView = view.findViewById(R.id.viewCourse);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        FirebaseDatabase.getInstance().getReference("languages").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                languageList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    //String key = snapshot.getKey();
                    Languages languages = dataSnapshot.getValue(Languages.class);
                    languageList.add(languages);
                }

                courseAdapter = new AvailableCoureseAdapter(languageList, getContext());
                recyclerView.setAdapter(courseAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return view;
    }
}