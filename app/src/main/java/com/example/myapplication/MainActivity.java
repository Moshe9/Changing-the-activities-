package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Vat = 15;
    EditText etPrice;
    TextView tvResults;
    Button btnYes,btnNo;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPrice = findViewById(R.id.EtPrice);
        btnNo = findViewById(R.id.btnNo);
        btnYes = findViewById(R.id.btnYes);
        tvResults = findViewById(R.id.tvResults);

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double Price = Double.parseDouble(etPrice.getText().toString());
                double results = (Vat/100.0)*Price;
                double total = Price + results;

                tvResults.setText("DISPLAY RESULTS" +"\n"+"PRICE :" + Price+"\n"+"VAt Rate :" + Vat +"\n"+"Vat Amont :" + results  +"\n"+"TOTAL :" + total );

            }//end method
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this , MainActivity2.class);
             startActivityForResult(intent , 101);
            }//end method
        });
    }//end method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==101 && resultCode == RESULT_OK){
            name = data.getStringExtra("VAT");
            int vat = Integer.parseInt(name);
            double Price = Double.parseDouble(etPrice.getText().toString());
            double results = (vat/100.0)*Price;
            double total = Price + results;

            tvResults.setText("DISPLAY RESULTS" +"\n"+"PRICE :" + Price+"\n"+"VAt Rate :" + vat +"\n"+"Vat Amont :" + results  +"\n"+"TOTAL :" + total );
        }//end if
    }//end method
}//end main mathod