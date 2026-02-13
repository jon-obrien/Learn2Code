package com.learn2code.app;

public class Topic {
    private long id;
    private String name;
    private String desc;
    private long moduleId;

    public Topic(long id, String name, String desc, long moduleId) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.moduleId = moduleId;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getDesc() { return desc; }
    public long getModuleId() { return moduleId; }
}