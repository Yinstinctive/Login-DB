package com.netease.course.controller;

import java.sql.SQLException;

public interface LoginDAO {
	public boolean checkPassword(String username, String password) throws SQLException;
}
