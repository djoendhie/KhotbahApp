package com.kun.jun.khotbahapp.mone;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kun.jun.khotbahapp.R;
import com.kun.jun.khotbahapp.func.SessionManager;
import com.kun.jun.khotbahapp.model.Khotbah;

import java.util.ArrayList;
import java.util.List;

public class MainMainActivity extends SessionManager {

    /// actyvity ini kagak di pake
    // jangan di hapus tapi
    // buat referensi

    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<Khotbah> list;
    RecyclerView recycle;
    Button view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);
         recycle = (RecyclerView) findViewById(R.id.recycle);



        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("khotba");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list = new ArrayList<Khotbah>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                    Khotbah value = dataSnapshot1.getValue(Khotbah.class);
                    Khotbah fire = new Khotbah();
                    String judul = value.getJudul();
                    String url = value.getUrl();
                    String tanggal = value.getTanggal();
                    fire.setJudul(judul);
                    fire.setTanggal(tanggal);
                    fire.setUrl(url);
                    list.add(fire);
                }

                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,MainMainActivity.this);
//                RecyclerView.LayoutManager recyce = new GridLayoutManager(MainMainActivity.this,2);
                 RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainMainActivity.this);
                // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator( new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });


    }
//    public void myIntent(Class kelastujuan){
//        startActivity(new Intent(c,kelastujuan));
//    }

}
