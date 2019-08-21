package com.bridgelab.jdbc.loginRegistration.repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelab.jdbc.loginRegistration.controller.User;
public class UserRepositoryImpl implements UserRepository {

	private Connection conn;
	public UserRepositoryImpl() throws SQLException
	{
		conn=DriverManager.getConnection("jdbc:mysql://@localhost:3306/addressbook","root","admin");
	}
	public boolean isUniqueEmailId(User user) throws SQLException
	{
		String query="SELECT firstname,lastname FROM user WHERE emailid=?";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setString(1, user.getEmailid());
		ResultSet rs=stmt.executeQuery();
		
		int count=0;
		
		while(rs.next())
			count++;
		if(count>=1)
			return false;
		else
			return true;
	}
	@Override
	public boolean addUser(User user) throws SQLException {
		
		if(isUniqueEmailId(user))
		{
		
		String query="INSERT INTO user (firstname,lastname,emailid,password,mobilenumber) Values(?,?,?,?,?)";
		PreparedStatement stmt=conn.prepareStatement(query);
		stmt.setString(1, user.getFirstname());
		stmt.setString(2, user.getLastname());
		stmt.setString(3, user.getEmailid());
		stmt.setString(4, user.getPassword());
		stmt.setString(5, user.getMobilenumber());
		
		int i=stmt.executeUpdate();
		if(i==1)
			return true;
		else
			return false;
		}
		else
		{
			return false;
		}
		
	}
	@Override
	public void editUserDetails(User user) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteUser(String emailid) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public User getUserDetails(String emailid, String pwd) throws SQLException {
	
		PreparedStatement stmt=conn.prepareStatement("SELECT * FROM user WHERE emailid = ?  AND password =  ? ");
		stmt.setString(1, emailid);
		stmt.setString(2, pwd);
		ResultSet rs=stmt.executeQuery();
		User user=new User();
		while(rs.next())
		{
		user.setUid(rs.getInt(1));
		user.setFirstname(rs.getString(2));
		user.setLastname(rs.getString(3));
		user.setEmailid(rs.getString(4));
		user.setMobilenumber(rs.getString(5));
		user.setPassword(rs.getString(6));
		}
		return user;
	}
	@Override
	public boolean isValidUserNameAndPassword(String email,String pwd) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("SELECT firstname,lastname FROM user WHERE emailid = ?  AND password =  ? ");
		System.out.println("SELECT firstname,lastname FROM user WHERE emailid = "+email+"  AND password = "+pwd );
		
		stmt.setString(1, email);
		stmt.setString(2, pwd);
				
		ResultSet rs=stmt.executeQuery();
		int count=0;
		while(rs.next())
			count++;
		System.out.println(rs.getRow());
		if(count>=1)
			return true;
		else
			return false;
	}
	

}
