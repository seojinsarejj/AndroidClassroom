package com.example.practice;

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

    TextView selectedListItem;
    ListView listView;
    Button addBtn,editBtn,delBtn;
    int selNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedListItem = findViewById(R.id.selectedListItem);
        listView = findViewById(R.id.listView);
        addBtn = findViewById(R.id.addBtn);
        editBtn = findViewById(R.id.editBtn);
        delBtn = findViewById(R.id.delBtn);

        //요구사항 중 1. 초기값은 리스트데이터 1~5
        final ArrayList<String> dataSet = new ArrayList<>();
        dataSet.add("리스트 데이터1"); dataSet.add("리스트 데이터2");
        dataSet.add("리스트 데이터3"); dataSet.add("리스트 데이터4");
        dataSet.add("리스트 데이터5");
        //
        // 리스트뷰의 초기 출력 (어댑터 생성 및 ListView와 dataSet간 연결)
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_single_choice,
                dataSet
        );
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(adapter);
        //

        //요구사항 중 1. 리스트 데이터를 추가한다. (addBtn)
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.add("리스트 데이터" + (dataSet.size()+1));
                adapter.notifyDataSetChanged(); //이 메소드가 존재하지 않으면 갱신X
            }
        });

        // 요구사항 중 2. '선택된' 리스트 아이템을 수정
        //  1.'무엇'을 선택했는지를 판단할 수가 있어야 함
        //  2. '선택된 위치'의 내용을 수정한다
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selNum = position; // 선택된 아이템의 순번값을 바깥으로 넘김
                selectedListItem.setText(dataSet.get(position));
            }
        });

        //editBtn를 눌렀을 때 수정할 수 있도록 중한 코드가 이 곳에 구현
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("리스트 데이터 수정");
                dlg.setMessage(dataSet.get(selNum));
                dlg.setIcon(R.mipmap.ic_launcher_round);
                // 에디트텍스트를 새로 포함시키기
                final EditText et = new EditText(getApplicationContext());
                dlg.setView(et);
                //
                dlg.setNegativeButton("취소",null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //1. EditText(et)에게서 내용물을 가져와 dataSet 갱신
                        dataSet.set(selNum,et.getText().toString());
                        selectedListItem.setText(dataSet.get(selNum));
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataSet.remove(selNum);
                selectedListItem.setText(dataSet.get(selNum));
                adapter.notifyDataSetChanged();;
            }
        });

    }
}
