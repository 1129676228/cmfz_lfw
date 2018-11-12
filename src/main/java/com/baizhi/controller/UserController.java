package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    public @ResponseBody Map<String,Object> save(User user){
        Map<String,Object> results = new HashMap<String,Object>();
        try {
            userService.register(user);
            results.put("success",true);
        } catch (Exception e) {
            e.printStackTrace();
            results.put("success",false);
            results.put("message",e.getMessage());
        }
        return results;
    }


  @RequestMapping("/login")
  public @ResponseBody String login(User user) {
          String login = userService.login(user);
          return login;
      }



@RequestMapping("/update")
    public @ResponseBody void update(User user){
        userService.updateUser(user);
}

}
