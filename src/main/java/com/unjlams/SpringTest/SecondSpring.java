package com.unjlams.SpringTest;

import com.unjlams.SpringAop.AopTest;
import com.unjlams.SpringAop.TransationServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by UnjlAms on 2017/9/21.
 */

//创建Ioc容器
@RunWith(SpringJUnit4ClassRunner.class)
//指定创建容器的Spring 配置文件
@ContextConfiguration("classpath:ApplicationContext.xml")
public class SecondSpring {

//    @Resource(name = "firstSpringUser")
//    private SpringUser user;

//    aop
    @Resource(name = "firstAopImpl")
    private AopTest aop;

    /**
     *  aop测试
     *
     *
     */
    @Test
    public void firstTest(){

        /**
         *  Aop通知方法和目标方法调用顺序:
         *
         *  非异常情况:
         *      调用了: before, around, after, afterReturning
         *         前置通知(before)-->环绕前置通知(around-前)-->目标方法-->环绕前置通知(around-后)-->异常后置通知(after)-->异常不出现后置通知(afterReturning)
         *       没有调用:   afterException
         *
         *
         *  异常情况:
         *      调用了: before , around(前半个), afterException, after
         *         前置通知(before)-->环绕前置通知(around-前)-->异常通知(afterException)-->异常后置通知(after)
         *      没有调用: afterReturning(), around(后半个)
         *
         */

        aop.first();
//        aop.second();
//        aop.third();
//        aop.fourth();

    }






    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbc;
    /**
     *  jdbc数据测试
     *      
     */
    @Test
    public void jdbcTest(){
        String sql="delete from user where id=?";
        jdbc.update(sql,8);
    }

    /**
     *  事务管理
     */
    @Resource(name = "transationServices")
    private TransationServices ts;
    @Test
    public void transationTest(){
        ts.services(1,2,100);

    }
}