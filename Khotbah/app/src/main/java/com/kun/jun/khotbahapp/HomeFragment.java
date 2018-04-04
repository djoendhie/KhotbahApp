package com.kun.jun.khotbahapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kun.jun.khotbahapp.model.Khotbah;
import com.kun.jun.khotbahapp.mone.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference myRef;
    List<Khotbah> list;
    RecyclerView recycle;
//    private View view;
//    private RecyclerView.Adapter recyclerAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return inflater.inflate(R.layout.activity_main_main, container, false);

    }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            recycle = (RecyclerView)view.findViewById(R.id.recycle);

            database = FirebaseDatabase.getInstance();
            myRef = database.getReference("khotba");

            ValueEventListener valueEventListener = myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    list = new ArrayList<>();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        Khotbah value = dataSnapshot1.getValue(Khotbah.class);
                        Khotbah fire = new Khotbah();
                        String judul = value.getJudul();
                        String tanggal = value.getTanggal();
                        String url = value.getUrl();
                        fire.setJudul(judul);
                        fire.setTanggal(tanggal);
                        fire.setUrl(url);
                        list.add(fire);

                    }
                    if (list == null) {
//                        recycle.setAdapter(recyclerAdapter);

                        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list, getContext());
//                RecyclerView.LayoutManager recyce = new GridLayoutManager(MainMainActivity.this,2);
                        RecyclerView.LayoutManager recyce = new LinearLayoutManager(getContext());
                        // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                        recycle.setLayoutManager(recyce);
                        recycle.setItemAnimator(new DefaultItemAnimator());
                        recycle.setAdapter(recyclerAdapter);

                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Log.w("Hello", "Failed to read value.", databaseError.toException());
                }
            });
        }
    }