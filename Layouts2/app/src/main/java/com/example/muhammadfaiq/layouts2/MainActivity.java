package com.example.muhammadfaiq.layouts2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new FragmentHome(),"Home");
        adapter.AddFragment(new FragmentNotifications(),"Notifications");
        adapter.AddFragment(new FragmentFriendsList(),"Friends");




     // controlling the actions of bottom bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_naviagtion);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Intent in = new Intent(MainActivity.this, Settings.class);
                        startActivity(in);
                        break;
                    case R.id.action_profile:
                            Intent in2 = new Intent(MainActivity.this, Profile.class);
                            startActivity(in2);
                            break;
                    case R.id.action_about:
                        Intent in3 = new Intent(MainActivity.this, SlideController.class);
                        startActivity(in3);
                        break;
                }
                return  true;
            }
        });

        // for changing images above title Bar
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                                               @Override
                                               public void onTabSelected(TabLayout.Tab tab) {
                                                   switch (tab.getPosition()) {
                                                       case 0:
                                                           tabLayout.getTabAt(0);
                                                           ImageView imageView = (ImageView) findViewById(R.id.image_id);
                                                           imageView.setImageResource(R.drawable.image_1);
                                                           break;
                                                       case 1:
                                                           tabLayout.getTabAt(1);
                                                           ImageView imageView1 = (ImageView) findViewById(R.id.image_id);
                                                           imageView1.setImageResource(R.drawable.image_2);
                                                           break;
                                                       case 2:
                                                           tabLayout.getTabAt(2);
                                                           ImageView imageView2 = (ImageView) findViewById(R.id.image_id);
                                                           imageView2.setImageResource(R.drawable.image_3);
                                                           break;

                                                   }
                                               }

                                               @Override
                                               public void onTabUnselected(TabLayout.Tab tab) {

                                               }

                                               @Override
                                               public void onTabReselected(TabLayout.Tab tab) {

                                               }
        });


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
