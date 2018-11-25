package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import Adapters.SlideAdapter;

/**
 * Created by Muhammad Faiq on 10/29/2018.
 */

public class SlideController extends AppCompatActivity {
    private ViewPager viewPager;
    private SlideAdapter myadapter;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_view);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);

          //This is for Relative layout
        btn = (Button) findViewById(R.id.SlideButton);  //This is for Constraint layout
        btn.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v)
            {
                openActivity();
            }
        });


    }
    public void openActivity()
    {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}

