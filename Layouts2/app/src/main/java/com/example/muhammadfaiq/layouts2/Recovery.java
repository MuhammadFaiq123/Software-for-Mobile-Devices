package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;



public class Recovery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recovery );
        Button startBtn = (Button) findViewById( R.id.proceed );
        startBtn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {

                EditText email = (EditText) findViewById( R.id.sent_mail);
                String E_mail = email.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                Boolean bool = Boolean.TRUE;

                if (!E_mail.matches( emailPattern )) {
                    bool=Boolean.FALSE;
                    email.setError( "Enter Valid mail" );
                }
                else{
                    bool = Boolean.TRUE;
                }
                if(bool == Boolean.TRUE){
                    Toast.makeText( Recovery.this,"Email with code sended",Toast.LENGTH_LONG ).show();
                    Intent in = new Intent( Recovery.this, login.class );
                    startActivity( in );
                }
            }
        } );
    }
    /*
    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        Random rand = new Random();
        int  n = rand.nextInt(50) + 1;
        String[] To = {"hamza.usman27@gmal.com"};
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Your new password is"+n);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, To);
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }*/
}

