package com.aasimakhtar.noteme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

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

    public String pad(int input){
        if (input<10)
            return "0"+input;
        else return String.valueOf(input);
    }
}