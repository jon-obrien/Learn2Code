package com.learn2code.app.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.learn2code.app.data.local.dao.InfoDao;
import com.learn2code.app.data.local.dao.ModuleDao;
import com.learn2code.app.data.local.dao.QuestionDao;
import com.learn2code.app.data.local.dao.ScoreDao;
import com.learn2code.app.data.local.dao.TopicDao;
import com.learn2code.app.data.local.entity.InfoEntity;
import com.learn2code.app.data.local.entity.ModuleEntity;
import com.learn2code.app.data.local.entity.QuestionEntity;
import com.learn2code.app.data.local.entity.ScoreEntity;
import com.learn2code.app.data.local.entity.TopicEntity;

@Database(
    entities = {
        ModuleEntity.class,
        TopicEntity.class,
        InfoEntity.class,
        QuestionEntity.class,
        ScoreEntity.class
    },
    version = 1,
    exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {
    private static volatile AppDatabase INSTANCE;
    private static final String DATABASE_NAME = "learn2code.db";

    public abstract ModuleDao moduleDao();
    public abstract TopicDao topicDao();
    public abstract InfoDao infoDao();
    public abstract QuestionDao questionDao();
    public abstract ScoreDao scoreDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        AppDatabase.class,
                        DATABASE_NAME
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }
}