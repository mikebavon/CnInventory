package com.cohort.bean;

import com.cohort.cdi.LoginUser;
import com.cohort.model.Login;
import com.cohort.model.LoginResponse;
import com.cohort.model.UserType;

import java.util.Random;

@LoginUser(type = UserType.ADMIN)
public class LoginAdminUserBean implements LoginUserBeanI {

    private static final String USERNAME = "jane.doe@email.com";
    private static final String PASSWORD = "JANE123*";

    public LoginResponse checkUser(Login login) throws Exception {
        System.out.println("CHECKING ADMIN USER..............");

        if (login == null || login.getUserType() != UserType.ADMIN || login.getUsername() == null || login.getPassword() == null)
            return new LoginResponse();

        LoginResponse loginResponse = new LoginResponse(!(login.getUsername().equalsIgnoreCase(USERNAME)
            && login.getPassword().equals(PASSWORD)));

        if (!loginResponse.isLoginError()) {
            loginResponse.setSessionId(new Random().nextInt() + "");
            loginResponse.setEmail(login.getUsername());
            loginResponse.setUser("JANE DOE");
            loginResponse.setRedirectPage("./home.jsp");
        }

        System.out.println("CHECKING CARD......");


        return loginResponse;
    }

}
