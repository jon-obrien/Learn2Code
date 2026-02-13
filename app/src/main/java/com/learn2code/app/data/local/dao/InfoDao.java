package com.learn2code.app.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn2code.app.data.local.entity.InfoEntity;

import java.util.List;

@Dao
public interface InfoDao {
    @Query("SELECT * FROM topic_info WHERE topicId = :topicId AND lang = :lang LIMIT 1")
    InfoEntity getByTopicAndLang(long topicId, String lang);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<InfoEntity> infos);

    @Query("DELETE FROM topic_info")
    void deleteAll();
}