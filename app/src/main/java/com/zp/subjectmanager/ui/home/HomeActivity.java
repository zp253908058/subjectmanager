package com.zp.subjectmanager.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Flowable;

import android.os.Bundle;

import com.zp.subjectmanager.R;
import com.zp.subjectmanager.database.AppDatabase;
import com.zp.subjectmanager.database.dao.SubjectDao;
import com.zp.subjectmanager.database.table.SubjectEntity;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);

        AppDatabase database = AppDatabase.getInstance();

        SubjectEntity entity = new SubjectEntity();
        SubjectDao dao = database.getSubjectDao();
        //增加
        dao.add(entity);
        //删除
        dao.delete(entity);
        //查询
        List<SubjectEntity> list = dao.getAll();
    }
}
