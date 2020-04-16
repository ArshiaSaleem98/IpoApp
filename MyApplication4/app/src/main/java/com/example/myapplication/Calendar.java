package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import yuku.ambilwarna.AmbilWarnaDialog;

public class Calendar extends AppCompatActivity {
    Button colorPicker;
    int DdefaultColor;
    CalendarView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        colorPicker=(Button)findViewById(R.id.colorpicker);
        view=(CalendarView) findViewById(R.id.calendarView);


        colorPicker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                colorPicker();

            }
        });

    }

    private void colorPicker() {
        AmbilWarnaDialog colorpicker = new AmbilWarnaDialog(this, DdefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                DdefaultColor = color;
                view.setBackgroundColor(DdefaultColor);

            }
        });
        colorpicker.show();
    }
}
