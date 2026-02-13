package com.learn2code.app.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn2code.app.data.local.entity.ModuleEntity;

import java.util.List;

@Dao
public interface ModuleDao {
    @Query("SELECT * FROM modules")
    List<ModuleEntity> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ModuleEntity> modules);

    @Query("DELETE FROM modules")
    void deleteAll();
}