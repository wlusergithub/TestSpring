package com.unjlams.controller;

import com.unjlams.Pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * Created by UnjlAms on 2017/8/8.
 */
@SessionAttributes( value = {"user"})
@Controller
@RequestMapping("/demo")
public class MyController {
    /**
     *
     * 1. 使用@RequestMapping 注解来映射请求的URL
     * 2. 返回值会通过视图解析器解析威士忌的物理视图，对于InternalResourceViewResolver 视图解析器，会做如下的解析：
     *  通过prefix + returnVal + 后缀 这样的方式得到实际的物理视图，然后做转发操作
     *  /WEB-INF/views/first.jsp
     *
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "first";
    }


    /**
     *
     * @PathVariable 可以映射URL中的占位符到目标方法的参数中
     * @param id
     * @return
     */
    @RequestMapping("/test/{id}")
    public String testPathVariable(@PathVariable("id") String id){
        System.out.println("test:"+ id );
        return "first";
    }


    /**
     * REST 风格的URL
     * 以CRUD为例：
     * 新增: /test/   post
     * 修改: /test/1  put
     * 获取: /test/1  get
     * 删除: /test/1  delete
     *
     * 如何发送PUT 请求和DELETE 请求呢？
     * 1. 需要配置HiddenHttpMethodFilter
     * 2. 需要发送POST请求
     * 3. 需要发送POST 请求是携带一个name="_method" value="post/get/delete/put" 的隐藏标签
     * @param id
     * @return
     */

//    get请求
    @RequestMapping(value = "/test/{id}" , method = RequestMethod.GET)
    public String testget(@PathVariable Integer id){
        System.out.println("get" + id);
        return "first";
    }

//    post请求
    @RequestMapping(value = "/test/" , method = RequestMethod.POST)
    public String testput(){
        System.out.println("post");
        return "first";
    }

//    put请求
    @RequestMapping(value = "/test/{id}" , method = RequestMethod.PUT)
    public String testput(@PathVariable Integer id){
        System.out.println("put"+id);
        return "first";
    }

//    DELETE请求
    @RequestMapping(value = "/test/{id}" , method=RequestMethod.DELETE)
    public String testdelete(@PathVariable Integer id){
        System.out.println("delete" + id);
        return "first";
    }

    /**
     * @RequestParam 来映射请求参数
     * value  值即为请求参数的参数名
     * required 该参数是否必须，默认为true
     * defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testParam",method = RequestMethod.GET)
    public String testParam(@RequestParam(value = "username" ) String str ,
                            @RequestParam(value = "password" , required = false , defaultValue = "0") int pass){
        System.out.println("param username  "+str +"password  "+pass);
        return "first";
    }

    /**
     * 了解：
     * 映射请求头信息
     * 用法同@RequestParam
     */
    @RequestMapping(value = "/testHeader")
    public String testHeader(@RequestHeader(value = "Accept") String s){
        System.out.println(s);
        return "first";
    }

    /**
     *  了解：
     *  @CookieValue 映射了一个Cookie值，属性同@RequestParam
     */

    @RequestMapping(value = "/testCookie")
    public String testCookie(@CookieValue(value = "JSESSIONID") String s){
        System.out.println("cookis" + s);
        return "first";
    }


    /**
     * SpringMVC 会按照请求参数名和POJO属性名自动匹配，
     * 自动为该对象填充属性值。支持级联属性。如:
     * address.city 、 address.provice
     */
//    @RequestMapping(value = "/testPojo")
//    public String testPojo(User user){
//        System.out.println(user.getAddress());
//        return "first";
//    }

    /**
     *
     *   目标方法的返回值可以是ModelAndView 类型
     *   其中可以包含视图和模型信息
     *   SpringMVC会把ModelAndView的model中的数据放入到request域对象中
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mod = new ModelAndView("first");
        mod.addObject("time",new Date());
        return mod;
    }

    /**
     * 目标方法可以添加Map类型(实际上也可以是Model 类型或Model Map 类型)的参数
     *
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String,Object> mp){
        mp.put("names", Arrays.asList("tom","jack","jetty"));
        return "first";
    }

    /**
     * @SessionAttributes 除了可以通过属性名制定需要放到绘画中的属性外(实际上使用的是Value 属性值)
     * 还以通过模型属性的对象类型制定哪些模型属性放到会话中(实际上使用的是types 属性值)
     *
     * 注意：该注解只能放在类的上面，而不能修饰放方法
     *
     */
//    @RequestMapping("/testSessionAttr")
//    public String testSessionAttr(Map<String,Object> mp){
//        User user = new User("username","123");
//        mp.put("user",user);
//        return "first";
//    }


    /**
     * 运行流程：
     * 1. 执行@ModelAttribute 注解修饰的方法：从数据库中去除对象，吧对象放入到了Map 中，建委user
     * 2. SpringMVC 从Map 中去除User 对象，并把表单的请求参数赋给User 对象的对应属性
     * 3. SpringMVC 吧上述对象传入目标方法的参数
     *
     * 注意：在@ModelAttribute修饰的方法中，放入到Map时的键需要和目标方法入参类型字符串一致
     */

    @ModelAttribute
    public void getUser(@RequestParam(value = "id" , required = false) Integer id ,
                        Map<String , Object> map){
        if(id !=null){
            User user = new User("1","admin","pass");

            System.out.println("getUser 对象 ："+user);

            map.put("us",user);
        }
    }


    /**
     * 1.有@ModelAttribute标记的方法，会在每个目标方法执行之前被SpringMVC调用
     * 2. @ModelAttribute注解也可以来修饰目标方法POJO类型的入参， 其value属性值有如下的作用：
     *   1. SpringMVC 会使用value属性值在implicitModel 中查找对应的对象， 若存在则会直接传入到目标方法的如参中
     *   2. SprintMVC 会以value 为key ，POJO类型的对象为Value ， 存入到request中。
     */

    @RequestMapping("/testModelAttri")
    public String testModelAttri(@ModelAttribute("us") User user){
        System.out.println(user);
        return "first";
    }

    /**
     * 自定义视图解析器
     * @return
     */
    @RequestMapping("/testView")
    public String testView(){
        System.out.println("hehe");
//        Ioc容器 类名小写
        return "firstView";
    }

//    请求重定向和请求转发
    @RequestMapping("/testRedirect")
    public String testRedirect(){
//        return "redirect:/index.jsp";
        return "forward:/WEB-INF/views/first.jsp";
    }



}
