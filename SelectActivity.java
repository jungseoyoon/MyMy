package com.example.syjung.mymy;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.NumberPicker;
import android.widget.TimePicker;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;
public class SelectActivity extends AppCompatActivity{
    CheckBox concent;
    CheckBox meditate;
    CheckBox past;
    CheckBox now;
    Button next;

    TimePickerDialog.OnTimeSetListener tt=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Log.d("test","hour:"+hourOfDay+"minute"+minute);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        concent=(CheckBox)findViewById(R.id.ccheck); //집중 체크박스
        meditate=(CheckBox)findViewById(R.id.mcheck); //명상 체크박스
        past=(CheckBox)findViewById(R.id.past); //과거
        now=(CheckBox)findViewById(R.id.now); //현재
        next=(Button)findViewById(R.id.next); //다음으로

       concent.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(meditate.isChecked()==true){
                   meditate.setChecked(false);
               }
           }
       });
        meditate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(concent.isChecked()==true){
                    concent.setChecked(false);
                }
            }
        });
        past.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(now.isChecked()==true){
                    now.setChecked(false);
                }
            }
        });
        now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(past.isChecked()==true){
                    past.setChecked(false);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(concent.isChecked()==true && past.isChecked()==true ){//집중-과거데이터
                    Intent cp=new Intent(SelectActivity.this,CpActivity.class);
                    Toast.makeText(getApplicationContext(),"집중-과거",Toast.LENGTH_SHORT).show();
                    startActivity(cp);
                }
                else if(concent.isChecked()==true&&now.isChecked()==true ){//집중-현재
                    AimTime at=new AimTime();
                    at.setListener(tt);
                    at.show(getSupportFragmentManager(),"picker");
                    Toast.makeText(getApplicationContext(),"집중 현재",Toast.LENGTH_SHORT).show();

                }
                else if(meditate.isChecked()==true&&past.isChecked()==true ){ //명상-과거
                    Intent mp=new Intent(SelectActivity.this,MpActivity.class);
                    Toast.makeText(getApplicationContext(),"명상 과거",Toast.LENGTH_SHORT).show();
                    startActivity(mp);
                }
                else if(meditate.isChecked()==true&&now.isChecked()==true ){ //명상 현재
                    Intent mn=new Intent(SelectActivity.this,MnActivity.class);
                    Toast.makeText(getApplicationContext(),"명상 현재",Toast.LENGTH_SHORT).show();
                    startActivity(mn);
                }

                else{
                    Toast.makeText(getApplicationContext(),"올바르지 않은 선택입니다",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}