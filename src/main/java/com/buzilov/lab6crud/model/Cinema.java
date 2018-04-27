package com.buzilov.lab6crud.model;

public class Cinema {
    private Integer id;
    private String name;
    private String address;
    private int screenSize;

    public Cinema() {
    }

    public Cinema(Integer id, String name, String address, int screenSize) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.screenSize = screenSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }


    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
