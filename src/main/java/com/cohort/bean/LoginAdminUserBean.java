package com.cohort.bean;

import com.cohort.cdi.LoginUser;
import com.cohort.model.Login;
import com.cohort.model.UserType;

import java.util.logging.Logger;


@LoginUser(type = UserType.ADMIN)
public class LoginAdminUserBean implements LoginUserBeanI {

    Logger log = Logger.getLogger(getClass().getName());

    private static final String USERNAME = "jane.doe@email.com";
    private static final String PASSWORD = "JANE123*";

    public boolean checkUser(Login login) throws Exception {
        System.out.println("CHECKING ADMIN USER..............");
        System.out.println("CHECKING CARD......");
        System.out.println("CHECKING FINGER PRINT ......");

        System.out.println("C");

        if (login == null || login.getUsername() == null || login.getPassword() == null)
            return false;

        return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));

    }

}
