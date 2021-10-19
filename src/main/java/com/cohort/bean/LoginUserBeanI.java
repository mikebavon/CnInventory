package com.cohort.bean;

import com.cohort.model.Login;

public interface LoginUserBeanI {

    boolean checkUser(Login login) throws Exception;
}
