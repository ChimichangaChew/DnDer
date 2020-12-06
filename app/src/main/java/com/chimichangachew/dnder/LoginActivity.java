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
    private EditText mUserName;
    public static final String EXTRA_MESSAGE = "com.chimichangachew.dnder.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUserName = findViewById(R.id.userEditText);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this,ProfileActivity.class);

         mUser = mUserName.getText().toString();
         intent.putExtra(EXTRA_MESSAGE,mUser);
        startActivity(intent);
        }

    public void onSearchClick(View view){

        Intent intent = new Intent(this,ProfileActivity.class);
        EditText mEditTextSearch = (EditText)findViewById(R.id.userEditText);
        intent.putExtra(EXTRA_MESSAGE,mEditTextSearch.getText().toString());
        startActivity(intent);
    }
}
