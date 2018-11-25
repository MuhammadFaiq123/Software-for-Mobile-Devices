package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.muhammadfaiq.layouts2.MainActivity;


public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = (Button)findViewById( R.id.logIn_button );
        login.setOnClickListener( new View.OnClickListener() {
            public void onClick (View v){
                EditText mail = (EditText)findViewById( R.id.email );
                EditText pass = (EditText)findViewById( R.id.password );
                CheckBox checkbox = (CheckBox) findViewById( R.id.checkbox );

                String [] rem_mail = {} ;
                String [] rem_pass = {};

                String E_mail = mail.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                Boolean bool = Boolean.TRUE;

                if (!E_mail.matches( emailPattern )) {
                    bool=Boolean.FALSE;
                    mail.setError( "Enter Valid mail" );
                }
                else{
                    bool=Boolean.TRUE;
                }
                if (TextUtils.isEmpty( pass.getText().toString() )) {
                    bool=Boolean.FALSE;
                    pass.setError( "PLEASE FILL THIS" );
                }

                else{
                    bool=Boolean.TRUE;
                }
                if(bool == Boolean.TRUE){
                    Intent in = new Intent( login.this, MainActivity.class );
                    startActivity( in );
                }
            }
        });
    }

    public void onrForgetClick(View v){
        Intent forget = new Intent(this,Recovery.class);
        startActivity(forget);
    }


}
