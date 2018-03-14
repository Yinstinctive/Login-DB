package com.netease.course.controller;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Login {

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws SQLException {
    	ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    	LoginDAO logindao=context.getBean("logindao",LoginDAO.class);
    	
        if (logindao.checkPassword(username, password)) {
        	((ConfigurableApplicationContext)context).close();
            return "User "+username+" login sucessfully";
        } else {
        	((ConfigurableApplicationContext)context).close();
            return "Error, username or password is not correct, please try again.";
        }
        
    }

}