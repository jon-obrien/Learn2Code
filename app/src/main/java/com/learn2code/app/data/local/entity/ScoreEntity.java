package com.learn2code.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "quiz_scores",
    foreignKeys = @ForeignKey(
        entity = TopicEntity.class,
        parentColumns = "id",
        childColumns = "topicId",
        onDelete = ForeignKey.CASCADE
    ),
    indices = {@Index("topicId")}
)
public class ScoreEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long topicId;
    public float score;

    public ScoreEntity() {}

    @Ignore
    public ScoreEntity(long topicId, float score) {
        this.topicId = topicId;
        this.score = score;
    }
}