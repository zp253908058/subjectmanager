package com.zp.subjectmanager.database.dao;

import com.zp.subjectmanager.database.table.SubjectEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;

@Dao
public interface SubjectDao {

    @Query("select * from subject")
    List<SubjectEntity> getAll();

    @Query("select * from subject where name = :name and teacher_name = :teacherName")
    SubjectEntity getOne(String name, String teacherName);

    @Insert
    void add(SubjectEntity... entities);

    @Delete
    void delete(SubjectEntity entity);

    @Update
    void update(SubjectEntity entity);
}
