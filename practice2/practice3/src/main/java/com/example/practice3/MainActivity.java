package com.example.practice3;

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
    Button addBtn,editBtn,delBtn;
    TextView textView;
    int selNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);
        editBtn = findViewById(R.id.editBtn);
        delBtn = findViewById(R.id.delBtn);
        textView = findViewById(R.id.selectedListItem);

        final ArrayList<String> dataset = new ArrayList<>();
        dataset.add("아이템 " + 1); dataset.add("아이템 " + 2);
        dataset.add("아이템 " + 3); dataset.add("아이템 " + 4);
        dataset.add("아이템 " + 5);

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

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.add("아이템 " + (dataset.size()+1));
                adapter.notifyDataSetChanged();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("ㅁㄴㅇㄹ");
                dlg.setMessage("asdf");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                final EditText et = new EditText(getApplicationContext());
                dlg.setView(et);
                dlg.setNegativeButton("취소",null);
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

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.remove(selNum);
                textView.setText(dataset.get(selNum));
                adapter.notifyDataSetChanged();
            }
        });

    }
}
