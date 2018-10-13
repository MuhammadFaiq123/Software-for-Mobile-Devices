package com.example.muhammadfaiq.database_integration;

/**
 * Created by Muhammad Faiq on 10/13/2018.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class Timeline extends AppCompatActivity
{

    ListView listView;
    List<String> userList;
    ArrayAdapter<String> arrayAdapter;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timeline);

        listView        =       findViewById(R.id.listView);
        userList        =       new ArrayList<String>();

        //For ArrayAdapter
        userList = helper.getMessages();

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, userList);
        listView.setAdapter(arrayAdapter);




    }

    public void REFRESH(View view) {

        //For ArrayAdapter
        userList.add("Nothing new");
        arrayAdapter.notifyDataSetChanged();

    }
}

