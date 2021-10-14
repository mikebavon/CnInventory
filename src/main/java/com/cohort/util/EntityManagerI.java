package com.cohort.util;

import java.io.Serializable;
import java.sql.Connection;

public interface EntityManagerI extends Serializable {

    Connection getConnection() throws Exception;
}
