package com.example.syjung.mymy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { //시작버튼 있는 부분
        Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=(Button)findViewById(R.id.startbtn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,SelectActivity.class);
                Toast.makeText(getApplicationContext(), "시작합니다", Toast.LENGTH_SHORT).show();
                startActivity(a);
                finish();
            }
        });

    }
}
