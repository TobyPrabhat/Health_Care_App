package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package1: Full Body Package", "", "", "", "999"},
            {"Package2: Thyroid Package", "", "", "", "9969"},
            {"Package3: Body Package", "", "", "", "9929"},
            {"Package4: Full Head Package", "", "", "", "9990"},
            {"Package5: Full Check Package", "", "", "", "99"}
    };

    private String[] package_details = {
            "Blood Check Up \n" +
                    "Complete Hamogram\n" +
                    "Immunity CheckUp \n"+
                    "Blood Check Up \n" +
                    "Complete Hamogram\n" +
                    "Immunity CheckUp \n"+
                    "Complete Hamogram\n",
                    "Immunity CheckUp \n"+
                    "Blood Check Up \n" +
                    "Complete Hamogram\n" +
                    "Immunity CheckUp \n"+
                    "Immunity CheckUp \n",
                     "Blood Check Up \n" +
                    "Complete Hamogram\n" +
                    "Immunity CheckUp \n"+
                    "Complete Hamogram\n" +
                    "Immunity CheckUp \n",
                       "Immunity CheckUp \n",
                       "Blood Check Up \n" +
                    "Complete Hamogram\n" +
                    "Immunity CheckUp \n"+
                    "Complete Hamogram\n"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack, btnGoToCart;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnBack = findViewById(R.id.buttonLabTestBackButton);
        btnGoToCart = findViewById(R.id.buttonLabTestGoToCart);
        listView = findViewById(R.id.listViewLabTest);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });


        list = new ArrayList();

        for(int i = 0; i<packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Fees: " + packages[i][4] + "/-" );
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String []{"line1", "line2", "line3", "line4", "line5"},
                new int []{R.id.lineA, R.id.lineB, R.id.lineC, R.id.lineD, R.id.lineE});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[position][0]);
                it.putExtra("text2", package_details[position]);
                it.putExtra("text3", packages[position][4]);
                startActivity(it);
            }
        });
    }
}