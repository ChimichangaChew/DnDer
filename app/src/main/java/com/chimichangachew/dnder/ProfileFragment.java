package com.chimichangachew.dnder;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

public class ProfileFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }
}