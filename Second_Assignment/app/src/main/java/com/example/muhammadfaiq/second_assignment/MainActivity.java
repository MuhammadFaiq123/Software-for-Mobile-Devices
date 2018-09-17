package com.example.muhammadfaiq.second_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    Button btn;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.button2);  //This is for Relative layout
        btn.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v)
            {
                openActivity();
            }
        });

        btn2 = (Button) findViewById(R.id.button1);  //This is for Constraint layout
        btn2.setOnClickListener(new View.OnClickListener(){


            public void onClick(View v)
            {
                openActivity2();
            }
        });
    }
    public void openActivity()
    {
        Intent in = new Intent(this, relative_java.class);
        startActivity(in);
    }

    public void openActivity2()
    {
        Intent in = new Intent(this, constraint_java.class);
        startActivity(in);
    }

}


