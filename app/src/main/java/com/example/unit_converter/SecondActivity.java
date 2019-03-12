package com.example.unit_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txtInput;
    TextView txtInput2;
    TextView txtSend1;
    TextView txtSend2;
    TextView txtSend3;
    String unit;
    double inch,cm,meter,km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtInput = findViewById(R.id.txt_input);
        txtInput2 = findViewById(R.id.txt_input2);
        txtSend1 = findViewById(R.id.txt_Send1);
        txtSend2 = findViewById(R.id.txt_Send2);
        txtSend3 = findViewById(R.id.txt_Send3);
        Bundle bundle = getIntent().getExtras();
        float input = bundle.getFloat("input");
        txtInput.setText("" + input);
        int value = bundle.getInt("value");
        Log.i("dfgh", "value = " + value);
        if(value == 1){
            unit = "inch";
            inch = input;
            cm = input * 2.54f;
            meter = input * 0.0254f;
            km = input * 0.00002f;
            Log.i("dfgh", "send1 = " + cm + " cm");
            Log.i("dfgh", "send2 = " + meter + " m");
            Log.i("dfgh", "send3 = " + km + " km");
            txtSend1.setText(""+ cm + "\t\t" + "cm");
            txtSend2.setText(""+ meter + "\t\t" + "meter");
            txtSend3.setText(""+ km + "\t\t" + "km");
        }
        else if(value == 2) {
            unit = "cm";
            cm = input;
            inch = input / 2.54f;
            meter = input * 0.01f;
            km = input * 0.01 * 1000f;

            txtSend1.setText(""+ inch + "\t\t" + "inch");
            txtSend2.setText(""+ meter + "\t\t" + "meter");
            txtSend3.setText(""+ km + "\t\t" + "km");
        }
        else if(value == 3) {
            unit = "meter";
            meter = input;
            inch = (input * 100) / 2.54;
            cm = input * 100;
            km = input / 1000;

            txtSend1.setText(""+ inch + "\t\t" + "inch");
            txtSend2.setText(""+ cm + "\t\t" + "cm");
            txtSend3.setText(""+ km + "\t\t" + "km");
        }
        else if(value == 4){
            unit = "km";
            km = input;
            inch = (input * 1000 * 100) / 2.54;
            cm = (input * 1000 * 100);
            meter = input * 1000;

            txtSend1.setText(""+ inch + "\t\t" + "inch");
            txtSend2.setText(""+ cm + "\t\t" + "cm");
            txtSend3.setText(""+ meter + "\t\t" + "meter");
        }
        txtInput2.setText(unit);



    }
}
