package com.example.rentsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int splash_screen=5000;
    Animation topanim,Botanim;
    ImageView image;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        Botanim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        image=findViewById(R.id.imgview);
        tv1=findViewById(R.id.stat);
        image.setAnimation(topanim);
        tv1.setAnimation(Botanim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,HomeScreen.class);
                startActivity(intent);
                finish();
            }
        },splash_screen);
    }
}