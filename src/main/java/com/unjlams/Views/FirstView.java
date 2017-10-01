package com.unjlams.Views;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;


/**
 * Created by UnjlAms on 2017/8/14.
 */

@Component
public class FirstView implements View{

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        response.getWriter().print("hello views "+ new Date());
    }
}
