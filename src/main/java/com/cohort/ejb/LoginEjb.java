package com.cohort.ejb;

import com.cohort.service.LoginUserBeanI;
import com.cohort.model.Login;
import com.cohort.model.LoginResponse;
import com.cohort.model.UserType;
import org.apache.commons.beanutils.BeanUtils;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.util.Map;

@Stateless
public class LoginEjb implements LoginEjbI{

    @Inject @Any
    private Instance<LoginUserBeanI> loginUserBeans;

    public LoginResponse validate(Map<String, String[]> params){
        LoginResponse response = new LoginResponse();

        if (params == null)
            return response;

        Login login = new Login();

        try {
            BeanUtils.populate(login, params);

            if (login.getUserType() == null && login.getUserTypeStr() != null)
                login.setUserType(UserType.valueOf(login.getUserTypeStr().trim().toUpperCase()));

            return loginUserBeans.select(login.getUserType().getClazz()).get().checkUser(login);

        }catch (Exception ex){
            response.setLoginError(true);
            response.setLoginErrorMsg(ex.getMessage());

        }

        return response;

    }

}
