package com.cohort.util;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DbUtil {

    private static DbUtil ds;

    private MysqlDataSource mysqlDs =  new MysqlDataSource();

    private DbUtil(){
        mysqlDs.setUrl("jdbc:mysql://localhost:3306/inventory");
        mysqlDs.setUser("root");
        mysqlDs.setPassword("Okello3477#*");

    }

    public static DbUtil getInstance(){
        if (ds == null)
            ds = new DbUtil();

        return ds;
    }

    public MysqlDataSource getMysqlDs() {
        return mysqlDs;
    }

    public void setMysqlDs(MysqlDataSource mysqlDs) {
        this.mysqlDs = mysqlDs;
    }
}
