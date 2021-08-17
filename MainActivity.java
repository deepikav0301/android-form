package com.example.registrationform;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.example.registrationform.EXTRA_NAME";
    public static final String EXTRA_ADDRESS = "com.example.registrationform.EXTRA_ADDRESS";
    public static final String EXTRA_AGE = "com.example.registrationform.EXTRA_AGE";
    public static final String EXTRA_DOB = "com.example.registrationform.EXTRA_DOB";
    public static final String EXTRA_CONTACT = "com.example.registrationform.EXTRA_CONTACT";
    public static final String EXTRA_GENDER = "com.example.registrationform.EXTRA_GENDER";
    public static final String EXTRA_ADDICTION = "com.example.registrationform.EXTRA_ADDICTION";
    public static final String EXTRA_TIME = "com.example.registrationform.EXTRA_TIME";
    public static final String EXTRA_STATUS = "com.example.registrationform.EXTRA_STATUS";
    Spinner sp;
    DatePicker picker;
    Button displayDate;
    EditText date;
    String pstatus="", paddiction="", pgender="";
    EditText UserName,UserAddress, UserAge, UserContact;
    Button SubmitSave, Reset;
    RadioButton MaleOption,FemaleOption;
    CheckBox smoking,alcohol,noneoption;
    TimePicker Timepicker;
    Button displayTime;
    EditText time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.MaritalStatus);
        UserName=findViewById(R.id.userName);
        UserAddress=findViewById(R.id.userAddress);
        UserAge=findViewById(R.id.userAge);
        UserContact=findViewById(R.id.userContact);
        MaleOption =findViewById(R.id.Male);
        FemaleOption=findViewById(R.id.Female);
        smoking=findViewById(R.id.Smoking);
        alcohol=findViewById(R.id.Alcohol);
        noneoption=findViewById(R.id.NoneOption);
        EditText date1 = findViewById(R.id.date);
        EditText time1 = findViewById(R.id.time);
        SubmitSave=findViewById(R.id.btnSubmit);
        Reset=findViewById(R.id.btnReset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName.setText("");
                UserAddress.setText("");
                UserAge.setText("");
                UserContact.setText("");
                date1.setText("");
                time1.setText("");
                if(MaleOption.isChecked())  {
                    MaleOption.toggle();
                }
                if(FemaleOption.isChecked())    {
                    FemaleOption.toggle();
                }
                if(smoking.isChecked()) {
                    smoking.toggle();
                }
                if(alcohol.isChecked()) {
                    alcohol.toggle();
                }
                if(noneoption.isChecked())  {
                    noneoption.toggle();
                }
            }
        });
        time=findViewById(R.id.time);
        Timepicker=(TimePicker)findViewById(R.id.timePicker);
        displayTime=(Button)findViewById(R.id.button2);

        displayTime.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                time.setText(getCurrentTime());
            }

        });
        SubmitSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = UserName.getText().toString();
                String address=UserAddress.getText().toString();
                String age=UserAge.getText().toString();
                String contact=UserContact.getText().toString();
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }
                else if(age.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter your age",Toast.LENGTH_SHORT).show();
                }
                else if(address.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter your address",Toast.LENGTH_SHORT).show();
                }
                else if (contact.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter your contact number",Toast.LENGTH_SHORT).show();
                }
                else{
                    openDisplayPage();
                }
            }
        });
        date=findViewById(R.id.date);
        picker=(DatePicker)findViewById(R.id.datePicker);
        displayDate=(Button)findViewById(R.id.button1);
        displayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                date.setText(getCurrentDate());
            }

        });

        List<String> marriageStatus=new ArrayList<>();
        marriageStatus.add("Select marital status");
        marriageStatus.add("Married");
        marriageStatus.add("Single");
        ArrayAdapter<String> arrayAdapter;
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,marriageStatus);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(arrayAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if(parent.getItemAtPosition(position).equals("Select marital status")){
                    //Do Nothing
                }
                else{
                    pstatus=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public String getCurrentTime(){
        StringBuilder builder=new StringBuilder();;
        builder.append(Timepicker.getHour()+":");
        builder.append(Timepicker.getMinute()+"");
        return builder.toString();
    }
    public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }
    public void openDisplayPage()   {
        UserName=findViewById(R.id.userName);
        String pname = UserName.getText().toString();
        UserAddress=findViewById(R.id.userAddress);
        String paddress = UserAddress.getText().toString();
        UserAge=findViewById(R.id.userAge);
        int page = Integer.parseInt(UserAge.getText().toString());
        UserContact=findViewById(R.id.userContact);
        String pcontact = UserContact.getText().toString();
        MaleOption =findViewById(R.id.Male);
        FemaleOption=findViewById(R.id.Female);
        if(MaleOption.isChecked())  {
            pgender = MaleOption.getText().toString();
        }
        if(FemaleOption.isChecked())  {
            pgender = FemaleOption.getText().toString();
        }
        smoking=findViewById(R.id.Smoking);
        alcohol=findViewById(R.id.Alcohol);
        noneoption=findViewById(R.id.NoneOption);
        if(smoking.isChecked()) {
            paddiction = smoking.getText().toString();
        }
        if(alcohol.isChecked()) {
            paddiction += alcohol.getText().toString();
        }
        if(noneoption.isChecked()) {
            paddiction += noneoption.getText().toString();
        }

        Intent intent = new Intent(this, DisplayPage.class);
        intent.putExtra(EXTRA_NAME, pname);
        intent.putExtra(EXTRA_ADDRESS, paddress);
        intent.putExtra(EXTRA_AGE, page);
        intent.putExtra(EXTRA_DOB, date.getText().toString());
        intent.putExtra(EXTRA_CONTACT, pcontact);
        intent.putExtra(EXTRA_GENDER, pgender);
        intent.putExtra(EXTRA_ADDICTION, paddiction);
        intent.putExtra(EXTRA_TIME, time.getText().toString());
        intent.putExtra(EXTRA_STATUS, pstatus);
        startActivity(intent);
    }
}