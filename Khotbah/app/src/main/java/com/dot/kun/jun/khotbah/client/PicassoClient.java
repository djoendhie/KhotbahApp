package com.dot.kun.jun.khotbah.client;

import android.content.Context;
import android.widget.ImageView;

import com.dot.kun.jun.khotbah.R;
import com.dot.kun.jun.khotbah.RecyclerAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by Jun-Kun on 7/19/2017.
 */

public class PicassoClient {
public static  void  downloading(Context c, String url, ImageView img){
    if (url!=null&&url.length()>0){
        Picasso.with(c).load(url).placeholder(R.drawable.noimage).into(img);
    }else{
        Picasso.with(c).load(R.drawable.noimage).into(img);
    }
}

    public static void downloading(RecyclerAdapter recyclerAdapter, Object url, ImageView img) {
    }
}
