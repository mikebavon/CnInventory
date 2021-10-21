package com.cohort.action;

import com.cohort.bean.LoginUserBeanI;
import com.cohort.dao.BaseDaoI;
import com.cohort.model.Login;
import com.cohort.model.LoginResponse;
import com.cohort.model.UserType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
    name="Login",
    urlPatterns = "/login"
)
public class LoginAction extends BaseServlet {

    @Inject
    private BaseDaoI baseDao;

    @Inject @Any
    private Instance<LoginUserBeanI> loginUserBeans;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession(true);
        LoginResponse loginResponse = new LoginResponse();

        try {
            Login login = new Login();
            BeanUtils.populate(login, req.getParameterMap());

            if (login.getUserTypeStr() != null){
                try {
                    login.setUserType(UserType.valueOf(login.getUserTypeStr().trim().toUpperCase()));
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }

            if (login.getUserType() != null){
                loginResponse = loginUserBeans.select(login.getUserType().getClazz()).get().checkUser(login);

            } else {
                loginResponse.setLoginError(true);
                loginResponse.setLoginErrorMsg("Invalid Login Details");

            }

        }catch (Exception ex){
            loginResponse.setLoginError(true);
            loginResponse.setLoginErrorMsg("Invalid Login Details, '" + ex.getMessage());
        }

        if (!loginResponse.isLoginError()){
            session.setAttribute("loginUserData", loginResponse);
        }

        res.setContentType("application/json");
        res.getWriter().print(new ObjectMapper().writeValueAsString(loginResponse));

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession();
        List<LoginResponse> loginResponse = new ArrayList<LoginResponse>();


        if (session.getAttribute("loginUserData") != null)
            loginResponse.add((LoginResponse) session.getAttribute("loginUserData"));

        resultWrapper.setList(loginResponse);

        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));

    }

}
