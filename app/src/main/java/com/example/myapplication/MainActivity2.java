package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText ETvatRate;
    Button btnNewRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ETvatRate = findViewById(R.id.ETvatRate);
        btnNewRate = findViewById(R.id.btnNewRate);
        btnNewRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("VAT" , ETvatRate.getText().toString().trim());
                setResult(RESULT_OK , intent);
                MainActivity2.this.finish();
            }//end method
        });
    }//end method
}//end class