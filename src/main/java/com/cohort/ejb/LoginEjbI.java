package com.cohort.ejb;

import com.cohort.model.LoginResponse;

import java.util.Map;

public interface LoginEjbI {

    LoginResponse validate(Map<String, String[]> params);
}
