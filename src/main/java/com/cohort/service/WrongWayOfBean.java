package com.cohort.service;

import com.cohort.model.Login;
import com.cohort.model.UserType;

public class WrongWayOfBean {

    private static final String USERNAME = "john.doe@email.com";
    private static final String PASSWORD = "JOHN123*";

    public boolean checkUser(Login login) throws Exception {
        if (login ==  null)
            return false;


        if (login.getUserType() == UserType.USER) {
            System.out.println("CHECKING NORMAL USER..............");
            System.out.println("CHECKS USERNAME AND PASSWORD......");

            if (login.getUsername() == null || login.getPassword() == null)
                return false;

            System.out.println(login.getOtp());

            return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));

        } else if (login.getUserType() == UserType.ADMIN) {
            System.out.println("CHECKING ADMIN USER..............");
            System.out.println("CHECKING CARD......");

            if (login.getUsername() == null || login.getPassword() == null)
                return false;

            System.out.println(login.getOtp());

            return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));


        } else if (login.getUserType() == UserType.SUPER_ADMIN) {
            System.out.println("CHECKING NORMAL USER..............");
            System.out.println("CHECKING FINGER PRINT AND ALIVE......");

            if (login.getUsername() == null || login.getPassword() == null)
                return false;

            System.out.println(login.getOtp());

            return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));


        } else if (login.getUserType() == UserType.SUPER_SUPER_ADMIN) {
            System.out.println("CHECKING NORMAL USER..............");
            System.out.println("CHECKING EYE AND ALIVE ......");

            if (login.getUsername() == null || login.getPassword() == null)
                return false;

            System.out.println(login.getOtp());

            return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));

        }

        return false;

    }

}
