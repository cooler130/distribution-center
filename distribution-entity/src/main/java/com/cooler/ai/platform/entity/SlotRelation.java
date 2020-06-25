package com.cooler.ai.platform.entity;

public class SlotRelation {
    private Integer id;

    private Integer nluSlotId;

    private Integer slotId;

    private Integer enable;

    private String msg;

    public SlotRelation(Integer id, Integer nluSlotId, Integer slotId, Integer enable, String msg) {
        this.id = id;
        this.nluSlotId = nluSlotId;
        this.slotId = slotId;
        this.enable = enable;
        this.msg = msg;
    }

    public SlotRelation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNluSlotId() {
        return nluSlotId;
    }

    public void setNluSlotId(Integer nluSlotId) {
        this.nluSlotId = nluSlotId;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
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