package com.example.muhammadfaiq.ormlite_integration;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.muhammadfaiq.ormlite_integration.Database.UserRepository;
import com.example.muhammadfaiq.ormlite_integration.Local.UserDataSource;
import com.example.muhammadfaiq.ormlite_integration.Local.UserDatabase;
import com.example.muhammadfaiq.ormlite_integration.Model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private ListView lstView;
    private FloatingActionButton fab;

   //adapter
    List<User> userList = new ArrayList<>();
    ArrayAdapter adapter ;

    //Database
    private CompositeDisposable compositeDisposable;
    private UserRepository userRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //init
        compositeDisposable = new CompositeDisposable();

         //init view
        lstView = (ListView) findViewById(R.id.lstUsers);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, userList);
        lstView.setAdapter(adapter);

         //Database
        UserDatabase userDatabase = UserDatabase.getInstance(this); // create database
        userRepository = UserRepository.getInstance(UserDataSource.getInstance(userDatabase.userDAO()));

        // Load all data from database
        loadData();

        //Event
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // add new user
                // random email

                Disposable disposable = io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {
                    @Override
                    public void subscribe(ObservableEmitter<Object> e) throws Exception {
                        User user = new User("faiq", UUID.randomUUID().toString());
                        userRepository.insertUser(user);
                        e.onComplete();

                    }
                })
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer() {
                                       @Override
                                       public void accept(Object o) throws Exception {
                                           Toast.makeText(MainActivity.this, "User added", Toast.LENGTH_SHORT).show();
                                       }
                                   }, new Consumer<Throwable>() {
                                       @Override
                                       public void accept(Throwable throwable) throws Exception {
                                           Toast.makeText(MainActivity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                       }
                                   }, new Action() {
                                       @Override
                                       public void run() throws Exception {
                                           loadData(); // Refresh data
                                       }
                                   }
                        );
            }
        });
    }


    private void loadData()
    {
        //User rxjava
        Disposable disposable = userRepository.getAllUsers()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        onGetAllUserSuccess(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, ""+throwable.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
        compositeDisposable.add(disposable);

    }

    private void onGetAllUserSuccess(List<User> users)
    {
           userList.clear();
           userList.addAll(users);
           adapter.notifyDataSetChanged();
    }
}
