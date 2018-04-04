package com.kun.jun.khotbahapp.client;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;
import com.kun.jun.khotbahapp.adapter.CustomAdapter;
import com.kun.jun.khotbahapp.model.Khotbah;

import java.util.ArrayList;

/**
 * Created by Blackswan on 7/19/2017.
 */

public class FirebaseClient {
    Firebase firebase;
    ArrayList<Khotbah> hewanArrayList = new ArrayList<>();
    CustomAdapter customAdapter;
    Context c;
    String DB_URL;
    ListView listView;
     DatabaseReference ref;
     private LinearLayout linearLayout;

    public FirebaseClient(Context c){
         this.c =c;
     }
    public FirebaseClient(Context c, String DB_URL, ListView listView, DatabaseReference ref) {
        this.c = c;
        this.ref=ref;
        this.DB_URL = DB_URL;
        this.listView = listView;
        Firebase.setAndroidContext(c);
        firebase = new Firebase(DB_URL);
    }


    public void savedata(String name,String info, String url) {
        Khotbah h = new Khotbah();
        String  userid = ref.push().getKey();
        h.setId_khotba(userid);
        h.setJudul(name);
        h.setIsi(info);
        h.setUrl(url);
        ref.child(userid).setValue(h);
    }


    public void refreshdata() {
        firebase.addChildEventListener(new com.firebase.client.ChildEventListener() {
            @Override
            public void onChildAdded(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);

            }

            @Override
            public void onChildChanged(com.firebase.client.DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);

            }

            @Override
            public void onChildRemoved(com.firebase.client.DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(com.firebase.client.DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        } );
    }

    private void getUpdates(final com.firebase.client.DataSnapshot dataSnapshot) {
        hewanArrayList.clear();
        for (com.firebase.client.DataSnapshot ds : dataSnapshot.getChildren()) {
            Khotbah h = new Khotbah();

            h.setId_khotba(ds.getValue(Khotbah.class).getId_khotba());
            h.setJudul(ds.getValue(Khotbah.class).getJudul());
            h.setIsi(ds.getValue(Khotbah.class).getIsi());
            h.setUrl(ds.getValue(Khotbah.class).getUrl());
            hewanArrayList.add(h);

        }
        if (hewanArrayList.size() > 0) {
            customAdapter = new CustomAdapter(c, hewanArrayList,ref,firebase);

            listView.setAdapter((ListAdapter) customAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                }
            });
        } else {
            Toast.makeText(c, "no data", Toast.LENGTH_SHORT).show();
        }

    }


}