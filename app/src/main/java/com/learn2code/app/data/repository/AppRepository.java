package com.learn2code.app.data.repository;

import android.content.Context;

import com.learn2code.app.Info;
import com.learn2code.app.Module;
import com.learn2code.app.Question;
import com.learn2code.app.Topic;
import com.learn2code.app.data.local.AppDatabase;
import com.learn2code.app.data.local.DataPreloader;
import com.learn2code.app.data.local.entity.InfoEntity;
import com.learn2code.app.data.local.entity.ModuleEntity;
import com.learn2code.app.data.local.entity.QuestionEntity;
import com.learn2code.app.data.local.entity.ScoreEntity;
import com.learn2code.app.data.local.entity.TopicEntity;

import java.util.ArrayList;
import java.util.List;

public class AppRepository {
    private static AppRepository instance;
    private final AppDatabase db;
    private final Context context;

    private AppRepository(Context context) {
        this.context = context.getApplicationContext();
        this.db = AppDatabase.getInstance(context);
    }

    public static synchronized AppRepository getInstance(Context context) {
        if (instance == null) {
            instance = new AppRepository(context);
        }
        return instance;
    }

    public void initializeDatabase() {
        DataPreloader preloader = new DataPreloader(context, db);
        preloader.preloadAll();
    }

    public List<Module> getAllModules() {
        List<ModuleEntity> entities = db.moduleDao().getAll();
        List<Module> modules = new ArrayList<>();
        for (ModuleEntity e : entities) {
            modules.add(new Module(e.id, e.name, ""));
        }
        return modules;
    }

    public List<Topic> getTopicsForModule(long moduleId) {
        List<TopicEntity> entities = db.topicDao().getByModuleId(moduleId);
        List<Topic> topics = new ArrayList<>();
        for (TopicEntity e : entities) {
            topics.add(new Topic(e.id, e.name, "", e.moduleId));
        }
        return topics;
    }

    public Info getTopicInfo(long topicId, String language) {
        InfoEntity e = db.infoDao().getByTopicAndLang(topicId, language);
        if (e != null) {
            return new Info(e.topicId, e.sampleCode);
        }
        return null;
    }

    public List<Question> getQuestionsForTopicAndLanguage(long topicId, String language) {
        List<QuestionEntity> entities = db.questionDao().getByTopicAndLang(topicId, language);
        List<Question> questions = new ArrayList<>();
        for (QuestionEntity e : entities) {
            questions.add(new Question(e.id, e.questionText, e.questionCode, e.correctAnswer, e.wrongAnswer1, e.wrongAnswer2, e.wrongAnswer3, e.topicId, e.lang));
        }
        return questions;
    }

    public void insertQuizScore(long topicId, float score) {
        db.scoreDao().insert(new ScoreEntity(topicId, score));
    }

    public List<Float> getQuizScores() {
        return db.scoreDao().getAllScores();
    }

    public void clearQuizScores() {
        db.scoreDao().deleteAll();
    }
}