package com.learn2code.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "topic_info",
    foreignKeys = @ForeignKey(
        entity = TopicEntity.class,
        parentColumns = "id",
        childColumns = "topicId",
        onDelete = ForeignKey.CASCADE
    ),
    indices = {@Index("topicId")}
)
public class InfoEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long topicId;
    public String lang;
    public String sampleCode;

    public InfoEntity() {}

    @Ignore
    public InfoEntity(long topicId, String lang, String sampleCode) {
        this.topicId = topicId;
        this.lang = lang;
        this.sampleCode = sampleCode;
    }
}