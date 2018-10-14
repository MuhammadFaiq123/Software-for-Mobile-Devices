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

import java.util.List;
import java.util.UUID;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Muhammad Faiq on 10/14/2018.
 */

public class SignUp extends AppCompatActivity
{
    //Database
    private CompositeDisposable compositeDisposable;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        //Database
        UserDatabase userDatabase = UserDatabase.getInstance(this); // create database
        userRepository = UserRepository.getInstance(UserDataSource.getInstance(userDatabase.userDAO()));

        // Load all data from database
        //loadData();

    }
    public void SignUpClick(View v)
    {
  //      DatabaseHelper helper = new DatabaseHelper(this);

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

            final User user = new User();
            user.setName(nameStr);
            user.setPassword(pass1Str);

//            helper.insertUser(user);

            Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
                @Override
                public void subscribe(ObservableEmitter<Object> e) throws Exception {

                    userRepository.insertUser(user);
                    e.onComplete();

                }
            })
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Consumer() {
                                   @Override
                                   public void accept(Object o) throws Exception {
                                       Toast.makeText(SignUp.this, "User added", Toast.LENGTH_SHORT).show();
                                   }
                               }, new Consumer<Throwable>() {
                                   @Override
                                   public void accept(Throwable throwable) throws Exception {
                                       Toast.makeText(SignUp.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                   }
                               }, new Action() {
                                   @Override
                                   public void run() throws Exception {
                                    //   loadData(); // Refresh data
                                   }
                               }
                    );

            Intent i = new Intent(SignUp.this, LogIn.class);
            startActivity(i);

        }

    }


}