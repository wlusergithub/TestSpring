package com.unjlams.SpringAop;

/**
 * Created by UnjlAms on 2017/9/21.
 */
public class firstAopImpl implements AopTest{

    @Override
    public void first() {
//        int i= 10/0;
        System.out.println("我是第一次");
    }

    @Override
    public void second() {
        System.out.println("我是第二次");

    }

    @Override
    public void third() {
        System.out.println("我是第三次");
    }

    @Override
    public void fourth() {
        System.out.println("我是第四次");
    }

}
