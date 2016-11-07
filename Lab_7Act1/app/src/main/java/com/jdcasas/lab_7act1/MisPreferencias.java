package com.jdcasas.lab_7act1;
import android.os.Bundle;
import android.preference.PreferenceActivity;
public class MisPreferencias extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}





