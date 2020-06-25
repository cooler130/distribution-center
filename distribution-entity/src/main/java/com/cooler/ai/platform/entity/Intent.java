package com.cooler.ai.platform.entity;

public class Intent {
    private Integer id;

    private String intentName;

    private Integer domainId;

    private String domainName;

    private String taskNames;

    private Integer intentType;

    private String msg;

    public Intent(Integer id, String intentName, Integer domainId, String domainName, String taskNames, Integer intentType, String msg) {
        this.id = id;
        this.intentName = intentName;
        this.domainId = domainId;
        this.domainName = domainName;
        this.taskNames = taskNames;
        this.intentType = intentType;
        this.msg = msg;
    }

    public Intent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntentName() {
        return intentName;
    }

    public void setIntentName(String intentName) {
        this.intentName = intentName == null ? null : intentName.trim();
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName == null ? null : domainName.trim();
    }

    public String getTaskNames() {
        return taskNames;
    }

    public void setTaskNames(String taskNames) {
        this.taskNames = taskNames == null ? null : taskNames.trim();
    }

    public Integer getIntentType() {
        return intentType;
    }

    public void setIntentType(Integer intentType) {
        this.intentType = intentType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}