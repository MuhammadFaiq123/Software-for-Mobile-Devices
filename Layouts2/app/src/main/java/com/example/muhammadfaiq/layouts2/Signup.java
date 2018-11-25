package com.example.muhammadfaiq.layouts2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;


public class Signup extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup );
        EditText dob = (EditText) findViewById( R.id.dob );
        dob.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment datepicker = new DatePickerFragment();
                datepicker.show( getSupportFragmentManager(), "date picker" );

            }
        } );
    }

    Boolean bool = Boolean.TRUE;
    String str;

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set( Calendar.YEAR, year );
        c.set( Calendar.MONTH, month );
        c.set( Calendar.DAY_OF_MONTH, dayOfMonth );
        String current_date = DateFormat.getDateInstance().format( c.getTime() );
        final EditText dob = (EditText) findViewById( R.id.dob );
        dob.setText( current_date );

        Button signup = (Button) findViewById( R.id.button_signup );
        signup.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {

                CheckBox checkbox = (CheckBox) findViewById( R.id.checkbox );
                EditText username = (EditText) findViewById( R.id.userName );
                EditText fullname = (EditText) findViewById( R.id.fullName );
                EditText password = (EditText) findViewById( R.id.password );
                EditText email = (EditText) findViewById( R.id.email );
                String E_mail = email.getText().toString();

                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (TextUtils.isEmpty( username.getText().toString() )) {
                    bool=Boolean.FALSE;
                    username.setError( "PLEASE FILL THIS" );
                }
                else{
                    bool=Boolean.TRUE;
                }
                if (TextUtils.isEmpty( fullname.getText().toString() )) {
                    bool=Boolean.FALSE;
                    fullname.setError( "PLEASE FILL THIS" );
                }
                else{
                    bool=Boolean.TRUE;
                }

                if (TextUtils.isEmpty( password.getText().toString() )) {
                    bool=Boolean.FALSE;
                    password.setError( "PLEASE FILL THIS" );
                }
                else{
                    bool=Boolean.TRUE;
                }
                if (!E_mail.matches( emailPattern )) {
                    bool=Boolean.FALSE;
                    email.setError( "Enter Valid mail" );
                }
                else{
                    bool=Boolean.TRUE;
                }
                if (! ((checkbox).isChecked())) {
                    str = " User should accept the Terms and Conditions ";
                    bool = Boolean.FALSE;
                    Toast.makeText( Signup.this, str, Toast.LENGTH_LONG ).show();
                }
                else{
                    bool=Boolean.TRUE;
                }
                if(TextUtils.isEmpty( dob.getText().toString() )){
                    bool=Boolean.FALSE;
                    email.setError( "PLEASE FILL THIS" );
                }
                else{
                    bool=Boolean.TRUE;
                }
                if(bool == Boolean.TRUE){
                    Intent in = new Intent( Signup.this, login.class );
                    startActivity( in );
                     }
            }
        } );
    }
}


