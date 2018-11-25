package Adapters;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.muhammadfaiq.layouts2.MainActivity;
import com.example.muhammadfaiq.layouts2.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3,
            R.drawable.image_4
    };
    // list of titles
    public String[] lst_title = {
            "Do You Dare",
            "Purpose",
            "Network",
            "About Us"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "DO YOU DARE is a game that deals with users playing truth and dare with each other by sending questiond and replying to them",
            "The purpose of this app is to revive the famous old childhood game we all used to play with your friends",
            "You can socialize with different people,connect with them,make new friends and share your culture with people around the globe",
            "Our premise is simple: we believe questions and answers are the building blocks of conversation, self-expression and deeper understanding. As the only global social network built on a Q&A format, we are a bit different from other services you might use. How you engage with friends and express yourself on our app is done through the lens of what your social connections are curious to learn about you. Through the natural exchange of questions and answers, we aim to be a safe, fun and engaging place for learning more about yourself and exploring the social world around you.  "
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212)
    };


    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);

        container.addView(view);


        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
