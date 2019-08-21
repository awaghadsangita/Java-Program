package com.bridgelab.jdbc.loginRegistration.repository;

import java.sql.SQLException;

import com.bridgelab.jdbc.loginRegistration.controller.User;

public interface UserRepository {
	public boolean addUser(User user) throws SQLException;
	public void editUserDetails(User user);
	public void deleteUser(String emailid);
	public User getUserDetails(String emailid,String pwd) throws SQLException;
	public boolean isValidUserNameAndPassword(String email,String pwd) throws SQLException, ClassNotFoundException;
}
