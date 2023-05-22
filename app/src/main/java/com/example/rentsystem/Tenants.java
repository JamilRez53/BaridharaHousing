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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Tenants extends AppCompatActivity {

    Animation topanim,botanim;
    TextInputLayout name,contact,occupation,status;
    ImageView im;
    TextView T1,T2;
    Button singup;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenants);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botanim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        im = findViewById(R.id.iview);
        T1 = findViewById(R.id.t1);
        T2 = findViewById(R.id.t2);
        name = findViewById(R.id.uname);
        contact = findViewById(R.id.contact);
        occupation = findViewById(R.id.occupation);
        status = findViewById(R.id.status);
        singup = findViewById(R.id.sid);
        im.setAnimation(topanim);
        T1.setAnimation(topanim);
        T2.setAnimation(topanim);
        name.setAnimation(botanim);
        contact.setAnimation(botanim);
        status.setAnimation(botanim);
        occupation.setAnimation(botanim);
        singup.setAnimation(botanim);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validUsername() || !validContact() || !validOccupation()) {
                    return;
                }

                String n = name.getEditText().getText().toString().trim();
                String c = contact.getEditText().getText().toString().trim();
                String o = occupation.getEditText().getText().toString().trim();
                String s = status.getEditText().getText().toString().trim();
                // Query checkUser=reference.orderByChild("username").equalTo(n);

                User user = new User(n, c, o, s);
                reference = FirebaseDatabase.getInstance().getReference("User");
                reference.child(n).setValue(user);
                Intent intent = new Intent(Tenants.this, HomeScreen.class);
                startActivity(intent);
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
    private Boolean validOccupation(){
        String val=occupation.getEditText().getText().toString();
        if(val.isEmpty()){
            occupation.setError("Field Cannot be empty");
            return false;
        }

        else if(val.length()>9){
            occupation.setError("Too Long");
            return false;
        }
        else{
            occupation.setError(null);
            return true;
        }
    }
}