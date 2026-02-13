package com.learn2code.app.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn2code.app.data.local.entity.TopicEntity;

import java.util.List;

@Dao
public interface TopicDao {
    @Query("SELECT * FROM topics WHERE moduleId = :moduleId")
    List<TopicEntity> getByModuleId(long moduleId);

    @Query("SELECT * FROM topics")
    List<TopicEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TopicEntity> topics);

    @Query("DELETE FROM topics")
    void deleteAll();
}