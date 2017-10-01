package com.unjlams.SpringObject;

/**
 * Created by UnjlAms on 2017/9/20.
 */
public class SpringCar {
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "SpringCar{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
