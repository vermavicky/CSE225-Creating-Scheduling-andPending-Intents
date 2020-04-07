package com.BeforeMidTerm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ok.cse225.R;

public class AlarmManagerEx extends AppCompatActivity {
    Button start,RStart,cancel;
    EditText text;
    int i;
    Intent intent;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_manager_ex);
        start=findViewById(R.id.btn_1);
        RStart=findViewById(R.id.btn_2);
        cancel=findViewById(R.id.btn_3);
        text=findViewById(R.id.txt_1);


        intent=new Intent(AlarmManagerEx.this, PendingIntentBroadcast.class);
        pendingIntent=PendingIntent.getBroadcast(AlarmManagerEx.this,234,intent,0);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=Integer.parseInt(text.getText().toString());
                alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);

                Toast.makeText(AlarmManagerEx.this, "Alarm set in"+i+"seconds", Toast.LENGTH_SHORT).show();

            }
        });
        RStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),(1000*5),pendingIntent);
                Toast.makeText(AlarmManagerEx.this, "Repeating Alarm 5 Seconds", Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(AlarmManagerEx.this, "Alarm Canceled", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
