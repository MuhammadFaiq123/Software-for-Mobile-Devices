package com.example.muhammadfaiq.layouts2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by Muhammad Faiq on 10/28/2018.
 */

public class Profile extends AppCompatActivity
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        TextView email = (TextView) findViewById(R.id.profile_email);
        TextView twitter = (TextView) findViewById(R.id.profile_twitter);
        TextView facebook = (TextView) findViewById(R.id.profile_facebook);

        email.setMovementMethod(LinkMovementMethod.getInstance());
        twitter.setMovementMethod(LinkMovementMethod.getInstance());
        facebook.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
