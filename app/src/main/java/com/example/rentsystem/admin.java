package com.example.rentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class admin extends AppCompatActivity {
    TextInputLayout etname,etcontact,etoccupation,etstatus;
    Button update,delete;
    String name,contact,occupation,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        etname=findViewById(R.id.nid);
        etcontact=findViewById(R.id.cid);
        etoccupation=findViewById(R.id.oid);
        etstatus=findViewById(R.id.sid);
        update=findViewById(R.id.xid);
        delete=findViewById(R.id.did);
        Intent intent=getIntent();
        name=intent.getStringExtra("নাম:");
        contact=intent.getStringExtra("মোবাইল নাম্বার:");
        occupation=intent.getStringExtra("পেশা:");
        status=intent.getStringExtra("ঘর ভাড়া:");
        etname.getEditText().setText(name);
        etcontact.getEditText().setText(contact);
        etoccupation.getEditText().setText(occupation);
        etstatus.getEditText().setText(status);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=etname.getEditText().getText().toString();
                String c=etcontact.getEditText().getText().toString();
                String o=etoccupation.getEditText().getText().toString();
                String s=etstatus.getEditText().getText().toString();
                User user=new User(n,c,o,s);
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("User").child(n);
                reference.setValue(user);
                Toast.makeText(getApplicationContext(),"Updated data",Toast.LENGTH_LONG).show();
               NotificationCompat.Builder mbuilder=(NotificationCompat.Builder)
                        new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.rental)
                .setContentTitle("BaridharaHousing")
                      .setContentText("বাড়ি ভাড়া তথ্য জানুন");
                NotificationManager notificationManager= (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0,mbuilder.build());
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference reference= FirebaseDatabase.getInstance().getReference("User").child(name);
                reference.removeValue();
                Toast.makeText(getApplicationContext(),"Data Deleted",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),Update.class);
                startActivity(intent);
            }
        });

    }
}