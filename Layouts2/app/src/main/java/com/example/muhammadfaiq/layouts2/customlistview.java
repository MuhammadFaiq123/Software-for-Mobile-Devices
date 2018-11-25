package com.example.muhammadfaiq.layouts2;
import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class customlistview extends ArrayAdapter<String> {

    private String [] name;
    private  Integer [] imagId;
    private Context context;
    public customlistview(Context context, String [] name,Integer [] imagId) {
        super( context, R.layout.friendlist_layout,name );
        this.context = context;
        this.name=name;
        this.imagId = imagId;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r =convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            //LayoutInflater layoutInflater = context.getLayoutInflater();

            r= LayoutInflater.from(context).inflate( R.layout.friendlist_layout,null,true );
            viewHolder = new ViewHolder( r );
            r.setTag( viewHolder );
        }
        else{
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.img.setImageResource( imagId[position] );
        viewHolder.name1.setText( name[position] );

        return r;
    }
    class ViewHolder{
    TextView name1;
    ImageView img;
    ViewHolder(View v) {
            name1 =(TextView) v.findViewById( R.id.name );
            img = (ImageView) v.findViewById( R.id.profile_img );
        }
    }
}

