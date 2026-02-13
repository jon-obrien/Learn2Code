package com.learn2code.app;

public class Module {
    private long id;
    private String name;
    private String desc;

    public Module(long id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getDesc() { return desc; }
}