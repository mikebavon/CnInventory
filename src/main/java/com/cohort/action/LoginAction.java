package com.cohort.action;

import com.cohort.bean.LoginBean;
import com.cohort.bean.LoginBeanI;
import com.cohort.model.Login;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(
    name="Login",
    urlPatterns = "/login",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class LoginAction extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        PrintWriter display = res.getWriter();
        display.print("<html>");
        display.print("<head>"
                + "<style>"
                + "table, th, td {"
                + "  border: 1px solid black;"
                + "  width: 100%;"
                + "  border-collapse: collapse;"
                + "  background-color: #96D4D4;"
                + "}"
                + "</style>"
                + "</head>");
        display.print("<body>");
        display.print("<h1>" + req.getServletContext().getInitParameter("Application Name") + "</h1></br>");
        display.print("Version " + req.getServletContext().getInitParameter("Application Version") + "</br>");
        display.print("&nbsp");
        display.print("</br>");
        display.print("</br>");
        display.print(getServletConfig().getInitParameter("Page Name") + "</br>");
        display.print("<h3>Login</h3><form action=\"./login\" method=\"POST\">\n");

        display.print("<hr/>");
        String sessionMsg = (String) req.getSession().getAttribute("LOGIN_MSG");
        if (sessionMsg != null)
            display.print("ERROR: " + sessionMsg + "<BR/>");

        display.print("  <label for=\"fname\">Username:</label><br>\n"
            + "  <input type=\"text\" id=\"username\" name=\"username\"><br>\n"
            + "  <label for=\"lname\">Password:</label><br>\n"
            + "  <input type=\"password\" id=\"password\" name=\"password\"><br><br>\n");


        display.print("<input type=\"submit\" value=\"Login\"></form></body></html>");

        req.getSession().invalidate();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        HttpSession session = req.getSession(true);
        LoginBeanI loginBean = new LoginBean();

        try {
            Login login = new Login();
            BeanUtils.populate(login, req.getParameterMap());

            if (loginBean.checkUser(login)) {
                session.setAttribute("session-id", new Random().nextInt());
                session.setAttribute("email", login.getUsername());
                session.setAttribute("USER_NAME", "MIKE BAVON");
                res.sendRedirect("./item");

            }else {
                session.setAttribute("LOGIN_MSG", "Invalid Login Details");
                res.sendRedirect("./login");
            }

        }catch (Exception ex){
            session.setAttribute("LOGIN_MSG", "Invalid Login Details");
            res.sendRedirect("./login");
        }

    }
}
