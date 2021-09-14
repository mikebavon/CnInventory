package com.cohort.bean;

import com.cohort.model.Login;

public class LoginBean implements  LoginBeanI{

    private static final String USERNAME = "john.doe@email.com";
    private static final String PASSWORD = "JOHN123*";

    public boolean checkUser(Login login) throws Exception {
        if (login == null || login.getUsername() == null || login.getPassword() == null)
            return false;

        System.out.println(login.getOtp());

        return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));

    }

}
