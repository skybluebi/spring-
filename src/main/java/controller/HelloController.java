package controller;




import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.HelloService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private HelloService helloService;

    @RequestMapping("/test")
    @ResponseBody
    public ModelAndView hello(ModelAndView modelAndView, HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");
        try {
            String s = helloService.method1(6);
        } catch (Exception e) {
            modelAndView.getModel().put("ll", e.getMessage());
            modelAndView.setViewName("test");
            return modelAndView;
        }
        System.out.println("方法执行了" +
                "");
        modelAndView.getModel().put("hel", "lo");
        modelAndView.getModel().put("ff", "lo");
        modelAndView.getModel().put("hefsdfl", "lo");
        modelAndView.getModel().put("sd", "lo");
        modelAndView.getModel().put("fd", "lo");
        modelAndView.setViewName("hello");
        return modelAndView;
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response, User user, @RequestParam(value = "name", required = false, defaultValue = "haha") String name) {
        response.addHeader("woshitou", "jfafhjfhsdhfshjdjajhf");
//        try {
//            response.getWriter().write("fjshfsh");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Cookie cookie = new Cookie("hafh`", "fajdfjaj");
        response.addCookie(cookie);
        System.out.println(request.getSession().getAttribute("sess·"));
        request.getSession().setAttribute("sess·", "fjsdafjajdfjasdhfhafhsahdfh");
        System.out.println(name);
        System.out.println(user);
        System.out.println(request.getSession().getId());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("login".equals(username) && "123".equals(password))
            return "hello";
        return "login";
    }
    @RequestMapping("/res")
    public String res(){
        return "regiest";
    }

    @RequestMapping("/regist")
    public void regist(HttpServletRequest request,ModelAndView me,HttpServletResponse response,
                         @RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "password",required = false) String password,
                         @RequestParam(value = "code",required = false) String code) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        System.out.println("username"+username+password);
        Map<String,Object> map=new HashMap<>();
        System.out.println(request.getSession().getAttribute("code"));
        System.out.println(code);
        Object code1 = request.getSession().getAttribute("code");
        if (code!=null&&code.equalsIgnoreCase( code1.toString())){
            map.put("success",true );
            if (username!=null&&!username.trim().equals("")&&password!=null&&!password.trim().equals("")){
                helloService.addUser(username,password );
            }
            me.getModel().put("success",true );
            response.getOutputStream().print(new String("登陆成功".getBytes("ISO8859-1"),"utf-8"));
        }else {
            System.out.println("验证码错误");
            map.put("success",false );
          me.getModel().put("success",false );
            try {
                response.getWriter().write("登陆失败");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
