package com.kun.jun.khotbahapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements  BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(MainActivity.this);

        Fragment fragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.batas, fragment).commit();
    }
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                Fragment fragment = null;
//                case R.id.navigation_home:
//                    return true;
//                case R.id.navigation_dashboard:
//                     return true;
//            }
//            return false;
//        }
//    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        FragmentManager manager = getSupportFragmentManager();


        if (id == R.id.navigation_home) {
            fragment = new HomeFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.batas,fragment);
            transaction.commit();
        }else if (id == R.id.navigation_dashboard){
            fragment = new FavFragment();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.replace(R.id.batas,fragment);
            transaction.commit();
        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
