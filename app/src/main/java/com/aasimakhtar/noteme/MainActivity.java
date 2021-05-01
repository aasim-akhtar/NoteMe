package com.aasimakhtar.noteme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

//    in order to add the menu in our activity OnCreateOptionsMenu is used and we are returning true
//    instead of return super.onCreateOptionsMenu(menu);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu,menu);
        return true;
    }

//    added onOptionsItemSelected, when + button is clicked it'll start AddNoteActivity
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add) {
            Toast.makeText(this, "You just clicked + button", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,AddNoteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
