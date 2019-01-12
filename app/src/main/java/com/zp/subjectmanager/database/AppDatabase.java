package com.zp.subjectmanager.database;

import com.zp.subjectmanager.database.table.SubjectEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {SubjectEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

}
