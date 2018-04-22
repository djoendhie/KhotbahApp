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
    @BindView(R.id.imn1)
    ImageView imn1;
    @BindView(R.id.tn1)
    TextView tn1;

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

    @OnClick({R.id.imn1, R.id.tn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imn1:
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "12125551212");
                smsIntent.putExtra("sms_body","Body of Message");
                startActivity(smsIntent);
                break;
            case R.id.tn1:
                Intent smsIntent1 = new Intent(Intent.ACTION_VIEW);
                smsIntent1.setType("vnd.android-dir/mms-sms");
                smsIntent1.putExtra("address", "12125551212");
                smsIntent1.putExtra("sms_body","Body of Message");
                startActivity(smsIntent1);
                break;
        }
    }
}
