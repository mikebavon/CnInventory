package com.cohort.util;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@Odikor
public class EntityManagerDb2 implements EntityManagerI {

    @Resource(lookup = "java:jboss/datasources/CnInventory2")
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }

}
