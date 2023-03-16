package com.BullsCows.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class BullsCowsDaoSqlImpl implements BullsCowsDao{

    //for sql part

    @Autowired
    private JdbcTemplate jdbc;



}
