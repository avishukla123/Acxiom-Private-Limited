package com.example.firebaseauth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
EditText e1,e2;
Button b1;
TextView t1;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        e1= findViewById(R.id.ed1);
        e2= findViewById(R.id.ed2);
        b1= findViewById(R.id.button);
        t1= findViewById(R.id.t1);
        firebaseAuth=FirebaseAuth.getInstance();

        b1.setOnClickListener(view -> run());


    }
    public void run() {
        String email,password;
        email=e1.getText().toString();
        password= e2.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void Raw(View view) {
        Intent intent = new Intent( getApplicationContext(), MainActivity2.class);
        startActivity(intent);
    }
}