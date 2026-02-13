package com.learn2code.app;

public class Question {
    private long id;
    private String questionText;
    private String questionCode;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private String wrongAnswer3;
    private long topicId;
    private String language;

    public Question(long id, String questionText, String questionCode, String correctAnswer, 
                    String wrongAnswer1, String wrongAnswer2, String wrongAnswer3, long topicId, String language) {
        this.id = id;
        this.topicId = topicId;
        this.language = language;
        this.questionText = questionText;
        this.questionCode = questionCode;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }

    public long getId() { return id; }
    public String getQuestionText() { return questionText; }
    public String getQuestionCode() { return questionCode; }
    public String getCorrectAnswer() { return correctAnswer; }
    public String getWrongAnswer1() { return wrongAnswer1; }
    public String getWrongAnswer2() { return wrongAnswer2; }
    public String getWrongAnswer3() { return wrongAnswer3; }
    public long getTopicId() { return topicId; }
    public String getLanguage() { return language; }
}