package com.kun.jun.khotbahapp.client;

import android.content.Context;
import android.widget.ImageView;

import com.kun.jun.khotbahapp.R;
import com.squareup.picasso.Picasso;


public class PicassoClient {
public static  void  downloading(Context c, String url, ImageView img){
    if (url!=null&&url.length()>0){
        Picasso.with(c).load(url).placeholder(R.drawable.noimage).into(img);
    }else{
        Picasso.with(c).load(R.drawable.noimage).into(img);
    }
}

//    public static void downloading(RecyclerAdapter recyclerAdapter, Object url, ImageView img) {
//    }
}
