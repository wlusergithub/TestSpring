package com.unjlams.mybatisTest;

import com.unjlams.mybatis.inter.Username2Mapper;
import com.unjlams.mybatis.inter.UsernameMapper;
import com.unjlams.mybatis.table.Username;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by UnjlAms on 2017/9/8.
 */
public class FirstMybatis {

//  获取SqlSessionFactroy对象
    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {

//        获取文件的路径
        String resource = "mybatis-config.xml";
//        获取Mybatis全局配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
//      使用SqlSessionFactory，获取sqlSession对象使用此对象来进行相关的操作
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//       SqlSessionFactory创建sqlSession对象
        SqlSession opensession = sqlSessionFactory.openSession();
        try {

//            创建Username 对象 来进行增删改查
            Username us = opensession.selectOne("com.unjlams.mybatis.inter.UsernameMapper.selectuser",1);
            System.out.println(us);
        }finally {
//            关闭sqlSession
            opensession.close();
        }
    }


    /**
     * 注意:
     *   1.   sqlSession代表和数据库的一次会话，用完必须关闭
     *   2.   sqlSession 和 connection 一样都是非线程安全，每次使用都应该去取新的对象
     *   3.   UsernameMapper接口没有实现类，但是mybatis会为这个接口生成一个代理对象
     *      （将接口与xml进行绑定）
     *   4.   两个重要的配置文件：
     *        mybatis-config.xml： mybatis的全局配置文件：包含数据库连接池，事务管理器等
     *        UserMapper：sql映射文件， 保存了每一个sql语句的映射信息
     */
    @Test
    public void test1() throws IOException {
//        获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        获取SqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
//
        try {
//            获取接口代理对象，需要配置文件
            UsernameMapper usm = openSession.getMapper(UsernameMapper.class);
//            获取原对象
            Username username = usm.getUserById(1);
            System.out.println(username);
        }finally {
            openSession.close();
        }
    }


    /**
     *  测试增删改查看
     *  1. mybatis 允许增删改直接定义一下类型返回值
     *      Integer 、 Long 、Boolean
     *  2. 我们需要手动提交数据
     *      sqlSessionFactory.openSession();  ==> 手动提交
     *      sqlSessionFactory.openSession(true);  ==> 自动提交
     */
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory= getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            UsernameMapper mapper = openSession.getMapper(UsernameMapper.class);

//            Map<String,Object> map = new HashMap<String, Object>();
//            map.put("id",1);
//            map.put("name","unjlams");
//            Username use  = mapper.getMap(map);


//            查询
//            Username username = mapper.getUserById(1);
//            System.out.println(username);

            List<Username> users = mapper.getManyUsernmae("%s%");
            for (Username u : users){
                System.out.println(u);
            }


//            添加
//            Username username =  new Username(null,"unjlams","男",22);
//            mapper.addUsername(username);
//            System.out.println(username.getId());

//            修改
//            Username username =  new Username(1,"unjlams","男",22);
//            mapper.updateUsername(username);

//            删除
//            boolean b = mapper.deleteUsername(5);
//            System.out.println(b);

//            手动提交事物
            openSession.commit();
        }finally {
            openSession.close();
        }
    }


    /**
     *
     *
     * resultMap
     *
     * 一对一   一对多的测试
     */
    @Test
    public void testResultMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        try{
            Username2Mapper username = sqlSession.getMapper(Username2Mapper.class);
            Username u  = username.selectUsername(1);
//            Department u= username.selectDepartment(1);
            System.out.println(u.getName());
            System.out.println(u.getDept());

//            List<Username> u = username.leftAssociat();
//            for(Username us : u){
//                System.out.println(us);
//            }

//            List<Department> us = username.rightAssociat();
//            for (Department u :us){
//                System.out.println(u);
//            }

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

    }


    /**
     *  动态sql语句
     */
    @Test
    public void TestDyanmicSQL() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Username2Mapper username = sqlSession.getMapper(Username2Mapper.class);

//            Username u = new Username(null,null,null,22,1);
//            List<Username> us = username.testIf(u);
//            for(Username ua : us){
//                System.out.println(ua);
//            }


//            List<Integer> lis =new ArrayList<Integer>();
//            lis.add(1);
//            lis.add(6);
//            lis.add(2);
//            List<Username> list = username.testForeach(lis);
//            for(Username u : list){
//                System.out.println(u);
//            }

            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }



    /**
     *  缓存机制
     */
    @Test
    public void testCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        try{
            Username2Mapper username = sqlSession.getMapper(Username2Mapper.class);
            Username2Mapper username1 = sqlSession1.getMapper(Username2Mapper.class);
            Username u = username.selectUsername(1);
            System.out.println(u);

            sqlSession.close();
//            sqlSession.clearCache();

            Username u1 = username1.selectUsername(1);
            System.out.println(u1);
             sqlSession1.close();

        }finally {
        }
    }

    /**
     *  插件
     */
    public void testPlugins(){

    }


}
