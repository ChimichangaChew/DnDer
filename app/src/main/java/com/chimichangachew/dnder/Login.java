package com.chimichangachew.dnder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private String mUser;
    public static final String EXTRA_MESSAGE = "com.chimichangachew.dnder.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match);
    }

    public void onLoginClick(View view){
        Intent intent = new Intent(this,MatchActivity.class);
        //  EditText mEditTextUser = (EditText)findViewById(R.id.editTextUser);
        //   mUser = mEditTextUser.getText().toString();
        //   intent.putExtra(EXTRA_MESSAGE,mUser);
        startActivity(intent);
        //setContentView(R.layout.match); This works but doesn't actually create a new activity, so i need to update this block to actually create a Match Activity rather than just update the content view.
    }
}
