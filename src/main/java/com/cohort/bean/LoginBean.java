package com.cohort.bean;

public class LoginBean implements  LoginBeanI{

    private static final String USERNAME = "john.doe@email.com";
    private static final String PASSWORD = "JOHN123*";

    public boolean checkUser(String username, String password) throws Exception {
        if (username == null || password == null)
            return false;

        return (username.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD));

    }

}
