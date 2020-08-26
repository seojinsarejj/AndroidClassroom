package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView textView;
    RadioButton btnCam,btnCall;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView);
        btnCam = findViewById(R.id.btnCam);
        btnCall = findViewById(R.id.btnCall);
        btn = findViewById(R.id.button2);

        final Intent inIntent = getIntent();
        String title = inIntent.getStringExtra("title");
        textView.setText(title);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent;

                if(btnCall.isChecked()) {
                    outIntent = new Intent(getApplicationContext(),MainActivity.class);
                    outIntent.putExtra("content","call");
                    setResult(RESULT_OK,outIntent);
                    finish();

                }else if(btnCam.isChecked()) {
                    outIntent = new Intent(getApplicationContext(),MainActivity.class);
                    outIntent.putExtra("content","cam");
                    setResult(RESULT_OK,outIntent);
                    finish();
                }

            }
        });



    }
}
