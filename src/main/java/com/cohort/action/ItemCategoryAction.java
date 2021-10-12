package com.cohort.action;

import com.cohort.model.ItemCategory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
    name="ItemCategory",
    urlPatterns = "/itemcategory",
    initParams = {
        @WebInitParam(name = "Page Name", value = "Item Catalog")
    }
)
public class ItemCategoryAction extends BaseServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<ItemCategory> itemsCategories = new ArrayList<ItemCategory>();
        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        try {
            PreparedStatement statement = conn.prepareStatement("select * from item_categories");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                itemsCategories.add(new ItemCategory((String)  resultSet.getString("name")));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        resultWrapper.setList(itemsCategories);

        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("application/json");

        ItemCategory itemCategory = new ItemCategory();
        try {
            BeanUtils.populate(itemCategory, req.getParameterMap());

        }catch (Exception ex){
            resultWrapper.setMessage(ex.getMessage());
            itemCategory = null;
        }

        if (itemCategory == null){
            res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
            return;
        }

        Connection conn = (Connection) req.getServletContext().getAttribute("mysqlConn");

        if (conn != null) {
            try {
                PreparedStatement statement = conn.prepareStatement("insert into item_categories(name) values (?)");
                statement.setString(1, itemCategory.getName());
                statement.executeUpdate();

            } catch (SQLException ex) {
                resultWrapper.setSuccess(false);
                resultWrapper.setMessage(ex.getMessage());
            }

        } else {
            resultWrapper.setSuccess(false);
            resultWrapper.setMessage("No connection");

        }
        res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
    }

}
