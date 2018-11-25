package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }

    public void onrSClick(View v){
        Intent mSingup = new Intent(this, Signup.class);
        startActivity(mSingup);
    }
    public void oncLClick(View v){
        Intent m_login = new Intent(this, login.class);
        startActivity(m_login);
    }
}
