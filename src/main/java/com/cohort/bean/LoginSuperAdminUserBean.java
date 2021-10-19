package com.cohort.bean;

import com.cohort.cdi.LoginUser;
import com.cohort.model.Login;
import com.cohort.model.UserType;

@LoginUser(type = UserType.SUPER_ADMIN)
public class LoginSuperAdminUserBean implements LoginUserBeanI {

    private static final String USERNAME = "john.smith@email.com";
    private static final String PASSWORD = "SMITH123*";

    public boolean checkUser(Login login) throws Exception {
        System.out.println("CHECKING SUPER ADMIN USER..............");

        if (login == null || login.getUsername() == null || login.getPassword() == null)
            return false;

        System.out.println(login.getOtp());

        return (login.getUsername().equalsIgnoreCase(USERNAME) && login.getPassword().equals(PASSWORD));

    }

}
