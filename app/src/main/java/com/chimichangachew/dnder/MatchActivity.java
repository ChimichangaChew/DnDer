package com.chimichangachew.dnder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MatchActivity extends AppCompatActivity {
 //TODO: Implement Later
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        Intent intent = getIntent();
        String user = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);

        TextView mProfile = findViewById(R.id.matchProfileName);
        mProfile.setText(user);
    }
}
