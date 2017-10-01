package com.unjlams.SpringObject;

import org.springframework.context.annotation.Scope;

/**
 * Created by UnjlAms on 2017/9/19.
 */


public class SpringUser {

    private String name;
    private int age;
    private SpringCar car;

    public SpringUser(SpringCar car , String name) {
        System.out.println("构造函数注入");
        this.name = name;
        this.car = car;
    }

    public SpringUser(Integer name, SpringCar car) {
        System.out.println("integer 构造函数注入");
        this.name = name+"";
        this.car = car;
    }



    public SpringCar getCar() {
        return car;
    }

    public void setCar(SpringCar car) {
        this.car = car;
    }

    public SpringUser() {
        System.out.println("空参构造");
    }

    public void init(){

        System.out.println("初始化方法");
    }

    public void destory(){

        System.out.println("销毁方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "SpringUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }
}
