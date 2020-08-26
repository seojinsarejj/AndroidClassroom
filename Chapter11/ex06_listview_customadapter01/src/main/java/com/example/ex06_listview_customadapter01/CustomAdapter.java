package com.example.ex06_listview_customadapter01;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter {

    Context context;
    int resource;
    ArrayList<String> datalist;

    public CustomAdapter(Context context, int resource, ArrayList<String> datalist) {
        this.context = context;
        this.resource = resource;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView==null) {
            LayoutInflater inflater= LayoutInflater.from(context);
            convertView= inflater.inflate(resource,null);
        }

        TextView textView = convertView.findViewById(R.id.textViewRow);
        textView.setText(datalist.get(position));
        Button btnModify = convertView.findViewById(R.id.btnModify);
        Button btnDelete = convertView.findViewById(R.id.btnDelete);

        //region 수정버튼
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(context);
                new AlertDialog.Builder(context)
                        .setTitle("리스트뷰 아이템 수정")
                        .setMessage("선택된 데이터 - " + datalist.get(position))
                        .setIcon(R.mipmap.ic_launcher)
                        .setView(editText)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                datalist.set(position, editText.getText().toString());
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("취소",null)
                        .show();
            }
        });
        //endregion

        //region 삭제버튼
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setTitle("리스트뷰 아이템 삭제")
                        .setMessage(datalist.get(position))
                        .setIcon(R.mipmap.ic_launcher_remove)
                        .setCancelable(false)
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                datalist.remove(position);
                                notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("아니오",null)
                        .show();
            }
        });



        //endregion

        return convertView;
    }
}
