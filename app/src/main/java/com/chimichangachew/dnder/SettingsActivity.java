package com.chimichangachew.dnder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class SettingsActivity extends AppCompatActivity {
private String KEY_SETTINGS_ID = "SettingsMenu";
private int mSettingsMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mSettingsMenu = 0;

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.settings_fragment_container);

        if (savedInstanceState == null && fragment == null){
            fragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.settings_fragment_container, ProfileFragment.class,null)
                    .commit();
        }
    }
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putInt(KEY_SETTINGS_ID, mSettingsMenu);
    }
}