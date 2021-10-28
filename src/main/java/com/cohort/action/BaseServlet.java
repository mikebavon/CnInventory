package com.cohort.action;

import com.cohort.model.ResultWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class BaseServlet extends HttpServlet {

    private ObjectMapper jsonMapper = new ObjectMapper();

    @SuppressWarnings("rawtypes")
    private ResultWrapper resultWrapper = new ResultWrapper<Object>();

    public void transform(Object bean, Map<String, String[]> params){
        try {
            BeanUtils.populate(bean, params);

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void handleResponse(HttpServletResponse res) throws IOException {
        res.setContentType("application/json");
        res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
    }

    @SuppressWarnings("unchecked")
    public void handleResponse(HttpServletResponse res, Object obj) throws IOException {
        res.setContentType("application/json");
        if (obj instanceof Collection<?>){
            resultWrapper.setList((List<?>) obj);
            res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
        }else
            res.getWriter().print(jsonMapper.writeValueAsString(obj));
    }

    public void exceptionResponse(HttpServletResponse res, boolean success, String message) throws IOException {
        res.setContentType("application/json");
        resultWrapper.setSuccess(success);
        resultWrapper.setMessage(message);
        res.getWriter().print(jsonMapper.writeValueAsString(resultWrapper));
    }

}
