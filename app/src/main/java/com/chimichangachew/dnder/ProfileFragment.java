package com.chimichangachew.dnder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    public static Fragment newInstance() {
        Fragment fragment = new ProfileFragment();
        return fragment;
    }

    EditText mUsernameEditText;
    EditText mAgeEditText;
    EditText mBiographyEditText;
    DnDerDatabase mDefaultDatabase;
    Button mCreateProfileButton;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mUsernameEditText = view.findViewById(R.id.editTextProfileSettingsUsername);
        mAgeEditText = view.findViewById(R.id.editTextProfileSettingsAge);
        mBiographyEditText = view.findViewById(R.id.profileSettingsBioEditText);
        mCreateProfileButton = view.findViewById(R.id.buttonCreateProfile);
        mCreateProfileButton.setOnClickListener(this);
        return view;
    }

    public void onClick(View view){
        mDefaultDatabase = DnDerDatabase.getInstance(getActivity().getApplicationContext());
        Profile mProfile = new Profile();

            String username;
        int age;
        String bio;
        if(!mUsernameEditText.getText().toString().equals("") || !mAgeEditText.getText().toString().equals("") ||
        !mBiographyEditText.getText().toString().equals("")) {
            username = mUsernameEditText.getText().toString();
            age = Integer.parseInt(mAgeEditText.getText().toString());
            bio = mBiographyEditText.getText().toString();
            mProfile.setUsername(username);
            mProfile.setAge(age);
            mProfile.setBio(bio);
            mDefaultDatabase.ProfileDao().insertProfile(mProfile);
        }
        else{
            Toast.makeText(view.getContext(),"All Fields are Required!",Toast.LENGTH_SHORT).show();
        }

    }

}