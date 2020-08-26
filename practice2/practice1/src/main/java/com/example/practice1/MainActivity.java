
package com.example.practice1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView selectedlistitem ;
    Button btnAdd,btnDel,btnEdit;
    ListView listView;
    int selNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        selectedlistitem = findViewById(R.id.selectedListItem);
        btnAdd = findViewById(R.id.addBtn);
        btnEdit = findViewById(R.id.editBtn);
        btnDel = findViewById(R.id.delBtn);
        listView = findViewById(R.id.listView);

        final ArrayList<String> dataset = new ArrayList<>();
        dataset.add("아이템 " + 1); dataset.add("아이템 " + 2);
        dataset.add("아이템 " + 3); dataset.add("아이템 " + 4);
        dataset.add("아이템 " + 5);

        final ArrayAdapter arrayAdapter = new ArrayAdapter(
                this,android.R.layout.simple_list_item_single_choice,
                dataset
        );

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selNum = position;
                selectedlistitem.setText(dataset.get(position));
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.add("아이템 " + (dataset.size()+1));
                arrayAdapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("리스트 아이템 수정");
                dlg.setMessage("현재 데이터 : " + dataset.get(selNum));
                dlg.setIcon(R.mipmap.ic_launcher_round);

                final EditText editText = new EditText(getApplicationContext());
                dlg.setView(editText);
                dlg.setNegativeButton("취소",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataset.set(selNum,editText.getText().toString());
                        arrayAdapter.notifyDataSetChanged();
                    }
                });
                dlg.show();


            }
        });



        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataset.remove(selNum);
                arrayAdapter.notifyDataSetChanged();
            }
        });



    }
}
