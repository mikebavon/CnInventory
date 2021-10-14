package com.cohort.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoI extends Serializable {

    void save(String sql, List<Object> params) throws Exception;

}
