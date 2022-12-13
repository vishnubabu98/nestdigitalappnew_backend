package com.nest.nestdigitalappnew_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeloginentry")
public class EmployeeLoginEntry {
    @Id
    @GeneratedValue
    private int id;
    private String empcode;
    private  String entry_time;
    private String exit_time;
    private  String date;

    public EmployeeLoginEntry() {
    }

    public EmployeeLoginEntry(int id, String empcode, String entry_time, String exit_time, String date) {
        this.id = id;
        this.empcode = empcode;
        this.entry_time = entry_time;
        this.exit_time = exit_time;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpcode() {
        return empcode;
    }

    public void setEmpcode(String empcode) {
        this.empcode = empcode;
    }

    public String getEntry_time() {
        return entry_time;
    }

    public void setEntry_time(String entry_time) {
        this.entry_time = entry_time;
    }

    public String getExit_time() {
        return exit_time;
    }

    public void setExit_time(String exit_time) {
        this.exit_time = exit_time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
