package com.example.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.fragment.fragment.CartFragment;
import com.example.fragment.fragment.HomeFragment;
import com.example.fragment.fragment.MineFragment;

public class MainActivity extends BaseActivity {

    protected LinearLayout lHome , lCart, lMine;
    protected Fragment f_home = new HomeFragment();
    protected Fragment f_cart = new CartFragment();
    protected Fragment f_mine = new MineFragment();

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

        lHome.setSelected(true);

        this.getSupportFragmentManager().beginTransaction()
                .add(R.id.content_body,f_home)
                .add(R.id.content_body,f_cart)
                .add(R.id.content_body,f_mine)
                .show(f_home)
                .hide(f_mine)
                .hide(f_cart)
                .commit();
    }

    private void clearSelect() {
        lCart.setSelected(false);
        lHome.setSelected(false);
        lMine.setSelected(false);

        this.getSupportFragmentManager().beginTransaction().hide(f_cart).hide(f_home).hide(f_mine).commit();
    }

    public void onClick(View view) {
        clearSelect();
        view.setSelected(true);
        switch (view.getId()){
            case R.id.tabbar_home:
                this.getSupportFragmentManager().beginTransaction().show(f_home).commit();
                break;
            case R.id.tabbar_cart:
                this.getSupportFragmentManager().beginTransaction().show(f_cart).commit();
                break;
            case R.id.tabbar_mine:
                this.getSupportFragmentManager().beginTransaction().show(f_mine).commit();
                break;
        }



    }
}
