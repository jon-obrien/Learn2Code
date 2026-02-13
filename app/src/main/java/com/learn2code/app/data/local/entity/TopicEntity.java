package com.learn2code.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "topics",
    foreignKeys = @ForeignKey(
        entity = ModuleEntity.class,
        parentColumns = "id",
        childColumns = "moduleId",
        onDelete = ForeignKey.CASCADE
    ),
    indices = {@Index("moduleId")}
)
public class TopicEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long moduleId;
    public String name;

    public TopicEntity() {}

    @Ignore
    public TopicEntity(long id, long moduleId, String name) {
        this.id = id;
        this.moduleId = moduleId;
        this.name = name;
    }
}