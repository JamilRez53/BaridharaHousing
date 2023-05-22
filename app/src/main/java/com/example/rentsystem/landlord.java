package com.example.rentsystem;

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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class landlord extends AppCompatActivity {
    Animation topanim,botanim;
    ImageView im;
    TextInputLayout name,password;
    TextView T1,T2;
    Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        name=findViewById(R.id.lusername);
        password=findViewById(R.id.lpassword);
        T1=findViewById(R.id.text1);
        T2=findViewById(R.id.text2);
        Login=findViewById(R.id.log);
        im=findViewById(R.id.imgview);
        T1.setAnimation(topanim);
        T2.setAnimation(topanim);
        name.setAnimation(botanim);
        password.setAnimation(botanim);
        Login.setAnimation(botanim);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=name.getEditText().getText().toString().trim();
                String p=password.getEditText().getText().toString().trim();
                if(!n.equals("admin")||!p.equals("admin")){
                    Toast.makeText(getApplicationContext(),"Oops wrong key!!!",Toast.LENGTH_LONG).show();
                }else{
                    Intent intent=new Intent(getApplicationContext(),Update.class);
                    startActivity(intent);
                }
            }
        });
    }
}