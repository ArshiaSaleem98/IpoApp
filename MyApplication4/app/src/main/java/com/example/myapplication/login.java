package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private Button button;
    EditText user;
    EditText password;
    TextView Register;
    DatabaseClass db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db= new DatabaseClass(this);
        button = (Button) findViewById(R.id.button);
        user= (EditText) findViewById(R.id.textView2);
        password= (EditText) findViewById(R.id.textView3);
        Register= (TextView) findViewById(R.id.textView6);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Registerbutton();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u= user.getText().toString().trim();
                String p= password.getText().toString().trim();
                if(u.isEmpty()& p.isEmpty()){
                    Toast.makeText(login.this,"all fields should be completed ",Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean res = db.checkuser(u, p);
                    db.close();
                    if (res == true) {

                        Intent myIntent = new Intent(login.this, MainActivity.class);
                        myIntent.putExtra("username",user.getText().toString());
                        startActivity(myIntent);
                        Toast.makeText(login.this, "successfully login", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(login.this, "login error", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });




    }
    public void Registerbutton(){
        Intent myIntent = new Intent(this,Register.class);
        startActivity(myIntent);
    }


}
