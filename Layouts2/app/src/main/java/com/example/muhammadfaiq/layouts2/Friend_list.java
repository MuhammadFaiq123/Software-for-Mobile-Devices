package com.example.muhammadfaiq.layouts2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


public class Friend_list extends AppCompatActivity {


    String [] name ={"ALI","HAMZA","FAIQ","TALHA"};
    Integer [] imagId = {R.drawable.temp_imag,R.drawable.temp_imag,R.drawable.temp_imag,R.drawable.temp_imag};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_friend_list );

        ListView lst = (ListView)findViewById(R.id.listview);
        customlistview customelistview1 = new customlistview( this,name,imagId );
        lst.setAdapter( customelistview1 );
     }

}
