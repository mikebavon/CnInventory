package com.cohort.action;

import com.cohort.model.Item;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemSaveAction extends HttpServlet {

    /**
     * Handles GET request, called when the page is loaded first, because the loading a page is a get request on http
     * @param req
     * @param res
     * @throws ServletException
     * @throws IOException
     */
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Item> items = new ArrayList<Item>();
        for (int x = 0; x<5; x++) {
            items.add(new Item(req.getParameter("name" + x), new BigDecimal(req.getParameter("purchasePrice" + x)),
                new BigDecimal(req.getParameter("salePrice" + x))));
        }

        req.setAttribute("Items", items);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/item/list");
        requestDispatcher.forward(req, res);


    }
}
