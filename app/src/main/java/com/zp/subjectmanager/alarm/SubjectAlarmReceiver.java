package com.zp.subjectmanager.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SubjectAlarmReceiver extends BroadcastReceiver {


    private int i = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "第" + (++i) + "次闹钟", Toast.LENGTH_SHORT).show();
        //添加闹铃、震动等逻辑
    }
}
