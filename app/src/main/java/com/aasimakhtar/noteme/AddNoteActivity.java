package com.aasimakhtar.noteme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

//Activity to add new notes
public class AddNoteActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView noteTitle,noteDetails;
    Calendar calendar; //calendar
    String currentDate,currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar); //displays toolbar
        getSupportActionBar().setTitle("New Note"); //change Title from AppName to New Note
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //back action button enabler
        noteTitle = findViewById(R.id.noteTitle);
        noteDetails = findViewById(R.id.noteDetails);

//        To change Toolbar title when text is entered by user in noteTitle
        noteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    getSupportActionBar().setTitle(s);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        getting current date and time
        calendar = Calendar.getInstance();
        currentDate = calendar.get(Calendar.YEAR) +"/"+calendar.get(Calendar.MONTH)+1 +"/"+ calendar.get(calendar.DATE);
//        currentTime = calendar.get(calendar.HOUR) +":"+calendar.get(Calendar.MINUTE);
        currentTime = pad(calendar.get(calendar.HOUR)) +":"+pad(calendar.get(Calendar.MINUTE));
//        pad() is used to get and change something
        Log.d("calendar", "Date & Time: "+currentDate+" "+currentTime);

    }

    private String pad(int input){
        if (input<10)
            return "0"+input;
        else return String.valueOf(input);
    }

//    Menu inflator used to show save_menu.xml
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== R.id.save){
            NoteDTO note = new NoteDTO(noteTitle.getText().toString(),noteDetails.getText().toString(),currentDate,currentTime);
            NoteDatabase db = new NoteDatabase(this);
            db.AddNote(note);
            Toast.makeText(this,"Save",Toast.LENGTH_SHORT).show();
            onBackPressed();
        }
        if (item.getItemId()== R.id.delete){
            Toast.makeText(this,"Delete",Toast.LENGTH_SHORT).show();
            onBackPressed();
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
