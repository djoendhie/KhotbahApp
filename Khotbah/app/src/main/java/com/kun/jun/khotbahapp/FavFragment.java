package com.kun.jun.khotbahapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kun.jun.khotbahapp.client.FirebaseClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FavFragment extends Fragment {


    FirebaseClient firebaseClient;
    DatabaseReference ref;
    @BindView(R.id.listview)
    ListView listview;
    Unbinder unbinder;
    final static String DB_URL = "https://Khotba-498c3.firebaseio.com/";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ref = FirebaseDatabase.getInstance().getReference("khotbah");
        firebaseClient = new FirebaseClient(this.getContext(), DB_URL,listview, ref);
        firebaseClient.refreshdata();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        unbinder = ButterKnife.bind(this, view);


        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
