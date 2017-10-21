package com.lanou.domain;

/**
 * Created by dllo on 17/10/18.
 */
public class Department {
    private int id;
    private String name;
    private Manager manager;

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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(int id, String name, Manager manager) {

        this.id = id;
        this.name = name;
        this.manager = manager;
    }
}
