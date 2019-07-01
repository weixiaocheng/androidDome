package com.example.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    protected LinearLayout lHome , lCart, lMine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
    }

    private void bindView() {
        lHome = findViewById(R.id.tabbar_home);
        lCart = findViewById(R.id.tabbar_cart);
        lMine = findViewById(R.id.tabbar_mine);
    }

    private void clearSelect() {
        lCart.setSelected(false);
        lHome.setSelected(false);
        lMine.setSelected(false);
    }

    public void onClick(View view) {
        clearSelect();
        view.setSelected(true);
    }
}
