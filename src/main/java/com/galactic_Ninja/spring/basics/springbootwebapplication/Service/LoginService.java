package com.galactic_Ninja.spring.basics.springbootwebapplication.Service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

    public boolean validate(String userName, String password){
        return userName.equalsIgnoreCase("tom")
                && password.equalsIgnoreCase("cat");
    }
}
