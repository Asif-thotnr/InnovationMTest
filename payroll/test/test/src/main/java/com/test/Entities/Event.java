package com.test.Entities;

public class Event {
    private long id;

    private String seqId;

    private long empId;

    private long eventType;

    private String value;

    private String eventDate;

    private String notes;

    public String getEventDate() {
        return this.eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate.trim();

    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getEventType() {
        return this.eventType;
    }

    public void setEventType(long eventType) {
        this.eventType = eventType;
    }

    public long getEmpId() {
        return this.empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSeqId() {
        return this.seqId;
    }

    public void setSeqId(String seqId) {
        this.seqId = seqId;
    }

}
