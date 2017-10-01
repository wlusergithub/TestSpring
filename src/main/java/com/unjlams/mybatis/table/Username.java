package com.unjlams.mybatis.table;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * Created by UnjlAms on 2017/9/8.
 */
@Alias("Users")
public class Username implements Serializable{

    private static final long serialVersionUID=1L;
    private Integer id ;
    private String name;
    private String sex;
    private int age;
    private int deptid;
    private Department dept;


    public void setId(Integer id) {
        this.id = id;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }



    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public Username() {
        super();
    }

    public Username(Integer id, String name, String sex, int age, int deptid) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.deptid = deptid;
    }

//    @Override
//    public String toString() {
//        return "Username{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", sex='" + sex + '\'' +
//                ", age=" + age +
//                ", deptid=" + deptid +
//                ", dept=" + dept +
//                '}';
//    }


    @Override
    public String toString() {
        return "Username{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", deptid=" + deptid +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
