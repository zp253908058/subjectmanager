package com.zp.subjectmanager.ui.home;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.zp.subjectmanager.R;
import com.zp.subjectmanager.database.AppDatabase;
import com.zp.subjectmanager.database.dao.SubjectDao;
import com.zp.subjectmanager.database.table.SubjectEntity;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity {

    private CompositeDisposable mDisposable = new CompositeDisposable();

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
        //查询所有
        mDisposable.add(
                dao.getAll()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subjects -> {
                            //获取数据后的处理
                            //subjects的类型是List<SubjectEntity>
                            //Adapter.setList(subjects)
                        }, throwable -> {
                            //出错的时候的处理
                        }));


        //查询单个
        mDisposable.add(
                dao.getOne("Android")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(subject -> {
                            //获取数据后的处理
                            //subject的类型是SubjectEntity
                            //编辑操作
                        }, throwable -> {
                            //出错的时候的处理
                        }));


        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long current = System.currentTimeMillis();
        Intent intent = new Intent();
        intent.setAction("com.subject.action.alarm");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        manager.setRepeating(AlarmManager.RTC_WAKEUP, current + 10000, 60000, pendingIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDisposable.clear();
    }
}
