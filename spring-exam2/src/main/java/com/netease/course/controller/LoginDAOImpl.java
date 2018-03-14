package com.netease.course.controller;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAOImpl implements LoginDAO{
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public boolean checkPassword(String username, String password) {
		try {
		Object result=jdbcTemplate.queryForObject("select userPassword from user where userName =?",new Object[] {username}, String.class);
		return ((String)result).equals(password);
		} catch (Exception e) {
			return false;
		}
	}

}
