package com.cooler.ai.platform.entity;

public class Slot {
    private Integer id;

    private String slotName;

    private Integer intentId;

    private Byte isNecessary;

    private Float importanceDegree;

    private Byte inheritable;

    private Byte inheritDestructible;

    private String followedSlots;

    private String defaultQuery;

    private String msg;

    public Slot(Integer id, String slotName, Integer intentId, Byte isNecessary, Float importanceDegree, Byte inheritable, Byte inheritDestructible, String followedSlots, String defaultQuery, String msg) {
        this.id = id;
        this.slotName = slotName;
        this.intentId = intentId;
        this.isNecessary = isNecessary;
        this.importanceDegree = importanceDegree;
        this.inheritable = inheritable;
        this.inheritDestructible = inheritDestructible;
        this.followedSlots = followedSlots;
        this.defaultQuery = defaultQuery;
        this.msg = msg;
    }

    public Slot() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlotName() {
        return slotName;
    }

    public void setSlotName(String slotName) {
        this.slotName = slotName == null ? null : slotName.trim();
    }

    public Integer getIntentId() {
        return intentId;
    }

    public void setIntentId(Integer intentId) {
        this.intentId = intentId;
    }

    public Byte getIsNecessary() {
        return isNecessary;
    }

    public void setIsNecessary(Byte isNecessary) {
        this.isNecessary = isNecessary;
    }

    public Float getImportanceDegree() {
        return importanceDegree;
    }

    public void setImportanceDegree(Float importanceDegree) {
        this.importanceDegree = importanceDegree;
    }

    public Byte getInheritable() {
        return inheritable;
    }

    public void setInheritable(Byte inheritable) {
        this.inheritable = inheritable;
    }

    public Byte getInheritDestructible() {
        return inheritDestructible;
    }

    public void setInheritDestructible(Byte inheritDestructible) {
        this.inheritDestructible = inheritDestructible;
    }

    public String getFollowedSlots() {
        return followedSlots;
    }

    public void setFollowedSlots(String followedSlots) {
        this.followedSlots = followedSlots == null ? null : followedSlots.trim();
    }

    public String getDefaultQuery() {
        return defaultQuery;
    }

    public void setDefaultQuery(String defaultQuery) {
        this.defaultQuery = defaultQuery == null ? null : defaultQuery.trim();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}