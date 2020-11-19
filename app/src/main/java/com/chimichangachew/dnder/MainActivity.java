package com.chimichangachew.dnder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //to be converted into a controller to read/write data to the SQL database,
    //TODO: update Android Manifest to use Login.class as the Main activity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

}