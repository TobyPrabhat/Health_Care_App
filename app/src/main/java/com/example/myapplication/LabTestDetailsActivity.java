package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetailsActivity extends AppCompatActivity {

    TextView packageName, TotalCost;
    EditText edDetails;
    Button btnBack, btnAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        packageName = findViewById(R.id.titleLabTestDetails);
        TotalCost = findViewById(R.id.textViewLabTestDetailsTotalCost);
        edDetails = findViewById(R.id.editTextLabTestDetails);
        btnBack = findViewById(R.id.buttonLabTestDetailsBackButton);
        btnAddToCart = findViewById(R.id.buttonLabTestDetailsAddToCart);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        packageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        TotalCost.setText(intent.getStringExtra("Total Cost " + "text3" + " /-"));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = intent.getStringExtra("text1").toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if(db.checkCart(username, product) == 1){
                    Toast.makeText(LabTestDetailsActivity.this, "Item Already Added", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addToCart(username, product, price, "Lab");
                    Toast.makeText(LabTestDetailsActivity.this, "Item Added", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }
}