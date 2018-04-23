package com.dot.kun.jun.khotbah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class OthFragment extends Fragment {

    @BindView(R.id.imn)
    ImageView imn;
    @BindView(R.id.tn)
    TextView tn;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oth, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.imn)
    public void onImnClicked() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "12345567788"));
        startActivity(intent);
    }

    @OnClick(R.id.tn)
    public void onTnClicked() {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "12345567788"));
        startActivity(intent);
    }

}
