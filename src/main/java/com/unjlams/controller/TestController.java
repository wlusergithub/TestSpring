package com.unjlams.controller;

import com.unjlams.Exceptions.UserAndPassException;
import com.unjlams.Pojo.Person;
import com.unjlams.Pojo.Student;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by UnjlAms on 2017/8/16.
 */
@Controller
@RequestMapping("/TestController")
public class TestController {


//    文件的下载
    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename)throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");

//        转换编码
        filename = new String(filename.getBytes("ISO-8859-1"),"UTF-8");

//        获取文件
        File file = new File(path + File.separator +  filename);

        HttpHeaders headers = new HttpHeaders();

        //下载显示的文件名，解决中文名称乱码问题
        String downloadFileName=new String(filename.getBytes("UTF-8"),"ISO-8859-1");

        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFileName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
    }

//    文件的上传并放到model中
    @RequestMapping(value="/testRegister")
    public String testRegister(HttpServletRequest request,
                           @ModelAttribute Person per,
                           Model model) throws Exception {
        System.out.println(per.getUsername());
        //如果文件不为空，写入上传路径
        if(!per.getImage().isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");
            //上传文件名
            String filename = per.getImage().getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            System.out.println(per.getImage().getOriginalFilename());
            per.getImage().transferTo(new File(path + File.separator + filename));
            //将用户添加到model
            model.addAttribute("per", per);
            return "first";
        } else {
            return "redirect:/index.jsp";
        }
    }


//  文件的上传
    @RequestMapping("/testFileUpload")
    public String testFileUpload(@RequestParam("desc") String des , @RequestParam("file") MultipartFile file ,
                                 HttpServletRequest request) throws IOException {
        System.out.println(des);
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/images/");

            System.out.println(path);

            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);

            System.out.println(filepath);

            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "first";
        } else {
            return "redirect:/index.jsp";
        }
    }


    @ResponseBody
    @RequestMapping("/testJson")
    public Map<String,String> testJson(){
        Map<String , String> map = new HashMap<String, String>();
        map.put("name","name");
        map.put("sex","sex");
        return map;
    }

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/i18n")
    public String testProperty(Locale locale){
       String str = messageSource.getMessage("i18n.name",null,locale);
        System.out.println(str);
        return "i18n";
    }


    @RequestMapping("/formatter")
    public String testFormatter(@Valid Student stu, BindingResult result,Model mod ){
        mod.addAttribute("stu",stu);

        System.out.println(stu.getName()+"  "+stu.getBirth());

        if(result.getErrorCount()>0){
            for(FieldError error:result.getFieldErrors()){
                System.out.println(error.getField()+":"+error.getDefaultMessage());
            }

            return "redirect:/index.jsp";
        }

        return "first";
    }


    @RequestMapping("/convert")
    public ModelAndView testConverts(Student stu){
        ModelAndView mod = new ModelAndView("first");
        mod.addObject("stu",stu);
        System.out.println(stu);
        return mod;
    }



//    @RequestMapping(value="/test", method= RequestMethod.GET)
//    public String testGet(@ModelAttribute("user") User user,Map<String, Object> map){
//        map.put("user", user);
//        return "first";
//    }

//    @RequestMapping(value="/test", method=RequestMethod.POST)
//    public String testPost(User user){
//        System.out.println(user);
//        return "first";
//    }

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String testException(@RequestParam("i") int i){
        System.out.println(10/i);
        return "first";
    }

//    @ExceptionHandler({ArithmeticException.class})
//    public ModelAndView handleArithmeticException(Exception ex){
//        System.out.println(ex);
//        ModelAndView mv = new ModelAndView("error");
//        mv.addObject("exception",ex);
//        return mv;
//    }


    @RequestMapping("/testResponse")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if(i==13){
            throw new UserAndPassException();
        }
        return "first";
    }

}
