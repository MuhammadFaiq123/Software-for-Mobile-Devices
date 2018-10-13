package com.example.muhammadfaiq.database_integration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Muhammad Faiq on 10/13/2018.
 */

public class SignUp extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }
    public void SignUpClick(View v)
    {
        DatabaseHelper helper = new DatabaseHelper(this);

            EditText name = (EditText) findViewById(R.id.editText2);
            EditText pass1 = (EditText) findViewById(R.id.editText);
            EditText pass2 = (EditText) findViewById(R.id.editText5);

            String nameStr = name.getText().toString();
            String pass1Str = pass1.getText().toString();
            String pass2Str = pass2.getText().toString();

            if (nameStr.isEmpty())
            {
                Toast passError = Toast.makeText(SignUp.this , "Enter Name" , Toast.LENGTH_SHORT);
                passError.show();
            }
            else if (pass1Str.isEmpty())
            {
                Toast passError = Toast.makeText(SignUp.this , "Enter Password" , Toast.LENGTH_SHORT);
                passError.show();
            }
            else if (!pass1Str.equals(pass2Str))
            {
                Toast passError = Toast.makeText(SignUp.this , "Password doesn't match" , Toast.LENGTH_SHORT);
                passError.show();
            }
            else
            {
                UserInfo user = new UserInfo();
                user.setName(nameStr);
                user.setPassword(pass1Str);

                helper.insertUser(user);

                Intent i = new Intent(SignUp.this, MainActivity.class);
                startActivity(i);

            }

    }

}