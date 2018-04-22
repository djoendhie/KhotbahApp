package com.dot.kun.jun.khotbah.Oth;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.dot.kun.jun.khotbah.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CallActivity extends AppCompatActivity {


    @BindView(R.id.imn)
    ImageView imn;
    @BindView(R.id.tn)
    TextView tn;
    @BindView(R.id.imn1)
    ImageView imn1;
    @BindView(R.id.tn1)
    TextView tn1;
    @BindView(R.id.imn2)
    ImageView imn2;
    @BindView(R.id.tn2)
    TextView tn2;
    @BindView(R.id.imn3)
    ImageView imn3;
    @BindView(R.id.tn3)
    TextView tn3;
    static private final String URL = "https://www.facebook.com/djoendhie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.imn)
    public void onImnClicked() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+628123456789"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
            }

    @OnClick(R.id.tn)
    public void onTnClicked() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+628123456789"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    @OnClick(R.id.imn1)
    public void onImn1Clicked() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+628123456789"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);

    }

    @OnClick(R.id.tn1)
    public void onTn1Clicked() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:+628123456789"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
    }

    @OnClick(R.id.imn2)
    public void onImn2Clicked() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @OnClick(R.id.tn2)
    public void onTn2Clicked() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @OnClick(R.id.imn3)
    public void onImn3Clicked() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(URL));
        startActivity(browserIntent);
    }

    @OnClick(R.id.tn3)
    public void onTn3Clicked() {
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
//        browserIntent.setData(Uri.parse(URL));
//        startActivity(browserIntent);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/djoendhie"));
        Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose browser of your choice");
        startActivity(browserChooserIntent );
    }
}
