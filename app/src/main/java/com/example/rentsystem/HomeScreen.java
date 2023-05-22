package com.example.rentsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class HomeScreen extends AppCompatActivity {
    CardView home,User,Landlord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        home=findViewById(R.id.homeviewid);
        User=findViewById(R.id.userviewid);
        Landlord=findViewById(R.id.landlordviewid);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScreen.this,Room.class);
                startActivity(intent);
            }
        });
        User.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScreen.this,Tenants.class);
                startActivity(intent);
            }
        });
        Landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeScreen.this,landlord.class);
                startActivity(intent);
            }
        });
    }
}