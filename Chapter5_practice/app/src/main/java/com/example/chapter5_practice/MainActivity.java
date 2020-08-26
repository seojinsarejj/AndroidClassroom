package com.example.chapter5_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_visible,btn_invisible;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_visible = findViewById(R.id.btn_visible);
        btn_invisible = findViewById(R.id.btn_invisible);
        imageView = findViewById(R.id.imageView);


        //3. 버튼 클릭 이벤트 처리1
        /*btn_visible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
            }
        });

        btn_invisible.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.INVISIBLE);
            }
        });*/

        //4. 버튼 클릭 이벤트 처리2
        View.OnClickListener Listener = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.btn_visible:
                        imageView.setVisibility(View.VISIBLE);
                        break;
                    case R.id.btn_invisible:
                        imageView.setVisibility(View.INVISIBLE);
                        break;
                }
            }

        };

        btn_visible.setOnClickListener(Listener);
        btn_invisible.setOnClickListener(Listener);



    }

    //5. 버튼 클릭 이벤트 처리3
/*    @Override
    public void onClick(View v){
        if(btn_visible.equals(v)){
            imageView.setVisibility(View.VISIBLE);
        }else if(btn_invisible.equals(v)){
            imageView.setVisibility(View.INVISIBLE);
        }
    }*/


}

