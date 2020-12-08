package com.chimichangachew.dnder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {
private String KEY_SETTINGS_ID = "SettingsMenu";
private int mSettingsMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean darkTheme = sharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (darkTheme) {
            setTheme(R.style.DarkTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment_container, new SettingsFragment())
                .commit();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putInt(KEY_SETTINGS_ID, mSettingsMenu);
    }
    public void onProfileClick(View view){
        Fragment mFragment = getFragmentManager().findFragmentById(R.id.settings_fragment_container);
        getFragmentManager().beginTransaction().remove(mFragment).commit();
        Fragment fragment = ProfileFragment.newInstance();
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment_container, fragment).commit();
    }
    public void onSettingsClick(View view){
        Fragment mFragment = getFragmentManager().findFragmentById(R.id.settings_fragment_container);
        getFragmentManager().beginTransaction().remove(mFragment).commit();
        getFragmentManager().beginTransaction()
                .replace(R.id.settings_fragment_container, new SettingsFragment()).commit();
    }

}