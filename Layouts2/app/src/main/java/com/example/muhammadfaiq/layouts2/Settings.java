package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Muhammad Faiq on 10/29/2018.
 */

public class Settings extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    }
    public void Opendeactivate(View v){
        Intent deactivate = new Intent(Settings.this, com.example.muhammadfaiq.layouts2.deactivate.class);
        startActivity(deactivate);
    }

    public void OpenRecovery(View v){
        Intent recovery = new Intent(Settings.this, Recovery.class);
        startActivity(recovery);
    }

    public void OpenLogout(View v){
        Intent logout = new Intent(Settings.this, login.class);
        startActivity(logout);
    }

    public void OpenChangePassword(View v){
        Intent change = new Intent(Settings.this, changepassword.class);
        startActivity(change);
    }
}
