package com.learn2code.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "modules")
public class ModuleEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;

    public ModuleEntity() {}

    @Ignore
    public ModuleEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }
}