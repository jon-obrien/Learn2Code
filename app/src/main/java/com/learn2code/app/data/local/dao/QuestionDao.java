package com.learn2code.app.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn2code.app.data.local.entity.QuestionEntity;

import java.util.List;

@Dao
public interface QuestionDao {
    @Query("SELECT * FROM questions WHERE topicId = :topicId AND lang = :lang")
    List<QuestionEntity> getByTopicAndLang(long topicId, String lang);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<QuestionEntity> questions);

    @Query("DELETE FROM questions")
    void deleteAll();
}