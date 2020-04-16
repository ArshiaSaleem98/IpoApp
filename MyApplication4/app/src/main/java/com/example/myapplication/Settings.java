package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Settings extends AppCompatActivity {
    Button help;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.settings);
            help=(Button)findViewById(R.id.buttonHelp);
            help.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    help();

                }
            });


        }

    private void help() {
            Intent myIntent = new Intent(this, Help.class);
            startActivity(myIntent);

    }


}
