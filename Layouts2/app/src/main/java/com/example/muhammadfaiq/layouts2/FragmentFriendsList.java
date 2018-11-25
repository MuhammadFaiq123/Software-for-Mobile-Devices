package com.example.muhammadfaiq.layouts2;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Muhammad Faiq on 10/27/2018.
 */

public class FragmentFriendsList extends Fragment {
    View view;
    private ListView lstView;
    private FloatingActionButton fab;

    public FragmentFriendsList() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        String [] name ={"ALI","HAMZA","FAIQ","TALHA"};
        Integer [] imagId = {R.drawable.temp_imag,R.drawable.temp_imag,R.drawable.temp_imag,R.drawable.temp_imag};

        view = inflater.inflate(R.layout.friends_list, container, false);
        ListView lst = (ListView)view.findViewById(R.id.lstUsers);
        customlistview customelistview1 = new customlistview(getContext(),name,imagId);
        lst.setAdapter( customelistview1 );
        return view;
    }

/*

    String [] name ={"ALI","HAMZA","FAIQ","TALHA"};
    Integer [] imagId = {R.drawable.temp_imag,R.drawable.temp_imag,R.drawable.temp_imag,R.drawable.temp_imag};
    @Override
     void onCreateView(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_friend_list );

        ListView lst = (ListView)findViewById(R.id.listview);
        customlistview customelistview1 = new customlistview( this,name,imagId );
        lst.setAdapter( customelistview1 );
    }*/
}