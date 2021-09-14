package com.cohort.util;

import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {

    private static DbUtil ds;

    //private BasicDataSource mysqlDs =  new BasicDataSource();
    private BasicDataSource mysqlDs =  new BasicDataSource();

    private DbUtil(){
        mysqlDs.setUrl("jdbc:mysql://localhost:3306/inventory");
        mysqlDs.setUsername("root");
        mysqlDs.setPassword("Okello3477#*");
        mysqlDs.setInitialSize(10);
    }

    public static DbUtil getInstance(){
        if (ds == null)
            ds = new DbUtil();

        return ds;
    }

    public BasicDataSource getMysqlDs() {
        return mysqlDs;
    }

    public void setMysqlDs(BasicDataSource mysqlDs) {
        this.mysqlDs = mysqlDs;
    }
}
