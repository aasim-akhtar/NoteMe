package com.aasimakhtar.noteme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creates toolbar
        toolbar=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        recyclerView=findViewById(R.id.listOfNotes);

    }
}
