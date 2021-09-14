package com.cohort.bean;

import com.cohort.model.Login;

public interface LoginBeanI {

    boolean checkUser(Login login) throws Exception;
}
