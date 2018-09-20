package com.galactic_Ninja.spring.basics.springbootwebapplication.controllers;

import com.galactic_Ninja.spring.basics.springbootwebapplication.service.LoginService;
import com.galactic_Ninja.spring.basics.springbootwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showLoginpage(ModelMap modelMap){
        modelMap.put("todos",service.retrieveTodos("David Lutta"));
        return "list-todos";
    }
}
