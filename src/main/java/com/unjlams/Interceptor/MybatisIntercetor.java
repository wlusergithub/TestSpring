package com.unjlams.Interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Statement;
import java.util.Properties;

/**
 * Created by UnjlAms on 2017/9/17.
 */

/**
 *  完成了插件的签名: 告诉Mybaits当前插件用来拦截那个对象的那个方法
 *
 */

@Intercepts(
        {
                @Signature(type = StatementHandler.class,method = "parameterize", args = Statement.class)
        }
)
public class MybatisIntercetor implements Interceptor {

    /**
     * intercept :　拦截
     *          拦截目标对象的目标方法的执行
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("intercept方法"+invocation.getMethod());


//        拦截到的对象,方法,参数,类
        Object target = invocation.getTarget();
        Object targetm = invocation.getMethod();
        System.out.println("当前拦截到的对象"+target);
        System.out.println("当前拦截到的方法"+targetm);

//        拿到object的元数据
        MetaObject metaObject = SystemMetaObject.forObject(target);
        Object value = metaObject.getValue("parameterHandler.parameterObject");
        System.out.println("metaObject是:"+metaObject);
        System.out.println("sql拿到的参数是"+value);

//      设置需要改变sql的参数
        metaObject.setValue("parameterHandler.parameterObject",6);
        System.out.println("设置后的新值为");

//        执行目标方法
        Object proceed = invocation.proceed();
        return proceed;
    }

    /**
     *  plugin : 包装目标对象,为目标创建代理对象
     */
    @Override
    public Object plugin(Object o) {
        System.out.println("plugins方法" + o);
//        借助Plugin 的warp方法来使用当前interceptor包装目标对象
        Object wrap = Plugin.wrap(o, this);
        return wrap;

    }

    /**
     *   setProperties: 将插件注册的property属性设置进来
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println("插件配置的信息方法"+ properties);
    }
}
