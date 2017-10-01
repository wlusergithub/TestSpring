package com.unjlams.SpringTest;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

@WebListener()
public class FirstListener implements  HttpSessionActivationListener ,Serializable{

    private static final long serialVersionUID = 1L;

    @Override
//    活化 : 从磁盘中读取session对象
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

    }

    @Override
//    钝化 : 从磁盘中写入session对象
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }
}
