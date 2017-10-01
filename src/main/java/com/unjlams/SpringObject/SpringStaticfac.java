package com.unjlams.SpringObject;

/**
 * Created by UnjlAms on 2017/9/19.
 */
public class SpringStaticfac {

//    创建静态工厂
    public static SpringUser createFac(){
        System.out.println("静态工厂创建");
        return new SpringUser();
    }

//   创建实例工厂
    public SpringUser createShiLiFac(){
        System.out.println("实例工厂创建");
        return new SpringUser();
    }


}
