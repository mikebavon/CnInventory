package com.cohort.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {

    private static DbUtil ds;

    //private BasicDataSource mysqlDs =  new BasicDataSource();
    private ComboPooledDataSource mysqlDs =  new ComboPooledDataSource();

    private DbUtil(){
        mysqlDs.setJdbcUrl("jdbc:mysql://localhost:3306/inventory");
        mysqlDs.setUser("root");
        mysqlDs.setPassword("Okello3477#*");
        mysqlDs.setInitialPoolSize(10);
    }

    public static DbUtil getInstance(){
        if (ds == null)
            ds = new DbUtil();

        return ds;
    }

    public ComboPooledDataSource getMysqlDs() {
        return mysqlDs;
    }

    public void setMysqlDs(ComboPooledDataSource mysqlDs) {
        this.mysqlDs = mysqlDs;
    }
}
