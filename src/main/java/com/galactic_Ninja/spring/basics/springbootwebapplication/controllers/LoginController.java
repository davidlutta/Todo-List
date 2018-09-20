package com.galactic_Ninja.spring.basics.springbootwebapplication.controllers;

import com.galactic_Ninja.spring.basics.springbootwebapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginpage(ModelMap modelMap){
//        modelMap.put("name",name);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap modelMap, @RequestParam String name, @RequestParam String password){
        boolean isValidUser = loginService.validate(name,password);

        if (!isValidUser) {
            modelMap.put("validationMessage", "Wrong Username and/or Password");
            return "login";
        }


        modelMap.put("name",name);
        modelMap.put("password",password);

        return "welcome";
    }
}
