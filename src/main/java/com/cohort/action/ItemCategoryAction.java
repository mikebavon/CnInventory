package com.cohort.action;

import com.cohort.model.ItemCategory;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ItemCategoryAction extends HttpServlet {

    public void init(){
        System.out.println("Item Action Servlet is Loaded & Instatiated");
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        List<ItemCategory> categories = new ArrayList<ItemCategory>();
        categories.add(new ItemCategory("Food"));
        categories.add(new ItemCategory("Furniture"));
        categories.add(new ItemCategory("Utensils"));

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

        display.print("Item Categories<br/>");
        display.print("<table>");
        display.print("<th>Name</th>");

        for (ItemCategory category : categories){
            display.print("<tr>");
            display.print("<td>" + category.getName() + "</td>");
            display.print("</tr>");
        }

        display.print("</table>");
        display.print("</body>");
        display.print("</html>");
    }

}
