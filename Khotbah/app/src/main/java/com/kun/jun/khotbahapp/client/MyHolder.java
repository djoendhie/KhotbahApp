package com.kun.jun.khotbahapp.client;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kun.jun.khotbahapp.R;


public class MyHolder extends RecyclerView.ViewHolder {
  public TextView nameText,infoText;
   public ImageView img;

    public MyHolder(View view){
        super(view);
        nameText = (TextView)view.findViewById(R.id.nameTxt);
        infoText = (TextView)view.findViewById(R.id.infoTxt);
        img = (ImageView)view.findViewById(R.id.beachimage);
    }
}
