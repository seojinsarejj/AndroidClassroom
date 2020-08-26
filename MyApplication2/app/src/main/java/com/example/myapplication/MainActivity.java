package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnAdd, btnDel, btnEdit;
    TextView textView;
    int selNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2211서진");


        listView = findViewById(R.id.listView);
        btnAdd = findViewById(R.id.button);
        btnEdit = findViewById(R.id.button2);
        btnDel = findViewById(R.id.button3);
        textView = findViewById(R.id.textView);

        final ArrayList<String> dataset = new ArrayList<>();
        dataset.add("리스트 데이터 1"); dataset.add("리스트 데이터 2");
        dataset.add("리스트 데이터 3"); dataset.add("리스트 데이터 4");
        dataset.add("리스트 데이터 5");

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                dataset
        );

        listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selNum = position;
                textView.setText(dataset.get(selNum));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.add("리스트 데이터 " + (dataset.size() + 1));
                adapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("리스트 아이템 수정");
                dlg.setMessage("현재 데이터 : " + dataset.get(selNum));
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final EditText et = new EditText(getApplicationContext());
                dlg.setView(et);
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataset.set(selNum,et.getText().toString());
                        textView.setText(dataset.get(selNum));
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.remove(selNum);

                adapter.notifyDataSetChanged();


            }
        });


    }
}
