package com.cooler.ai.platform.entity;

public class NLUSlot {
    private Integer id;

    private String nluSlotName;

    private String nluDomainName;

    private Integer nluSlotType;

    private Integer enable;

    private String msg;

    public NLUSlot(Integer id, String nluSlotName, String nluDomainName, Integer nluSlotType, Integer enable, String msg) {
        this.id = id;
        this.nluSlotName = nluSlotName;
        this.nluDomainName = nluDomainName;
        this.nluSlotType = nluSlotType;
        this.enable = enable;
        this.msg = msg;
    }

    public NLUSlot() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNluSlotName() {
        return nluSlotName;
    }

    public void setNluSlotName(String nluSlotName) {
        this.nluSlotName = nluSlotName == null ? null : nluSlotName.trim();
    }

    public String getNluDomainName() {
        return nluDomainName;
    }

    public void setNluDomainName(String nluDomainName) {
        this.nluDomainName = nluDomainName == null ? null : nluDomainName.trim();
    }

    public Integer getNluSlotType() {
        return nluSlotType;
    }

    public void setNluSlotType(Integer nluSlotType) {
        this.nluSlotType = nluSlotType;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}