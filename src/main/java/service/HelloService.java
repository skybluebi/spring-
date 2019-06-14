package service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HelloService {
    private Map<String,Object> map=new HashMap();
    public String method1(int x){
        if (x==0){
            throw new RuntimeException("x不能为0");

        }
        return "hello";
    }
    public void addUser(String username,String password){
        map.put(username,password );
    }
}
