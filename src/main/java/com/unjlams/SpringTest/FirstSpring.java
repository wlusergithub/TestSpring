package com.unjlams.SpringTest;

import com.unjlams.SpringObject.SetSpring;
import com.unjlams.SpringObject.SpringUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by UnjlAms on 2017/9/19.
 */
public class FirstSpring {

    @Test
    public void firstTest(){
//        1. 创建容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//      向容器获取对象
        SpringUser su = (SpringUser) ac.getBean("firstSpringUser");
        System.out.println(su+ " " +su.getName());


//        2. 静态工厂创建容器对象
        ApplicationContext acs = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SpringUser firstSpringStaticfac = (SpringUser) acs.getBean("firstSpringStaticfac");
        System.out.println(firstSpringStaticfac);


//        3. 实例工厂创建容器对象
        ApplicationContext acsl = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SpringUser firstSpringStaticfacShili = (SpringUser) acs.getBean("firstSpringshilifac");
        System.out.println(firstSpringStaticfacShili);
    }


    @Test
    public void secondTest(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SpringUser su = (SpringUser) ac.getBean("firstSpringUser");
        System.out.println(su);
        ac.close();
    }


    /**
     *  依赖注入
     */
    @Test
    public void threeTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");

//        1.  set 方式注入
//        SpringUser firstSpringUser = (SpringUser) ac.getBean("firstSpringUser");
//        System.out.println(firstSpringUser);


//        2. 构造函数注入
//        SpringUser secondSpringUser = (SpringUser) ac.getBean("secondSpringUser");
//        System.out.println(secondSpringUser);


//        3. P名称空间注入
//        SpringUser threeSpringUser = (SpringUser) ac.getBean("threeSpringUser");
//        System.out.println(threeSpringUser);

//        4. spel注入
//        SpringUser fourSpringUser = (SpringUser) ac.getBean("fourSpringUser");
//        System.out.println(fourSpringUser);
    }

    /**
     *  复杂类型注入
     */
    @Test
    public void fourTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        SetSpring fivesetSpring = (SetSpring) ac.getBean("fivesetSpring");
        System.out.println(fivesetSpring);
    }








}
