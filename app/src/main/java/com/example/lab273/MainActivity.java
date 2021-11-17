package com.example.lab273;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button save,load,delete;
    ListView listView;
    public static final String MY_LOG="MyLogs";
    EditText nameET,lastNameET;
    List<String> persons;
    ArrayAdapter<String>adapter;
    MyDBManager dbManager;

    @Override
    protected void onResume() {
        super.onResume();
        dbManager.openDB();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbManager.closeDB();
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        save=findViewById(R.id.saveBut);
        load=findViewById(R.id.loadBut);
        listView=findViewById(R.id.listView);
        nameET=findViewById(R.id.nameET);
        delete=findViewById(R.id.deleteBut);
        lastNameET=findViewById(R.id.lastNameET);
        dbManager=new MyDBManager(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameET.getText().toString();
                String lastName=lastNameET.getText().toString();
                if(name.length()>=2&&lastName.length()>=2){

                dbManager.insertToDB(name,lastName);
                nameET.setText("");
                lastNameET.setText("");}
            }
        });
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persons=dbManager.readFromDB();
                adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,persons);
                listView.setAdapter(adapter);

            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameET.getText().toString();
                String lastName=lastNameET.getText().toString();
                dbManager.removeItem(name,lastName);
            }
        });

    }
}