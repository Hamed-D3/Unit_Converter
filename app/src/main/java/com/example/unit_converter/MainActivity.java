package com.example.unit_converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    EditText edtInput;
    RadioGroup rg;
    RadioButton RBinch,RBcm,RBmeter,Rbkm;
    float txt;
    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btn_send);
        edtInput = findViewById(R.id.edt_input);
        rg = findViewById(R.id.RadioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int CheckId) {
                if(CheckId == R.id.RB_inch){
                    value = 1;
                }
                else if(CheckId == R.id.RB_cm){
                    value = 2;
                }
                else if(CheckId == R.id.RB_meter){
                    value = 3;
                }
                else if(CheckId == R.id.RB_km){
                    value = 4;
                }
            }
        });


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt = Float.parseFloat(edtInput.getText().toString());
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("input", txt);
                intent.putExtra("value", value);
                startActivity(intent);
            }
        });

        /*public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((rg) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.RB_inch:
                    if (checked){
                        inch = txt;
                        cm = txt * 2.54;
                        meter = txt * 0.0254;
                        km = txt * 0.00002;
                    }
                    break;
                case R.id.RB_cm:
                    if (checked){
                        cm = txt;
                        inch = txt / 2.54;
                        meter = txt * 0.01;
                        km = txt * 0.01 * 1000;
                    }
                    break;
                case R.id.RB_meter:
                    if (checked){
                        meter = txt;
                        inch = (txt * 100) / 2.54;
                        cm = txt * 100;
                        km = txt / 1000;
                    }
                    break;
                case R.id.RB_km:
                    if (checked){
                        km = txt;
                        inch = (txt * 1000 * 100) / 2.54;
                        cm = (txt * 1000 * 100);
                        meter = txt * 1000;
                    }
                    break;
            }
        }*/



    }

}
