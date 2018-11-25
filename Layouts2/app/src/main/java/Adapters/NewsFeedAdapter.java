package Adapters;

/**
 * Created by Muhammad Faiq on 10/28/2018.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;
import com.example.muhammadfaiq.layouts2.R;

import com.example.muhammadfaiq.layouts2.UserData;


public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.ContactViewHolder> {
    private List<UserData> contactList;

    public NewsFeedAdapter(List<UserData> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        Calendar calendar = Calendar.getInstance();
        UserData ci = contactList.get(i);
        //Set the text of the feed with your data
        contactViewHolder.feedText.setText(ci.feed);
        contactViewHolder.surNameText.setText(ci.surName);
        contactViewHolder.nameText.setText(ci.firstName);
        contactViewHolder.feedDate.setText(calendar.getTime().toString());
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.card_layout, viewGroup, false);

        return new ContactViewHolder(itemView);
    }



    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        protected TextView feedText;
        protected TextView nameText;
        protected TextView surNameText;
        protected TextView feedDate;

        public ContactViewHolder(View v) {
            super(v);
            feedText =  (TextView) v.findViewById(R.id.feedText);
            surNameText =  (TextView) v.findViewById(R.id.surName);
            nameText =  (TextView) v.findViewById(R.id.name);
            feedDate =  (TextView) v.findViewById(R.id.date);
        }
    }
}

