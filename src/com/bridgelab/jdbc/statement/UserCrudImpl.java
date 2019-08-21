package com.bridgelab.jdbc.statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelab.utility.Utility;

import java.sql.Statement;
import java.sql.Connection;

public class UserCrudImpl {

	Connection conn;

	public UserCrudImpl() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://@localhost:3306/addressbook", "root", "admin");
	}
	public void createTable() throws SQLException
	{
		System.out.println("Enter Create Query");
		String query=Utility.getString();
		Statement stmt=conn.createStatement();
		int i=stmt.executeUpdate(query);
		System.out.println(i+" table is Created");
	}
	public void addUser() throws SQLException {
		User user = new User();
		System.out.println("Enter first Name");
		user.setFirstname(Utility.getString());
		System.out.println("Enter last Name");
		user.setLastname(Utility.getString());
		boolean isValid;
		boolean isUnique;
		do {
			System.out.println("Enter the Email Id");
			user.setEmail(Utility.getString());
			isValid = Utility.isValidEmail(user.getEmail());
			if (!isValid)
				System.out.println("email id must contain one @ and .symbol");
			isUnique = isUniqueEmailId(user.getEmail());
			if (!isUnique)
				System.out.println("email id Already present");
		} while (!isValid || !isUnique);
		do {
			System.out.println("Enter the Password");
			user.setPassword(Utility.getString());
			isValid = Utility.isValidPassword(user.getPassword());
			if (!isValid)
				System.out
						.println("password must contain alteast one lowercase and one number and minimum 8 digit long");
		} while (!isValid);
		do {
			System.out.println("Enter the Mobile Number");
			user.setMobilenumber(Utility.getString());
			isValid = Utility.isValidMobileNumber(user.getMobilenumber());
			if (!isValid)
				System.out.println("mobile number must start with 7,8 or 9 and must be 10 digit long");
		} while (!isValid);

		String Query = "INSERT INTO user (firstname,lastname,emailid,password,mobilenumber) VALUES("
				+ user.getFirstname() + "," + user.getLastname() + "," + user.getEmail() + "," + user.getPassword()
				+ "," + user.getMobilenumber() + ")";
		Statement stmt = conn.createStatement();
		int i = stmt.executeUpdate(Query);
		System.out.println(i + " Record Add into table");
	}

	public boolean isUniqueEmailId(String emailid) throws SQLException {
		String Query = "Select * FROM user Where emailid='" + emailid + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Query);
		int count = 0;
		while (rs.next()) {
			count++;
		}
		if (count >= 1)
			return false;
		else
			return true;
	}

	public void editUser() throws SQLException {
		System.out.println("Enter Email Id");
		String email = Utility.getString();
		int choice;
		do {
			System.out.println("1.Edit First Name");
			System.out.println("2.Edit Last Name");
			System.out.println("3.Edit Password");
			System.out.println("4.Edit Mobile Number");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice");
			choice = Utility.getInteger();
			boolean isValid;
			switch (choice) {
			case 1:
				System.out.println("Enter First Name");
				String fname = Utility.getString();
				UpdateDetails(fname, "firstname", email);
				break;
			case 2:
				System.out.println("Enter Last Name");
				String lname = Utility.getString();
				UpdateDetails(lname, "lastname", email);
				break;
			case 3:
				String password;
				do {
					System.out.println("Enter the Password");
					password=Utility.getString();
					isValid = Utility.isValidPassword(password);
					if (!isValid)
						System.out.println(
								"password must contain alteast one lowercase and one number and minimum 8 digit long");
				} while (!isValid);
				UpdateDetails(password, "password", email);
				break;
			case 4:
				String ph;
				do {
					System.out.println("Enter the Mobile Number");
					ph=Utility.getString();
					isValid = Utility.isValidMobileNumber(ph);
					if (!isValid)
						System.out.println("mobile number must start with 7,8 or 9 and must be 10 digit long");
				} while (!isValid);
				UpdateDetails(ph, "mobilenumber", email);
				break;
			case 5:System.exit(0);
			default:System.out.println("Enter Valid Choice\n");
			}

		} while (choice != 5);
	}

	public void UpdateDetails(String newValue, String field, String email) throws SQLException {
		Statement stmt = conn.createStatement();
		String query = "UPDATE user SET " + field + "= '" + newValue + "' WHERE emailid='" + email + "'";
		int i = stmt.executeUpdate(query);
		System.out.println(i + " Record Updated\n");
	}
	public void deleteUser() throws SQLException
	{
		System.out.println("Enter Email Id");
		String email = Utility.getString();
		
		Statement stmt = conn.createStatement();
		String query = "DELETE FROM user WHERE emailid='"+email+"'";
		int i = stmt.executeUpdate(query);
		System.out.println(i + " Record Deleted\n");
	}
	public void displayUser() throws SQLException
	{
		System.out.println("Enter Email Id");
		String email = Utility.getString();
		String Query = "Select * FROM user Where emailid='" + email + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(Query);
		while(rs.next())
		{
			System.out.println("Name :"+rs.getString(2)+" "+rs.getString(3));
			System.out.println("Email Id:"+rs.getString(4));
			System.out.println("Mobile Number:"+rs.getString(6));
			System.out.println("\n");
		}
		
	}
}
