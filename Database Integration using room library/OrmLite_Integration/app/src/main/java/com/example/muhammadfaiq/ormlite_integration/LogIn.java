package com.example.muhammadfaiq.ormlite_integration;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.muhammadfaiq.ormlite_integration.Database.UserRepository;
import com.example.muhammadfaiq.ormlite_integration.Local.UserDataSource;
import com.example.muhammadfaiq.ormlite_integration.Local.UserDatabase;
import com.example.muhammadfaiq.ormlite_integration.Model.User;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Muhammad Faiq on 10/14/2018.
 */

public class LogIn extends AppCompatActivity {

    //Database
    private CompositeDisposable compositeDisposable;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        //Database
        UserDatabase userDatabase = UserDatabase.getInstance(this); // create database
        userRepository = UserRepository.getInstance(UserDataSource.getInstance(userDatabase.userDAO()));
    }

    public void LogIn(View view) {
        //   DatabaseHelper helper = new DatabaseHelper(this);

        EditText text = (EditText) findViewById(R.id.editText3);
        EditText text2 = (EditText) findViewById(R.id.editText4);
        String str = text.getText().toString();
        String str2 = text2.getText().toString();


        if (str.isEmpty()) {
            Toast passError2 = Toast.makeText(this, "Username not entered", Toast.LENGTH_SHORT);
            passError2.show();
        } else if (str2.isEmpty()) {
            Toast passError2 = Toast.makeText(this, "Password not entered", Toast.LENGTH_SHORT);
            passError2.show();
        } else {
            //     String Password = helper.searchPassword(str);
            Flowable<User> user = userRepository.getUserByName(str);
            User user2 =  user.blockingFirst();

               if (user2.getPassword().equals(str2))
            {
                Toast passError2 = Toast.makeText(this, "Log in successful", Toast.LENGTH_SHORT);
                passError2.show();
                Intent i = new Intent(this, MainActivity.class);
                // i.putExtra("Username", str);
                startActivity(i);
            }
             else
            {
                Toast passError2 = Toast.makeText(this, "Username or password incorrect", Toast.LENGTH_SHORT);
                passError2.show();
            }
        }
    }

    public void SignUp(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
    }

}