package com.unjlams.mybatis.table;

import java.io.Serializable;

/**
 * Created by UnjlAms on 2017/9/12.
 */
public class Department implements Serializable{
    private int id;
    private String deptname;
    private Username username;
    private static final long serialVersionUID=1L;

    public Username getUsername() {
        return username;
    }

    public void setUsername(Username username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptname='" + deptname + '\'' +
                ", username=" + username +
                '}';
    }
}
