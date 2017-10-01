package com.unjlams.Pojo;

/**
 * Created by UnjlAms on 2017/8/12.
 */

public class Address {
    private String city;
    private String provice;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", provice='" + provice + '\'' +
                '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvice() {
        return provice;
    }

    public void setProvice(String provice) {
        this.provice = provice;
    }
}
