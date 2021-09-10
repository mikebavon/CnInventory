package com.cohort.util;

import com.cohort.model.Item;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AppBootstrapListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Milk", new BigDecimal(100),new BigDecimal(120)));
        items.add(new Item("Sugar", new BigDecimal(130),new BigDecimal(150)));
        items.add(new Item("Bread", new BigDecimal(100),new BigDecimal(160)));

        ServletContext sc = sce.getServletContext();
        sc.setAttribute("defaultItems", items);

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

}
