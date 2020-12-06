package com.chimichangachew.dnder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


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

    protected void onCreate(Bundle savedInstanceState) {
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
            Temp2.setBio(getString(R.string.bio2));Temp2.setAge(Integer.parseInt(getString(R.string.age2)));Temp2.setUsername(getString(R.string.user2));
            Temp3.setBio(getString(R.string.bio3));Temp3.setAge(Integer.parseInt(getString(R.string.age3)));Temp3.setUsername(getString(R.string.user3));
            Temp4.setBio(getString(R.string.bio4));Temp4.setAge(Integer.parseInt(getString(R.string.age4)));Temp4.setUsername(getString(R.string.user4));
            Temp5.setBio(getString(R.string.bio5));Temp5.setAge(Integer.parseInt(getString(R.string.age5)));Temp5.setUsername(getString(R.string.user5));
            Temp6.setBio(getString(R.string.bio6));Temp6.setAge(Integer.parseInt(getString(R.string.age6)));Temp6.setUsername(getString(R.string.user6));
            Temp7.setBio(getString(R.string.bio7));Temp7.setAge(Integer.parseInt(getString(R.string.age7)));Temp7.setUsername(getString(R.string.user7));
            mDefaultDb.ProfileDao().insertProfiles(profileList);
            mDefaultDb.ProfileDao().insertProfile(Temp1);
        }
    }

}
