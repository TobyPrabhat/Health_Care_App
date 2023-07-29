package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistorAcitvity extends AppCompatActivity {
    EditText edUsername, edEmail, edPassword, edConfirmPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registor_acitvity);
        edUsername = findViewById(R.id.editTextAppAddress);
        edEmail = findViewById(R.id.editTextAppFullName);
        edPassword = findViewById(R.id.editTextAppContactNumber);
        edConfirmPassword = findViewById(R.id.editTextAppConsFees);
        btn = findViewById(R.id.buttonBookAppointment);
        tv = findViewById(R.id.textViewAlreadyHaveAnAccount);


        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistorAcitvity.this, LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirmPassword = edConfirmPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if(username.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
                    Toast.makeText(RegistorAcitvity.this, "Please Fill All The Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirmPassword)==0){
                        db.registor(username, email, password);
                        startActivity(new Intent(RegistorAcitvity.this, LoginActivity.class));
                        Toast.makeText(RegistorAcitvity.this, "User Inserted", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(RegistorAcitvity.this, "Password Don't Match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}