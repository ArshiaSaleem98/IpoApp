package com.example.myapplication;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.contentcapture.ContentCaptureSession;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import yuku.ambilwarna.AmbilWarnaDialog;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;
    RelativeLayout linear;
    EditText textIn;
    Button buttonAdd;
    Button Calendarbutton;
    Button Settings;

    LinearLayout container;
    //main
    LinearLayout container2;
    Button logout;
    EditText textIn1;
    TextView username;
    Button buttonAdd1;
    ViewGroup finalContainer;
    ViewGroup finalContainer2;
    RelativeLayout sidemenulayout;
    Button sidemenu;
    int DdefaultColor;
    LinearLayout checkbox;
    Button removesidemenulayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button6);
        sidemenu =(Button) findViewById(R.id.sidemenu);
        Calendarbutton=(Button) findViewById(R.id.buttonCalendar);
        Settings=(Button) findViewById(R.id.buttonSetting);

        removesidemenulayout= (Button) findViewById(R.id.buttonremovevisibility);
        sidemenulayout=(RelativeLayout) findViewById(R.id.sidemenuLayout);
        sidemenulayout.setVisibility(View.INVISIBLE);
        username = (TextView) findViewById(R.id.username);
        username.setText(getIntent().getStringExtra("username"));
        logout=(Button)findViewById(R.id.logout);
        linear = (RelativeLayout) findViewById(R.id.menu);
        checkbox = (LinearLayout) findViewById(R.id.checkbox);
        Settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               settings();
            }
        });
       Calendarbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar();
            }
        });
        sidemenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sidemenulayout.setVisibility(View.VISIBLE);
            }
        });
        removesidemenulayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sidemenulayout.setVisibility(View.INVISIBLE);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                logout();
            }
        });

        linear.setVisibility(View.INVISIBLE);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                linear.setVisibility(View.VISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                linear.setVisibility(View.INVISIBLE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openPicker();
            }
        });
        container = (LinearLayout) findViewById(R.id.container);

        textIn = (EditText) findViewById(R.id.textin);

        buttonAdd = (Button) findViewById(R.id.add);
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.row, null);

        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                buttonAdd();

            }
        });

        //other
        container2 = (LinearLayout) findViewById(R.id.container1);
        textIn1 = (EditText) findViewById(R.id.textin1);
        buttonAdd1 = (Button) findViewById(R.id.add1);


        finalContainer = container2;
        finalContainer.setVisibility(View.INVISIBLE);
        finalContainer2 = (LinearLayout) findViewById(R.id.container2);
        ;
        finalContainer2.setVisibility(View.INVISIBLE);


        buttonAdd1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                buttonAdd1();


            }
        });


    }

    private void calendar() {
        Intent myIntent = new Intent(this, com.example.myapplication.Calendar.class);
        startActivity(myIntent);

    }
    private void settings() {
        Intent myIntent = new Intent(this, com.example.myapplication.Settings.class);
        startActivity(myIntent);

    }

    private void buttonAdd1() {//main
        finalContainer.setVisibility(View.VISIBLE);
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View addView = layoutInflater.inflate(R.layout.row2, null);
        final TextView textOut = (TextView) addView.findViewById(R.id.textout);
        textOut.setText(textIn1.getText().toString());
        Button buttonRemove = (Button) addView.findViewById(R.id.remove);
        final TextView textOut2 = (TextView) addView.findViewById(R.id.textdate);
        Button buttoncalander = (Button) addView.findViewById(R.id.datepicker);
        buttoncalander.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                final int year = c.get(Calendar.YEAR);
                final DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
                        textOut2.setText(mdayOfMonth + "/" + (mmonth + 1) + "/" + (myear));


                    }
                }, day, month, year);
                dpd.show();


            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((LinearLayout) addView.getParent()).removeView(addView);
            }
        });
        Button buttondone = (Button) addView.findViewById(R.id.done);
        buttondone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finalContainer2.setVisibility(View.VISIBLE);
                LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView2 = layoutInflater.inflate(R.layout.row3, null);
                final TextView text = (TextView) addView2.findViewById(R.id.textout);
                final TextView text2 = (TextView) addView2.findViewById(R.id.textdate);

                Button buttondelete = (Button) addView2.findViewById(R.id.remove);

                buttondelete.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout) addView2.getParent()).removeView(addView2);
                    }
                });
                text2.setText(textOut2.getText());
                text.setText(textOut.getText());
                text.setPaintFlags(text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                finalContainer2.addView(addView2);

            }
        });

        finalContainer.addView(addView);

    }

    private void buttonAdd() {//menu
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View addView = layoutInflater.inflate(R.layout.row, null);
        final TextView textOut = (TextView) addView.findViewById(R.id.textout);
        textOut.setText(textIn.getText().toString());
        addView.setBackgroundColor(DdefaultColor);
        Button buttonRemove = (Button) addView.findViewById(R.id.remove);
        Button activity = (Button) addView.findViewById(R.id.buttonActivity);
        activity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                linear.setVisibility(View.INVISIBLE);
                Drawable background = addView.getBackground();
                checkbox.setBackgroundColor(((ColorDrawable) background).getColor());

            }
        });


        buttonRemove.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((LinearLayout) addView.getParent()).removeView(addView);
            }
        });

        container.addView(addView);
    }

    public void openPicker() {

        AmbilWarnaDialog colorpicker = new AmbilWarnaDialog(this, DdefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                DdefaultColor = color;
            }
        });
        colorpicker.show();


    }
    public void logout(){
        Intent myIntent = new Intent(this, login.class);
        startActivity(myIntent);
    }



}
