package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpSession session, String enCode) {

        String validationCode = (String) session.getAttribute("validationCode");
        if (validationCode.equals(enCode)) {
            Admin login = adminService.login(admin);
            if (login != null) {
                session.setAttribute("admin", login);
                return "redirect:/main/main.jsp";
            }
                return "redirect:/login.jsp";
            }
                return "redirect:/login.jsp";
        }


        @RequestMapping("/over")
    public String Over(HttpSession session){
        session.setAttribute("session",null);
        return "login";
        }

        @RequestMapping("/updatepwd")
    public  String  Update(Admin admin){
            /*System.out.println("1111111111111111111111");*/

            adminService.updatepwd(admin);
            return "index";

        }
    }


