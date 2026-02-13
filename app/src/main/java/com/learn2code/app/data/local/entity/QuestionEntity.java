package com.learn2code.app.data.local.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(
    tableName = "questions",
    foreignKeys = @ForeignKey(
        entity = TopicEntity.class,
        parentColumns = "id",
        childColumns = "topicId",
        onDelete = ForeignKey.CASCADE
    ),
    indices = {@Index("topicId")}
)
public class QuestionEntity {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public long topicId;
    public String lang;
    public String questionText;
    public String questionCode;
    public String correctAnswer;
    public String wrongAnswer1;
    public String wrongAnswer2;
    public String wrongAnswer3;

    public QuestionEntity() {}
}