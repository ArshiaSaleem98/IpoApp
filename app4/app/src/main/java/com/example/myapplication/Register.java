package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    private Button button;
    DatabaseClass db;
    EditText user;
    EditText password;
    EditText confirmPassword;
    TextView Register;
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        db= new DatabaseClass(this);
        setContentView(R.layout.register);
        button = (Button) findViewById(R.id.registerbutton);
        user= (EditText) findViewById(R.id.textView7);
        password= (EditText) findViewById(R.id.textView8);
        confirmPassword= (EditText) findViewById(R.id.textView9);
        Register= (TextView) findViewById(R.id.textView10);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registerbutton();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= user.getText().toString().trim();
                String pass= password.getText().toString().trim();
                String confirm= confirmPassword.getText().toString().trim();
                if(pass.equals(confirm)){
                    long val= db.insertData(username,pass);
                    if(val > 0){
                        Toast.makeText(Register.this,"you have registered ",Toast.LENGTH_SHORT).show();
                        Intent myIntent1 = new Intent(Register.this,login.class);
                        startActivity(myIntent1);
                    }else{
                        Toast.makeText(Register.this,"registration error",Toast.LENGTH_SHORT).show();

                    }

                }else{
                    Toast.makeText(Register.this,"password is not match",Toast.LENGTH_SHORT).show();

                }
            }


        });


    }

    public void Registerbutton(){
        Intent myIntent = new Intent(this,login.class);
        startActivity(myIntent);
    }

}
