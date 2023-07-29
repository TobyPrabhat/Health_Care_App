package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsAcitvity extends AppCompatActivity {

    private String[][] details1 = {
            {"Doctor Name: Dr. John Smith", "Hospital Address: 123 Main Street", "Mobile Number: 123-456-7890", "Experience: 10 years", "2000"},
            {"Doctor Name: Dr. Jane Doe", "Hospital Address: 456 Oak Avenue", "Mobile Number: 987-654-3210", "Experience: 8 years", "2000"},
            {"Doctor Name: Dr. David Johnson", "Hospital Address: 789 Maple Road", "Mobile Number: 111-222-3333", "Experience: 15 years", "2000"},
            {"Doctor Name: Dr. Emily Williams", "Hospital Address: 567 Pine Lane", "Mobile Number: 444-555-6666", "Experience: 5 years", "2000"},
            {"Doctor Name: Dr. Michael Brown", "Hospital Address: 321 Elm Drive", "Mobile Number: 777-888-9999", "Experience: 12 years", "2000"}
    };
    private String[][] details2 = {
            {"Doctor Name: Dr. John Smith", "Hospital Address: 123 Main Street", "Mobile Number: 123-456-7890", "Experience: 10 years", "2000"},
            {"Doctor Name: Dr. Jane Doe", "Hospital Address: 456 Oak Avenue", "Mobile Number: 987-654-3210", "Experience: 8 years", "2000"},
            {"Doctor Name: Dr. David Johnson", "Hospital Address: 789 Maple Road", "Mobile Number: 111-222-3333", "Experience: 15 years", "2000"},
            {"Doctor Name: Dr. Emily Williams", "Hospital Address: 567 Pine Lane", "Mobile Number: 444-555-6666", "Experience: 5 years", "2000"},
            {"Doctor Name: Dr. Michael Brown", "Hospital Address: 321 Elm Drive", "Mobile Number: 777-888-9999", "Experience: 12 years", "2000"}
    };
    private String[][] details3 = {
            {"Doctor Name: Dr. John Smith", "Hospital Address: 123 Main Street", "Mobile Number: 123-456-7890", "Experience: 10 years", "2000"},
            {"Doctor Name: Dr. Jane Doe", "Hospital Address: 456 Oak Avenue", "Mobile Number: 987-654-3210", "Experience: 8 years", "2000"},
            {"Doctor Name: Dr. David Johnson", "Hospital Address: 789 Maple Road", "Mobile Number: 111-222-3333", "Experience: 15 years", "2000"},
            {"Doctor Name: Dr. Emily Williams", "Hospital Address: 567 Pine Lane", "Mobile Number: 444-555-6666", "Experience: 5 years", "2000"},
            {"Doctor Name: Dr. Michael Brown", "Hospital Address: 321 Elm Drive", "Mobile Number: 777-888-9999", "Experience: 12 years", "2000"}
    };
    private String[][] details4 = {
            {"Doctor Name: Dr. John Smith", "Hospital Address: 123 Main Street", "Mobile Number: 123-456-7890", "Experience: 10 years", "2000"},
            {"Doctor Name: Dr. Jane Doe", "Hospital Address: 456 Oak Avenue", "Mobile Number: 987-654-3210", "Experience: 8 years", "2000"},
            {"Doctor Name: Dr. David Johnson", "Hospital Address: 789 Maple Road", "Mobile Number: 111-222-3333", "Experience: 15 years", "2000"},
            {"Doctor Name: Dr. Emily Williams", "Hospital Address: 567 Pine Lane", "Mobile Number: 444-555-6666", "Experience: 5 years", "2000"},
            {"Doctor Name: Dr. Michael Brown", "Hospital Address: 321 Elm Drive", "Mobile Number: 777-888-9999", "Experience: 12 years", "2000"}
    };
    private String[][] details5 = {
            {"Doctor Name: Dr. John Smith", "Hospital Address: 123 Main Street", "Mobile Number: 123-456-7890", "Experience: 10 years", "2000"},
            {"Doctor Name: Dr. Jane Doe", "Hospital Address: 456 Oak Avenue", "Mobile Number: 987-654-3210", "Experience: 8 years", "2000"},
            {"Doctor Name: Dr. David Johnson", "Hospital Address: 789 Maple Road", "Mobile Number: 111-222-3333", "Experience: 15 years", "2000"},
            {"Doctor Name: Dr. Emily Williams", "Hospital Address: 567 Pine Lane", "Mobile Number: 444-555-6666", "Experience: 5 years", "2000"},
            {"Doctor Name: Dr. Michael Brown", "Hospital Address: 321 Elm Drive", "Mobile Number: 777-888-9999", "Experience: 12 years", "2000"}
    };

    TextView tv;
    Button btn;
    String[][] Doctor_Details = {};
    ArrayList arrayList;
    SimpleAdapter sa;
    HashMap<String, String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details_acitvity);

        tv = findViewById(R.id.titleDDTitle);

        Intent it = getIntent();
        String title = it.getStringExtra("title").toString();
        tv.setText(title);

        if(title.compareTo("Family Physician")==0){
            Doctor_Details = details1;
        }
        else if(title.compareTo("Surgeon")==0){
            Doctor_Details = details2;
        }
        else if(title.compareTo("dietician")==0){
            Doctor_Details = details3;
        }
        else if(title.compareTo("Cardiologists")==0){
            Doctor_Details = details4;
        }
        else if(title.compareTo("Dentist")==0){
            Doctor_Details = details5;
        }

        btn = findViewById(R.id.buttonDD);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsAcitvity.this, FindDoctorActivity.class));
            }
        });

        arrayList = new ArrayList();

        for(int i = 0; i<Doctor_Details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", Doctor_Details[i][0]);
            item.put("line2", Doctor_Details[i][1]);
            item.put("line3", Doctor_Details[i][2]);
            item.put("line4", Doctor_Details[i][3]);
            item.put("line5", "Cons Fees: " + Doctor_Details[i][4] + "/-" );
            arrayList.add(item);
        }
        sa = new SimpleAdapter(this, arrayList,
                R.layout.multi_lines,
                new String []{"line1", "line2", "line3", "line4", "line5"},
                new int []{R.id.lineA, R.id.lineB, R.id.lineC, R.id.lineD, R.id.lineE});

        ListView ls = findViewById(R.id.listViewDD);
        ls.setAdapter(sa);

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(DoctorDetailsAcitvity.this, BookAppoittmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", Doctor_Details[position][0]);
                it.putExtra("text3", Doctor_Details[position][1]);
                it.putExtra("text4", Doctor_Details[position][2]);
                it.putExtra("text5", Doctor_Details[position][4]);
                startActivity(it);
            }
        });
    }
}