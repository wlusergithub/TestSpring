package com.unjlams.SpringObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by UnjlAms on 2017/9/20.
 */
public class SetSpring {
    private Object[] arrays; //数组类型注入
    private List list;   //list, set类型注入
    private Map map;  //map 类型注入
    private Properties properties; //properties类型注入

    public Object[] getArrays() {
        return arrays;
    }

    @Override
    public String toString() {
        return "SetSpring{" +
                "arrays=" + Arrays.toString(arrays) +
                ", list=" + list +
                ", map=" + map +
                ", properties=" + properties +
                '}';
    }

    public void setArrays(Object[] arrays) {
        this.arrays = arrays;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
