package com.chimichangachew.dnder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {
    public SettingsActivity() {
        super(R.layout.activity_settings);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.settings_fragment_container, ProfileFragment.class,null)
                    .commit();
        }
    }
}