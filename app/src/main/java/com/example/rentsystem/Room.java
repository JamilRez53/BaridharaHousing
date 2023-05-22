package com.example.rentsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Room extends AppCompatActivity {
    Animation topanim,botanim;
    TextInputLayout name,contact;
    ImageView im;
    TextView T1,T2;
    Button Login,forgotPassword,Signup;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        im=findViewById(R.id.iview);
        T1=findViewById(R.id.t1);
        T2=findViewById(R.id.t2);
        Login=findViewById(R.id.Logid);
        forgotPassword=findViewById(R.id.pid);
        Signup=findViewById(R.id.signid);
        name=findViewById(R.id.username);
        contact=findViewById(R.id.contact);
        T1.setAnimation(topanim);
        T2.setAnimation(topanim);
        name.setAnimation(botanim);
        contact.setAnimation(botanim);
        Login.setAnimation(botanim);
        forgotPassword.setAnimation(botanim);
        Signup.setAnimation(botanim);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                Intent intent=new Intent(Room.this,Tenants.class);
                startActivity(intent);
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Room.this,Tenants.class);
                startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validUsername()||!validContact()){
                    return;
                }else{
                    String uname=name.getEditText().getText().toString().trim();
                    String ucontact=contact.getEditText().getText().toString().trim();
                    DatabaseReference reference= FirebaseDatabase.getInstance().getReference("User");
                    Query checkUser=reference.orderByChild("username").equalTo(uname);
                    checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.exists()){
                                name.setError(null);
                                name.setErrorEnabled(false);
                                String passFromDB=snapshot.child(uname).child("contact").getValue(String.class);
                                if(passFromDB.equals(ucontact)){
                                    name.setError(null);
                                    name.setErrorEnabled(false);
                                    Intent intent=new Intent(Room.this,Detail.class);
                                    startActivity(intent);
                                }else{

                                    contact.setError("Login Failed");
                                    contact.requestFocus();
                                }
                            }else{
                                name.setError("No Such User Exists");
                                name.requestFocus();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
    private Boolean validUsername(){
        String val=name.getEditText().getText().toString();
        if(val.isEmpty()){
            name.setError("Field Cannot be empty");
            return false;
        }
        else{
            name.setError(null);
            name.setEnabled(false);
            return true;
        }
    }
    private Boolean validContact(){
        String val=contact.getEditText().getText().toString();

        if(val.isEmpty()){
            contact.setError("Field Cannot be empty");
            return false;
        }


        else{
            contact.setError(null);
            contact.setEnabled(false);
            return true;
        }
    }
}