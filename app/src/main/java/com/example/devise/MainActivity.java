package com.example.devise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

Button btn;
Spinner spinner;
EditText nmber;
TextView textview;
    TextView textview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview1 = (TextView)findViewById(R.id.textView);
        textview = (TextView)findViewById(R.id.textView3);
        btn=findViewById(R.id.button);
        nmber = (EditText) findViewById(R.id.editTextNumber);
        spinner=findViewById(R.id.spinner);
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("To Euro");
        arrayList.add("To Dollars");
        spinner.setAdapter(new ArrayAdapter<>(this , androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,arrayList));
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               DecimalFormat df = new DecimalFormat("0.00");
              String s =spinner.getSelectedItem().toString();
              int nbr=0;
              nbr=Integer.parseInt(nmber.getText().toString());
              if(s=="To Euro"){
                  textview1.setText("EUR");
                  textview.setText(""+df.format((nbr*0.09)));
               }else{
                  textview1.setText("USD");
                  textview.setText(""+df.format((nbr*0.096)));
              }

           }
       });
    }
}