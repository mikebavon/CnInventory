package com.cohort.action;

import com.cohort.bean.LoginBean;
import com.cohort.bean.LoginBeanI;
import com.cohort.model.Login;
import com.cohort.model.UserType;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet(
    name="Login",
    urlPatterns = "/login",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class LoginAction extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession(true);
        LoginBeanI loginBean = new LoginBean();

        try {
            Login login = new Login();
            BeanUtils.populate(login, req.getParameterMap());

            if (login.getUserTypeStr() != null){
                try {
                    login.setUserType(UserType.valueOf(login.getUserTypeStr().trim().toUpperCase()));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

            if (loginBean.checkUser(login)) {
                session.setAttribute("session-id", new Random().nextInt());
                session.setAttribute("email", login.getUsername());
                session.setAttribute("USER_NAME", "MIKE BAVON");
                res.sendRedirect("./item");

            }else {
                session.setAttribute("LOGIN_MSG", "Invalid Login Details");
                res.sendRedirect("./index.jsp");
            }

        }catch (Exception ex){
            session.setAttribute("LOGIN_MSG", "Invalid Login Details");
            res.sendRedirect("./index.jsp");
        }

    }
}
