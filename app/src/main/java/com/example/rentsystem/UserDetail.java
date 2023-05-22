package com.example.rentsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UserDetail extends ArrayAdapter<User> {
 private Activity context;
 private List<User> list;

    public UserDetail(Activity context,List<User>list) {
        super(context,R.layout.listitem,list);
        this.context=context;
        this.list=list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.listitem,null,true);
        TextView TV1=view.findViewById(R.id.tv1);
        TextView TV2=view.findViewById(R.id.tv2);
        TextView TV3=view.findViewById(R.id.tv3);
        TextView TV4=view.findViewById(R.id.tv4);
        User user=list.get(position);

        TV1.setText("নাম:"+user.getUsername());
        TV2.setText("মোবাইল নাম্বার:"+user.getContact());
        TV3.setText("পেশা:"+user.getOccupation());
        TV4.setText("ঘর ভাড়া:"+user.getStatus());
        return view;
    }
}
