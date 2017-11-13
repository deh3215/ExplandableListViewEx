package com.example.a32150.explandablelistviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ArrayList<Map<String, String>> groupList = new ArrayList();
    ArrayList<ArrayList<Map<String, String>>> childList = new ArrayList<>();

    ExpandableListView expListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expListView = (ExpandableListView)findViewById(R.id.expListView);


        HashMap<String, String> m1 = new HashMap<>();
        m1.put("main", "主餐");
        groupList.add(m1);
        HashMap<String, String> m2 = new HashMap<>();
        m2.put("main", "副餐");
        groupList.add(m2);

        HashMap<String, String> m11 = new HashMap<>();
        m11.put("sub", "漢堡");
        HashMap<String, String> m12 = new HashMap<>();
        m12.put("sub", "炸雞");
        HashMap<String, String> m13 = new HashMap<>();
        m13.put("sub", "披薩");

        final ArrayList<Map<String, String>> cList1 = new ArrayList();
        cList1.add(m11);
        cList1.add(m12);
        cList1.add(m13);

        childList.add(cList1);

        HashMap<String, String> m21 = new HashMap<>();
        m21.put("sub", "沙拉");
        HashMap<String, String> m22 = new HashMap<>();
        m22.put("sub", "冰淇淋");
        HashMap<String, String> m23 = new HashMap<>();
        m23.put("sub", "甜點");


        ArrayList<Map<String, String>> cList2 = new ArrayList();
        cList2.add(m21);
        cList2.add(m22);
        cList2.add(m23);

        childList.add(cList2);

        SimpleExpandableListAdapter mAdapter =
                new SimpleExpandableListAdapter(
                        this,
                        groupList,
                        android.R.layout.simple_expandable_list_item_1,
                        new String[] { "main" },
                        new int[] { android.R.id.text1 },
                        childList,
                        android.R.layout.simple_expandable_list_item_2,
                        new String[] { "sub" },
                        new int[] { android.R.id.text2  }
                );

        expListView.setAdapter(mAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                String main= groupList.get(i).get("main");
                String sub= childList.get(i).get(i1).get("sub");
                Toast.makeText(MainActivity.this, main+" = "+sub , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }


}
