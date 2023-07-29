package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });

        CardView FP = findViewById(R.id.cardFDFamilyPhysician);
        FP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsAcitvity.class);
                it.putExtra("title", "Family Physician");
                startActivity(it);
            }
        });

        CardView Dentist = findViewById(R.id.cardFDDentist);
        Dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsAcitvity.class);
                it.putExtra("title", "Dentist");
                startActivity(it);
            }
        });

        CardView dietician = findViewById(R.id.cardFDDIETICIAN);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsAcitvity.class);
                it.putExtra("title", "dietician");
                startActivity(it);
            }
        });

        CardView CDS = findViewById(R.id.cardFDCardiologists);
        CDS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsAcitvity.class);
                it.putExtra("title", "Cardiologists");
                startActivity(it);
            }
        });

        CardView Surgeon = findViewById(R.id.cardFDSurgeon);
        Surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsAcitvity.class);
                it.putExtra("title", "Surgeon");
                startActivity(it);
            }
        });

    }

}