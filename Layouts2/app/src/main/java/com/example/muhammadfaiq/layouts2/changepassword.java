package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class changepassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);
    }

    public void ChangePassword(View v)
    {
        Intent mSingup = new Intent(this, login.class);
        startActivity(mSingup);
    }

}