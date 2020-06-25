package com.cooler.ai.platform.entity;

public class Task {
    private Integer id;

    private String taskName;

    private String domainName;

    public Task(Integer id, String taskName, String domainName) {
        this.id = id;
        this.taskName = taskName;
        this.domainName = domainName;
    }

    public Task() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }
}