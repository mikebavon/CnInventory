package com.cohort.bean;

import com.cohort.model.Login;
import com.cohort.model.LoginResponse;

public interface LoginUserBeanI {

    LoginResponse checkUser(Login login) throws Exception;
}
