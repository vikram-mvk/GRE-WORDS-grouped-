package com.grehotwordsgrouped;

import android.content.Intent;
import android.database.Cursor;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class noun extends AppCompatActivity{

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        final int intValue = intent.getIntExtra("a", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noun);

        this.listView = (ListView) findViewById(R.id.listView);


        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);


        databaseAccess.open();
        List<String> word = databaseAccess.get(intValue);
        databaseAccess.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, word);
            this.listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    databaseAccess.open();
                    int i=(int)id;
                    String data=(String)parent.getItemAtPosition(position);
                    String hi=databaseAccess.des(i,intValue,data);
                    databaseAccess.close();
                    Toast.makeText(noun.this,hi, Toast.LENGTH_SHORT).show();

                }

        });
    }


}
