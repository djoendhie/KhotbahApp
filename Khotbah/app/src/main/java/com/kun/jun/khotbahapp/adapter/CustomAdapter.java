package com.kun.jun.khotbahapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.kun.jun.khotbahapp.R;
import com.kun.jun.khotbahapp.client.FirebaseClient;
import com.kun.jun.khotbahapp.client.MyHolder;
import com.kun.jun.khotbahapp.client.PicassoClient;
import com.kun.jun.khotbahapp.model.Khotbah;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<Khotbah> khotbahArrayList;
    LayoutInflater inflater;
    DatabaseReference ref;
    public ImageView img1;
    FirebaseClient firebaseClient;
    Firebase firebase;
    private List<Khotbah> khotba;
    private Context context;


    public CustomAdapter(Context c, ArrayList<Khotbah> khotbahArrayList, DatabaseReference ref, Firebase firebase) {
        this.ref = ref;
        this.c = c;
        this.khotbahArrayList = khotbahArrayList;
        this.firebase = firebase;

    }

    public CustomAdapter(List<Khotbah> list, Context context) {
        this.ref = ref;
        this.context = context;
        khotba = list;

    }


    @Override
    public int getCount() {
        return khotbahArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return khotbahArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_layout, parent, false);
        }
        final MyHolder holder = new MyHolder(convertView);
        holder.nameText.setText(khotbahArrayList.get(position).getJudul());
        holder.infoText.setText(khotbahArrayList.get(position).getTanggal());
        PicassoClient.downloading(c, khotbahArrayList.get(position).getUrl(), holder.img);

        holder.infoText.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

            }
        });
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        return convertView;
    }
 }
