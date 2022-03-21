package com.example.scancontact.ui.home;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.scancontact.R;

public class ListAdapter extends BaseAdapter {
    Context context;
    private final String [] values;
    private final String [] numbers;
    private final int [] images;
    public ListAdapter(Context context, String [] values, String [] numbers, int []
            images){
    //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.values = values;
        this.numbers = numbers;
        this.images = images;
    }
    @Override
    public int getCount() {
        return values.length;
    }
    @Override
    public Object getItem(int i) {
        return i;
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull
            ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.fragment_home_item, parent, false);
            viewHolder.txtContact = (TextView)
                    convertView.findViewById(R.id.contactName);
            viewHolder.txtPhone = (TextView)
                    convertView.findViewById(R.id.phoneNumber);
            viewHolder.flag = (ImageView) convertView.findViewById(R.id.Image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txtContact.setText(values[position]);
        viewHolder.txtPhone.setText("Phone Number: "+numbers[position]);
        viewHolder.flag.setImageResource(images[position]);
        return convertView;
    }
    private static class ViewHolder {
        TextView txtContact;
        TextView txtPhone;
        ImageView flag;
    }
}

