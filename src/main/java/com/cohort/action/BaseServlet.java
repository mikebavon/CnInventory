package com.cohort.action;

import com.cohort.model.ResultWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {

    ObjectMapper jsonMapper = new ObjectMapper();

    ResultWrapper resultWrapper = new ResultWrapper<Object>();

}
