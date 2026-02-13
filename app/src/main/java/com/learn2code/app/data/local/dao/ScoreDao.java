package com.learn2code.app.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn2code.app.data.local.entity.ScoreEntity;

import java.util.List;

@Dao
public interface ScoreDao {
    @Query("SELECT * FROM quiz_scores")
    List<ScoreEntity> getAll();

    @Query("SELECT score FROM quiz_scores")
    List<Float> getAllScores();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ScoreEntity score);

    @Query("DELETE FROM quiz_scores")
    void deleteAll();
}