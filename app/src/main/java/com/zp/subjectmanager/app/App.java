package com.zp.subjectmanager.app;

import android.app.Application;

import com.zp.subjectmanager.database.AppDatabase;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.init(this);
    }
}
