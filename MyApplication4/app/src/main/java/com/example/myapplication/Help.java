package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Help extends AppCompatActivity {
    TextView help1;
    TextView help2;
    TextView help3;
    TextView help4;
    TextView help5;
    TextView help6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        help1=(TextView)findViewById(R.id.help1);
        help2=(TextView)findViewById(R.id.help2);
        help3=(TextView)findViewById(R.id.help3);
        help4=(TextView)findViewById(R.id.help4);
        help5=(TextView)findViewById(R.id.help5);
        help6=(TextView)findViewById(R.id.help6);

        SpannableString content = new SpannableString(help1.getText());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        help1.setText(content);

        SpannableString content1 = new SpannableString(help2.getText());
        content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);
        help2.setText(content1);

        SpannableString content2 = new SpannableString(help3.getText());
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        help3.setText(content2);

        SpannableString content3 = new SpannableString(help4.getText());
        content3.setSpan(new UnderlineSpan(), 0, content3.length(), 0);
        help4.setText(content3);

        SpannableString content4 = new SpannableString(help5.getText());
        content4.setSpan(new UnderlineSpan(), 0, content4.length(), 0);
        help5.setText(content4);

        SpannableString content5 = new SpannableString(help6.getText());
        content5.setSpan(new UnderlineSpan(), 0, content5.length(), 0);
        help6.setText(content5);


        final AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });


        help1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder1.setMessage("While writing name for label you will see a color choosing option where you can choose label colour");
                final AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        help2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder1.setMessage("You can see a button of plus ,while clicking this button you will able to add new task in the To Do list");
                final AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        help3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder1.setMessage("Click on side menu ,go to settings and click the button Change Password");
                final AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        help4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder1.setMessage("If you have done a task click on Green tick button to drag the task in Done List");
                final AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

        help5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder1.setMessage("Below login you will find text Forgotten password");
                final AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
        help6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                builder1.setMessage("Above Each there is an option to Edit the task");
                final AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });




    }
    public void showAnswer(){
        Toast.makeText(this,"hola ",Toast.LENGTH_SHORT).show();
    }

}
