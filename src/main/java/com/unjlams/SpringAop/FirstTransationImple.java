package com.unjlams.SpringAop;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by UnjlAms on 2017/9/24.
 */
public class FirstTransationImple implements FirstTransation {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //    减钱
    @Override
    public void increaseMoney(double money, Integer id) {
        String sql = "update t_price set money=money+? where id =?";
        jdbcTemplate.update(sql,money,id);
    }

//    加钱
    @Override
    public void decreaseMoney(double money, Integer id) {
        String sql = "update t_price set money=money-? where id =?";
        jdbcTemplate.update(sql,money,id);
    }
}
