package com.chimichangachew.dnder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.RoomDatabase;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private String mUser;
    public static final String EXTRA_MESSAGE = "com.chimichangachew.dnder.MESSAGE";
    private DnDerDatabase mDefaultDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this,MatchActivity.class);
         EditText mEditTextUser = (EditText)findViewById(R.id.editTextUser);
         mUser = mEditTextUser.getText().toString();
         intent.putExtra(EXTRA_MESSAGE,mUser);
        startActivity(intent);
        }
}
