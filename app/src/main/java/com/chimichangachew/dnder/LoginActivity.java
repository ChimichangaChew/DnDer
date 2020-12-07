package com.chimichangachew.dnder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private String mUser;
    private EditText mUserName;
    public static final String EXTRA_MESSAGE = "com.chimichangachew.dnder.MESSAGE";
    public static final String KEY_NOTIF_COUNT = "Count";
    private SharedPreferences mSharedPrefs;
    private boolean mDarkTheme;
    private static int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mDarkTheme = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (mDarkTheme) {
            setTheme(R.style.DarkTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName = findViewById(R.id.userEditText);
        if (savedInstanceState != null && savedInstanceState.getInt(KEY_NOTIF_COUNT) != 0) {
            mCount = savedInstanceState.getInt(KEY_NOTIF_COUNT);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(this,
                        SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.help:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // If theme changed, recreate the activity so theme is applied
        boolean darkTheme = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (darkTheme != mDarkTheme) {
            recreate();
        }
    }

    public void onLoginClick(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);

        mUser = mUserName.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, mUser);
        startActivity(intent);
    }

    public void onSearchClick(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);
        EditText mEditTextSearch = (EditText) findViewById(R.id.userEditText);
        intent.putExtra(EXTRA_MESSAGE, mEditTextSearch.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (checkCount()) {
            Intent intent = new Intent(this, NotificationIntentService.class);
            intent.putExtra(NotificationIntentService.NOTIFY_LEFT, "Left");
            startService(intent);
        }
    }

    public void onSaveInstanceState(Bundle savedInsatnceState) {
        super.onSaveInstanceState(savedInsatnceState);
        savedInsatnceState.putInt(KEY_NOTIF_COUNT, mCount);
    }

    public static void resetCount() {
        mCount = 0;
    }

    public static boolean checkCount(){
        if (mCount == 0) {
            mCount++;
            return true;
        }
        else
            return false;
    }
}