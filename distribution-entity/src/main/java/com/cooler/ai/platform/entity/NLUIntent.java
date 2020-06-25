package com.cooler.ai.platform.entity;

public class NLUIntent {
    private Integer id;

    private String nluIntentName;

    private String nluDomainName;

    private Integer nluIntentType;

    private Integer intentId;

    private Byte enable;

    private String msg;

    public NLUIntent(Integer id, String nluIntentName, String nluDomainName, Integer nluIntentType, Integer intentId, Byte enable, String msg) {
        this.id = id;
        this.nluIntentName = nluIntentName;
        this.nluDomainName = nluDomainName;
        this.nluIntentType = nluIntentType;
        this.intentId = intentId;
        this.enable = enable;
        this.msg = msg;
    }

    public NLUIntent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNluIntentName() {
        return nluIntentName;
    }

    public void setNluIntentName(String nluIntentName) {
        this.nluIntentName = nluIntentName == null ? null : nluIntentName.trim();
    }

    public String getNluDomainName() {
        return nluDomainName;
    }

    public void setNluDomainName(String nluDomainName) {
        this.nluDomainName = nluDomainName == null ? null : nluDomainName.trim();
    }

    public Integer getNluIntentType() {
        return nluIntentType;
    }

    public void setNluIntentType(Integer nluIntentType) {
        this.nluIntentType = nluIntentType;
    }

    public Integer getIntentId() {
        return intentId;
    }

    public void setIntentId(Integer intentId) {
        this.intentId = intentId;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}