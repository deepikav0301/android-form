package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_page);
        Intent intent = getIntent();
        String patient_name = intent.getStringExtra(MainActivity.EXTRA_NAME);
        String patient_address = intent.getStringExtra(MainActivity.EXTRA_ADDRESS);
        int patient_age = intent.getIntExtra(MainActivity.EXTRA_AGE,0);
        String patient_dob = intent.getStringExtra(MainActivity.EXTRA_DOB);
        String patient_contact = intent.getStringExtra(MainActivity.EXTRA_CONTACT);
        String patient_gender = intent.getStringExtra(MainActivity.EXTRA_GENDER);
        String patient_addiction = intent.getStringExtra(MainActivity.EXTRA_ADDICTION);
        String patient_time = intent.getStringExtra(MainActivity.EXTRA_TIME);
        String patient_status = intent.getStringExtra(MainActivity.EXTRA_STATUS);
        TextView name = (TextView) findViewById(R.id.patientName);
        TextView address = (TextView) findViewById(R.id.patientAddress);
        TextView age = (TextView) findViewById(R.id.patientAge);
        TextView dob = (TextView) findViewById(R.id.patientDob);
        TextView contact = (TextView) findViewById(R.id.patientContact);
        TextView gender = (TextView) findViewById(R.id.patientGender);
        TextView addiction = (TextView) findViewById(R.id.patientAddiction);
        TextView ptime = (TextView)findViewById(R.id.patientTime);
        TextView marital = (TextView) findViewById(R.id.patientStatus);
        name.setText(patient_name);
        address.setText(patient_address);
        age.setText(""+patient_age);
        dob.setText(patient_dob);
        contact.setText(patient_contact);
        gender.setText(patient_gender);
        addiction.setText(patient_addiction);
        ptime.setText(patient_time);
        marital.setText(patient_status);
    }
}