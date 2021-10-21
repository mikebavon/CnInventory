package com.cohort.bean;

import com.cohort.cdi.LoginUser;
import com.cohort.model.Login;
import com.cohort.model.LoginResponse;
import com.cohort.model.UserType;

import java.util.Random;

@LoginUser(type = UserType.USER)
public class LoginNormalUserBean implements LoginUserBeanI {

    private static final String USERNAME = "john.doe@email.com";
    private static final String PASSWORD = "JOHN123*";

    public LoginResponse checkUser(Login login) throws Exception {
        System.out.println("CHECKING NORMAL USER..............");

        if (login == null || login.getUserType() != UserType.USER || login.getUsername() == null || login.getPassword() == null)
            return new LoginResponse();

        LoginResponse loginResponse = new LoginResponse(!(login.getUsername().equalsIgnoreCase(USERNAME)
                && login.getPassword().equals(PASSWORD)));

        if (!loginResponse.isLoginError()) {
            loginResponse.setSessionId(new Random().nextInt() + "");
            loginResponse.setEmail(login.getUsername());
            loginResponse.setUser("JOHN DOE");
            loginResponse.setRedirectPage("./home.jsp");
        }

        return loginResponse;
    }

}
