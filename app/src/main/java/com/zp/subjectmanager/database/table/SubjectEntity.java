package com.zp.subjectmanager.database.table;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "subject")
public class SubjectEntity {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public String name;

    @ColumnInfo(name = "teacher_name")
    public String teacherName;
}
