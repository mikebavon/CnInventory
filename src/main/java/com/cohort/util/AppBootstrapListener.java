package com.cohort.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

public class AppBootstrapListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        try {
            Connection conn = DbUtil.getInstance().getConnection();

            this.createDbTables(conn);
            ServletContext sc = sce.getServletContext();
            sc.setAttribute("mysqlConn", conn);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();

        if (sc.getAttribute("mysqlConn") != null){
            Connection conn = (Connection) sc.getAttribute("mysqlConn");
            try {
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void createDbTables(Connection connection) throws Exception{
        String createItemTableSql = "create table if not exists items(id int auto_increment primary key,"
                + "name varchar(255), purchase_price decimal(10,5), sale_price decimal(10, 5))";

        System.out.println("Creating Item Table : " + createItemTableSql);
        PreparedStatement createItemTableStmt = connection.prepareStatement(createItemTableSql);
        createItemTableStmt.executeUpdate();
        System.out.println("Item Table Created");


        System.out.println("Creating Item Category Table : " + createItemTableSql);
        String createItemCatTableSql = "create table if not exists item_categories(id int auto_increment primary key,"
                + "name varchar(255))";
        PreparedStatement createItemCatTableStmt = connection.prepareStatement(createItemCatTableSql);
        createItemCatTableStmt.executeUpdate();
        System.out.println("Item Category Table Created");

    }

}
