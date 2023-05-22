package com.example.rentsystem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class UpdateUser extends ArrayAdapter<User> {
    private Activity context;
    private List<User> list;

    public UpdateUser(@NonNull Activity context, List<User> list) {
        super(context, R.layout.update_list, list);
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.update_list,null,true);
        TextView TV1=view.findViewById(R.id.n);
        TextView TV2=view.findViewById(R.id.c);
        TextView TV3=view.findViewById(R.id.o);
        TextView TV4=view.findViewById(R.id.s);
        Button Update=view.findViewById(R.id.fid);
        User user=list.get(position);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),admin.class);
                i.putExtra("নাম:",user.getUsername());
                i.putExtra("মোবাইল নাম্বার:",user.getContact());
                i.putExtra("পেশা:",user.getOccupation());
                i.putExtra("ঘর ভাড়া:",user.getStatus());
                getContext().startActivity(i);
            }
        });

        TV1.setText("নাম:"+user.getUsername());
        TV2.setText("মোবাইল নাম্বার:"+user.getContact());
        TV3.setText("পেশা:"+user.getOccupation());
        TV4.setText("ঘর ভাড়া:"+user.getStatus());
        return view;
    }
}
