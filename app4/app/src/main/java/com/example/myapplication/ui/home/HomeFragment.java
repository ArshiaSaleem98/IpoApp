package com.example.myapplication.ui.home;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    EditText textIn;
    Button buttonAdd;
    Button buttonAdd2;
    Calendar c;
    DatePickerDialog dpd;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container
                             ,Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        container = (LinearLayout)root.findViewById(R.id.container);
        textIn = (EditText)root.findViewById(R.id.textin);
        buttonAdd = (Button)root.findViewById(R.id.add);


        final ViewGroup finalContainer = container;
        finalContainer.setVisibility(View.INVISIBLE);
        final ViewGroup finalContainer2 = (LinearLayout) root.findViewById(R.id.container2);;
        finalContainer2.setVisibility(View.INVISIBLE);


        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {

                finalContainer.setVisibility(View.VISIBLE);
                LayoutInflater layoutInflater =(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View addView = layoutInflater.inflate(R.layout.row, null);
                final TextView textOut = (TextView)addView.findViewById(R.id.textout);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                final TextView textOut2 = (TextView)addView.findViewById(R.id.textdate);
                Button buttoncalander = (Button)addView.findViewById(R.id.datepicker);
                buttoncalander.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        c =Calendar.getInstance();
                        int day= c.get(Calendar.DAY_OF_MONTH);
                        int month= c.get(Calendar.MONTH);
                        int year = c.get(Calendar.YEAR);
                        dpd= new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
                                textOut2.setText(mdayOfMonth + "/"+(mmonth+1)+"/"+(myear));
                            }
                        },day,month,year);
                        dpd.show();

                    }});

                buttonRemove.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});
                Button buttondone=(Button)addView.findViewById(R.id.done);
                buttondone.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        finalContainer2.setVisibility(View.VISIBLE);
                        LayoutInflater layoutInflater =(LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View addView2 = layoutInflater.inflate(R.layout.row2, null);
                        final TextView text = (TextView)addView2.findViewById(R.id.textout);
                        final TextView text2 = (TextView)addView2.findViewById(R.id.textdate);

                        Button buttondelete = (Button)addView2.findViewById(R.id.remove);

                         buttondelete.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                ((LinearLayout)addView2.getParent()).removeView(addView2);
                            }});
                         text2.setText(textOut2.getText());
                        text.setText(textOut.getText());
                        text.setPaintFlags(text.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        finalContainer2.addView(addView2);

                    }});

                finalContainer.addView(addView);

            }});


        return root;
    }
}