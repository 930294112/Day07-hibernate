package com.lanou.domain;

/**
 * Created by dllo on 17/10/18.
 */
public class Manager {
    private int id;
    private String name;
    private Department department;

    public Manager(String name) {
        this.name = name;
    }

    public Manager(int id, String name, Department department) {

        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Manager() {

    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
