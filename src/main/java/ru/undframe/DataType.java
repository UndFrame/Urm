package ru.undframe;

public class DataType {

    public static DataType INTEGER = new DataType("int");


    private String name;

    public DataType(String name) {
        this.name = name;
    }

    public String getTypeName(){
        return name;
    }
}
