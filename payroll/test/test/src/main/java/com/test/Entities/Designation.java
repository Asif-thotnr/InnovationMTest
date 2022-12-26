package com.test.Entities;

public class Designation {

    private long id;

    private String designation;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation.trim();
    }

}
