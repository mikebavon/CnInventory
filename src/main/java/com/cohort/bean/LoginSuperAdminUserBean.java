package com.cohort.bean;

import com.cohort.cdi.LoginUser;
import com.cohort.model.Login;
import com.cohort.model.LoginResponse;
import com.cohort.model.UserType;

import java.util.Random;

@LoginUser(type = UserType.SUPER_ADMIN)
public class LoginSuperAdminUserBean implements LoginUserBeanI {

    private static final String USERNAME = "john.smith@email.com";
    private static final String PASSWORD = "SMITH123*";

    public LoginResponse checkUser(Login login) throws Exception {
        System.out.println("CHECKING SUPER ADMIN USER..............");

        if (login == null || login.getUserType() != UserType.SUPER_ADMIN || login.getUsername() == null || login.getPassword() == null)
            return new LoginResponse();

        LoginResponse loginResponse = new LoginResponse(!(login.getUsername().equalsIgnoreCase(USERNAME)
                && login.getPassword().equals(PASSWORD)));

        if (!loginResponse.isLoginError()) {
            loginResponse.setSessionId(new Random().nextInt() + "");
            loginResponse.setEmail(login.getUsername());
            loginResponse.setUser("JOHN SMITH");
            loginResponse.setRedirectPage("./home.jsp");
        }

        System.out.println("CHECKING CARD......");

        System.out.println("CHECKING FINGER PRINT ......");

        return loginResponse;
    }

}
