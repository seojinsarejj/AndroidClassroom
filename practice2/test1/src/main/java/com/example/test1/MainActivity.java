package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText editText1,editText2;
    Button btnAdd,btnSub,btnMul,btnDiv;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("2211서진");


        editText1 = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        textView = findViewById(R.id.textView);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString().trim();
                String num2 = editText2.getText().toString().trim();

                if(num1.getBytes().length<=0||num2.getBytes().length<=0) {
                    textView.setText("계산결과:");
                }
                else {
                    Double result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textView.setText("계산결과:" + result);
                }

            }
        });


        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString().trim();
                String num2 = editText2.getText().toString().trim();

                if(num1.getBytes().length<=0||num2.getBytes().length<=0) {
                    textView.setText("계산결과:");
                }
                else {
                    Double result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textView.setText("계산결과:" + result);
                }

            }
        });


        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString().trim();
                String num2 = editText2.getText().toString().trim();

                if(num1.getBytes().length<=0||num2.getBytes().length<=0) {
                    textView.setText("계산결과:");
                }
                else {
                    Double result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textView.setText("계산결과:" + result);
                }

            }
        });


        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = editText1.getText().toString().trim();
                String num2 = editText2.getText().toString().trim();

                if(num1.getBytes().length<=0||num2.getBytes().length<=0) {
                    textView.setText("계산결과:");
                }
                else {
                    Double result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textView.setText("계산결과:" + result);
                }

            }
        });


    }
}
