package com.example.tugaspraktikum;

import androidx.appcompat.app.AppCompatActivity;

// import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
// import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button button1, button2;
    public EditText addText, addText2, addText3;

    DataBaseHelper mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB = new DataBaseHelper(this);

        addText = findViewById(R.id.addText);
        addText2 = findViewById(R.id.addText2);
        addText3 = findViewById(R.id.addText3);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            //intent.putExtra("keyname",name);
            startActivity(intent);
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            String name = addText.getText().toString();
            String nim = addText2.getText().toString();
            String prodi = addText3.getText().toString();

            if (addText != null && addText2 != null && addText3 != null) {
                dataAdded(name, nim, prodi);
                addText.setText("");
                addText2.setText("");
                addText3.setText("");
            } else {
                toastMessage("Failed: Must not be null!");
            }
        });
    }

    public void dataAdded(String name, String nim, String prodi) {
        boolean insertData = mDB.addData(name, nim, prodi);

        if (insertData) {
            toastMessage("Data successfully inserted");
        } else {
            toastMessage("Something went wrong");
        }
    }

    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}