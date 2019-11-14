package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DynamicListView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview);
        setTitle("동적 리스트 뷰 테스트");

        // (자료구조에서 배운)ArrayList를 사용하여 add, remove
        // 정적 리스트뷰(변경이 필요없는)를 구현하고 싶은 경우
        // String[] 과 같이 배열을 사용하여 선언하면 됨.
        final ArrayList<String> list = new ArrayList<String>();

        ListView listView = (ListView)findViewById(R.id.listView);

        // 두 번째 파라미터(simple_list_item): 리스트뷰의 형식
        // 세 번째 파라미터: 리스트뷰에 적용할 내용들(ArrayList)
        final ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        list);

        // listView에 어댑터를 사용하겠다고 연결
        listView.setAdapter(adapter);

        final EditText edtItem = (EditText)findViewById(R.id.addItemText);
        Button addBtn = (Button)findViewById(R.id.addListViewBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(edtItem.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // 입력인자(순서대로): 어댑터뷰, 뷰, 클릭항목의 순번, 항목의 아이디
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DynamicListView.this,
                        (i+1) + "번째 리스트뷰 선택됨",
                        Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final int index = i;
                AlertDialog.Builder dlg = new AlertDialog.Builder(DynamicListView.this);
                dlg.setMessage((index+1) + "번째 리스트뷰: " + list.get(i).toString()
                        +"\n 제거하시겠습니까?");
                dlg.setNegativeButton("취소", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        list.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                });
                dlg.show();
                return false;
            }
        });
    }
}
