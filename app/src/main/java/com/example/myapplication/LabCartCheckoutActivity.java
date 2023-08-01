package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabCartCheckoutActivity extends AppCompatActivity {
    EditText edCheckoutName, edCheckoutAdd, edCheckoutCn, edCheckoutPin;
    Button btnBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_cart_checkout);

        edCheckoutName = findViewById(R.id.editTextCheckoutName);
        edCheckoutAdd = findViewById(R.id.editTextCheckoutAddress);
        edCheckoutCn = findViewById(R.id.editTextCheckoutContactNumber);
        edCheckoutPin = findViewById(R.id.editTextCheckoutPincode);
        btnBook = findViewById(R.id.buttonCheckoutBook);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("TotalCost").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date").toString();
        String time= intent.getStringExtra("time").toString();

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);

                db.removeCart(username, "Lab");
                Toast.makeText(LabCartCheckoutActivity.this, "Booking Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LabCartCheckoutActivity.this, HomeActivity.class));
            }
        });
    }
}