package com.example.a336819.jhsapplication;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.provider.DocumentsContract;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class AddClasses extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseDatabase mFirebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addclass_layout);

        ArrayList<String> listt = new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference("students");

        AutoCompleteTextView c1 = (AutoCompleteTextView) findViewById(R.id.c1);
        AutoCompleteTextView c2 = (AutoCompleteTextView) findViewById(R.id.c2);
        AutoCompleteTextView c3 = (AutoCompleteTextView) findViewById(R.id.c3);
        AutoCompleteTextView c4 = (AutoCompleteTextView) findViewById(R.id.c4);
        AutoCompleteTextView c5 = (AutoCompleteTextView) findViewById(R.id.c5);
        AutoCompleteTextView c6 = (AutoCompleteTextView) findViewById(R.id.c6);

        InputStream is = getResources().openRawResource(R.raw.coursecatalog);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line;
        int test = 0;
        try {
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String name = values[1];
                listt.add(name);

            }
        } catch (IOException e) {

        }



        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, listt);
        c1.setAdapter(adapter);
        c2.setAdapter(adapter);
        c3.setAdapter(adapter);
        c4.setAdapter(adapter);
        c5.setAdapter(adapter);
        c6.setAdapter(adapter);




    }

}

