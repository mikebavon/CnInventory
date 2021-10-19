package com.cohort.dao;

import com.cohort.util.DatabaseOne;
import com.cohort.util.EntityManagerI;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.List;

public class BaseDao implements BaseDaoI {

    @Inject
    @DatabaseOne
    private EntityManagerI em;

    public void save(String sql, List<Object> params) throws Exception{

        PreparedStatement statement = em.getConnection().prepareStatement(sql);

        //setting params
        if (params != null && !params.isEmpty()) {
            int paramIndex = 1;

            for (Object param : params) {
                if (param instanceof String)
                    statement.setString(paramIndex, (String) param);
                else if (param instanceof BigDecimal)
                    statement.setBigDecimal(paramIndex, (BigDecimal) param);
                else if (param instanceof Double)
                    statement.setDouble(paramIndex, (Double) param);
                else if (param instanceof Long)
                    statement.setLong(paramIndex, (Long) param);

                paramIndex++;

            }
        }

        statement.executeUpdate();

    }
}
