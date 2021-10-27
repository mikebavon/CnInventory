package com.cohort.action;

import com.cohort.ejb.LoginEjbI;
import com.cohort.model.LoginResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.EJB;
import javax.servlet.ServletException;
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

    @EJB
    private LoginEjbI loginEjb;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession(true);
        LoginResponse loginResponse = loginEjb.validate(req.getParameterMap());
        session.setAttribute("loginUserData", loginResponse);

        handleResponse(res, loginResponse);

    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession();
        List<LoginResponse> loginResponse = new ArrayList<LoginResponse>();

        if (session.getAttribute("loginUserData") != null)
            loginResponse.add((LoginResponse) session.getAttribute("loginUserData"));

        handleResponse(res, loginResponse);

    }

}
