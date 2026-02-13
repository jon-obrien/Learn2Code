package com.learn2code.app;

public class Info {
    private long topicId;
    private String sampleCode;

    public Info(long topicId, String sampleCode) {
        this.topicId = topicId;
        this.sampleCode = sampleCode;
    }

    public long getTopicId() { return topicId; }
    public String getSampleCode() { return sampleCode; }
}