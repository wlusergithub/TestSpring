package com.unjlams.Pojo;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by UnjlAms on 2017/8/25.
 */
public class Student {

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    @Past
    private Date birth;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }
}
