package com.example.tugaspraktikum;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
// import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
// import android.widget.TextView;
import android.database.Cursor;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    DataBaseHelper mDB;

    private ListView dataView;
    private Button button2;
    // private TextView name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDB = new DataBaseHelper(this);
        dataView = findViewById(R.id.listView);

        // name = findViewById(R.id.textView2);
        /* String nameS = getIntent().getStringExtra("keyname");
        name.setText(nameS); */

        populateListView();

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> openPage());
    }

    public void openPage() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in ListView.");

        Cursor data = mDB.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            listData.add(data.getString(1));
            listData.add(data.getString(2));
            listData.add(data.getString(3));
        }

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        dataView.setAdapter(adapter);
    }
}