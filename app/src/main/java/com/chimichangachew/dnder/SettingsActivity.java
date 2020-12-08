package com.chimichangachew.dnder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {
private final String KEY_SETTINGS_ID = "SettingsMenu";
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
    public void generateNotification() {
        Intent intent = new Intent(this,NotificationIntentService.class);
        intent.putExtra(NotificationIntentService.NOTIFY_LEFT,"Test");
        startService(intent);
    }
}