package com.chimichangachew.dnder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "Profile";
    private TextView mUser;
    private TextView mAge;
    private TextView mBio;
    private TextView mTemp;
    private EditText mTarget;
    private Profile mProfile;
    private DnDerDatabase mDefaultDb;
    private SharedPreferences mSharedPrefs;
    private boolean mDarkTheme;

    protected void onCreate(Bundle savedInstanceState) {
        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mDarkTheme = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (mDarkTheme) {
            setTheme(R.style.DarkTheme);
        }
        super.onCreate(savedInstanceState);
        prepareDatabase();
        Intent intent = getIntent();
        setContentView(R.layout.activity_profile);
        mUser = findViewById(R.id.profileUsernameTextView);
        mAge = findViewById(R.id.displayAgeTextView);
        mBio = findViewById(R.id.displayBioTextView);
        String Target = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
        searchUser(Target);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile_menu,menu);
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
                int theme;
                if(mDarkTheme)
                    theme = R.style.DarkTheme;
                else
                    theme = R.style.AppTheme;
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this,theme));
                builder.setTitle(R.string.helptitle);
                builder.setMessage(R.string.helpbody);
                builder.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onResume() {
        super.onResume();

        // If theme changed, recreate the activity so theme is applied
        boolean darkTheme = mSharedPrefs.getBoolean(SettingsFragment.PREFERENCE_THEME, false);
        if (darkTheme != mDarkTheme) {
            recreate();
        }
    }

    protected void onStop(){
        super.onStop();
        if(LoginActivity.checkCount()){
            Intent intent = new Intent(this, NotificationIntentService.class);
            intent.putExtra(NotificationIntentService.NOTIFY_LEFT, "Left");
            startService(intent);
        }
    }


    protected void searchUser(String Target){
        try {
            mProfile = mDefaultDb.ProfileDao().getProfileName(Target);
            Log.d(TAG, "onCreate: Found Profile!"+ mProfile.getUsername() + " "+ mProfile.getAge() + " "+ mProfile.getBio() + " ");
            mUser.setText(mProfile.getUsername());
            Log.d(TAG, "onCreate: Set User!");
            mAge.setText(String.valueOf(mProfile.getAge()));
            Log.d(TAG, "onCreate: Set Age!");
            mBio.setText(mProfile.getBio());
            Log.d(TAG, "onCreate: set Bio!");
        }
        catch (Exception e) {
            Toast.makeText(this,Target + " could not be found.",Toast.LENGTH_SHORT).show();
        }
    }

    protected void prepareDatabase(){
        mDefaultDb = DnDerDatabase.getInstance(getApplicationContext());
        try {
            Profile Temp = mDefaultDb.ProfileDao().getProfileName(getString(R.string.user1));
            if (Temp.getAge() == 0)
                throw new IndexOutOfBoundsException();
            Log.d(TAG, "onCreate: Found User!");
        }
        catch (Exception e){
            Log.d(TAG, "onCreate: Adding Profile to Database");
            Profile Temp1 = new Profile();
            Profile Temp2 = new Profile();
            Profile Temp3 = new Profile();
            Profile Temp4 = new Profile();
            Profile Temp5 = new Profile();
            Profile Temp6 = new Profile();
            Profile Temp7 = new Profile();
            List<Profile> profileList = Arrays.asList(Temp1,Temp2,Temp3,Temp4,Temp5,Temp6,Temp7);
            Temp1.setBio(getString(R.string.bio1));Temp1.setAge(Integer.parseInt(getString(R.string.age1)));Temp1.setUsername(getString(R.string.user1));
            Temp2.setBio(getString(R.string.bio1));Temp2.setAge(Integer.parseInt(getString(R.string.age2)));Temp2.setUsername(getString(R.string.user2));
            Temp3.setBio(getString(R.string.bio1));Temp3.setAge(Integer.parseInt(getString(R.string.age3)));Temp3.setUsername(getString(R.string.user3));
            Temp4.setBio(getString(R.string.bio1));Temp4.setAge(Integer.parseInt(getString(R.string.age4)));Temp4.setUsername(getString(R.string.user4));
            Temp5.setBio(getString(R.string.bio1));Temp5.setAge(Integer.parseInt(getString(R.string.age5)));Temp5.setUsername(getString(R.string.user5));
            Temp6.setBio(getString(R.string.bio1));Temp6.setAge(Integer.parseInt(getString(R.string.age6)));Temp6.setUsername(getString(R.string.user6));
            Temp7.setBio(getString(R.string.bio1));Temp7.setAge(Integer.parseInt(getString(R.string.age7)));Temp7.setUsername(getString(R.string.user7));
            mDefaultDb.ProfileDao().insertProfiles(profileList);
        }
    }

}
