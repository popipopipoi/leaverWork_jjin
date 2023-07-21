package com.ohgiraffers.section01;

public class AlcoholDTO {

    private static int nextId = 1;

    private int id;
    private String Manufacturer;
    private String name;

    public AlcoholDTO(String Manufacturer, String name) {
        this.id = AlcoholDTO.nextId++;
        this.Manufacturer = Manufacturer;
        this.name = name;
    }

    public AlcoholDTO(int id, String Manufacturer, String name) {
        this.id = id;
        this.Manufacturer = Manufacturer;
        this.name = name;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        AlcoholDTO.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlcoholDTO{" +
                "id=" + id +
                ", Manufacturer='" + Manufacturer + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
