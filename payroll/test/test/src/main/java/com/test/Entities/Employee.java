package com.test.Entities;

public class Employee {
    private long id = -1;

    private String empId = "";

    private String empFName = "";

    private String empLName = "";

    private long designationId = -1;

    private String designation = "";

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmpId() {
        return this.empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId.trim();
    }

    public String getEmpFName() {
        return this.empFName;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName.trim();
    }

    public String getEmpLName() {
        return this.empLName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName.trim();
    }

    public long getDesignationId() {
        return this.designationId;
    }

    public void setDesignationId(long designationId) {
        this.designationId = designationId;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation.trim();
    }

    @Override
    public String toString() {
        return "id = " + this.getId() + " --  empId = " + this.getEmpId() + " -- empFName " + this.getEmpFName()
                + " -- empLName" + this.getEmpLName() + " -- designationId " + this.getDesignationId()
                + " -- designation " + this.getDesignation();
    }
}
