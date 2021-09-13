package com.cohort.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

public class DbUtil {

    private static DataSource ds;

    private MysqlDataSource mysqlDs =  new MysqlDataSource();

    private DbUtil(){
        mysqlDs.setUrl("jdbc:mysql://localhost:3306/inventory");
        mysqlDs.setUser("root");
        mysqlDs.setPassword("Okello3477#*");

    }

    public static DataSource getInstance(){
        if (ds == null)
            ds = new DbUtil().getMysqlDs();

        return ds;
    }

    public MysqlDataSource getMysqlDs() {
        return mysqlDs;
    }

    public void setMysqlDs(MysqlDataSource mysqlDs) {
        this.mysqlDs = mysqlDs;
    }
}
