package com.chimichangachew.dnder;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView mUser;
    private TextView mAge;
    private TextView mBio;
    private TextView mTemp;
    private EditText mUseredit;
    private EditText mAgeedit;
    private EditText mBioedit;
    private EditText mTempedit;
    private EditText mTarget;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

}
