package com.example.muhammadfaiq.database_integration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LogIn(View view)
    {
        DatabaseHelper helper = new DatabaseHelper(this);

            EditText text = (EditText) findViewById(R.id.editText3);
            EditText text2 = (EditText) findViewById(R.id.editText4);
            String str = text.getText().toString();
            String str2 = text2.getText().toString();



            if (str.isEmpty())
            {
                Toast passError2 = Toast.makeText(MainActivity.this , "Username not entered" , Toast.LENGTH_SHORT);
                passError2.show();
            }
            else if (str2.isEmpty())
            {
                Toast passError2 = Toast.makeText(MainActivity.this , "Password not entered" , Toast.LENGTH_SHORT);
                passError2.show();
            }
            else
            {
                String Password = helper.searchPassword(str);
                if (Password.equals(str2))
                {
                    Toast passError2 = Toast.makeText(MainActivity.this , "Log in successful" , Toast.LENGTH_SHORT);
                    passError2.show();
                    Intent i = new Intent(MainActivity.this, Timeline.class);
                   // i.putExtra("Username", str);
                    startActivity(i);
                }
                else
                {
                    Toast passError2 = Toast.makeText(MainActivity.this , "Username or password incorrect" , Toast.LENGTH_SHORT);
                    passError2.show();
                }
            }
    }
    public void SignUp(View view)
    {
        Intent i = new Intent(MainActivity.this , SignUp.class);
        startActivity(i);
    }

}
