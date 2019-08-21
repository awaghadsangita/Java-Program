package com.bridgelab.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelab.utility.Utility;

public class CallableStmtCrudImpl {

	Connection conn;

	public CallableStmtCrudImpl() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://@localhost:3306/addressbook", "root", "admin");
	}
	
	public void addUser() throws SQLException {
		User user = new User();
		System.out.print("Enter first Name");
		user.setFirstname(Utility.getString());
		System.out.print("Enter last Name");
		user.setLastname(Utility.getString());
		boolean isValid;
		boolean isUnique;
		do {
			System.out.print("Enter the Email Id");
			user.setEmail(Utility.getString());
			isValid = Utility.isValidEmail(user.getEmail());
			if (!isValid)
				System.out.println("email id must contain one @ and .symbol");
			isUnique = isUniqueEmailId(user.getEmail());
			if (!isUnique)
				System.out.println("email id Already present");
		} while (!isValid || !isUnique);
		do {
			System.out.print("Enter the Password");
			user.setPassword(Utility.getString());
			isValid = Utility.isValidPassword(user.getPassword());
			if (!isValid)
				System.out
						.println("password must contain alteast one lowercase and one number and minimum 8 digit long");
		} while (!isValid);
		do {
			System.out.print("Enter the Mobile Number");
			user.setMobilenumber(Utility.getString());
			isValid = Utility.isValidMobileNumber(user.getMobilenumber());
			if (!isValid)
				System.out.println("mobile number must start with 7,8 or 9 and must be 10 digit long");
		} while (!isValid);

		CallableStatement stmt = conn.prepareCall("{call addUser(?,?,?,?,?)}");
		stmt.setString(1, user.getFirstname());
		stmt.setString(2, user.getLastname());
		stmt.setString(3, user.getEmail());
		stmt.setString(4, user.getPassword());
		stmt.setString(5, user.getMobilenumber());
		int i = stmt.executeUpdate();
		System.out.println(i + " Record Added into table\n*********");
	}

	public boolean isUniqueEmailId(String emailid) throws SQLException {
		CallableStatement stmt = conn.prepareCall("{call returnRecord(?)}");
		stmt.setString(1, emailid);
		ResultSet rs = stmt.executeQuery();
		int count = 0;
		while (rs.next()) {
			count++;
		}
		if (count >= 1)
			return false;
		else
			return true;
	}

	public void displayUser() throws SQLException {
		System.out.println("Enter You Email Id");
		String email = Utility.getString();
		CallableStatement stmt = conn.prepareCall("{call returnRecord(?)}");
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			System.out.println("Name :" + rs.getString(2) + " " + rs.getString(3));
			System.out.println("Email :" + rs.getString(4));
			System.out.println("Mobile Number :" + rs.getString(6));
			System.out.println("\n");
		}

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
				UpdateFNameDetails(fname, email);
				break;
			case 2:
				System.out.println("Enter Last Name");
				String lname = Utility.getString();
				UpdateLNameDetails(lname, email);
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
				UpdatePassword(password,email);
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
				UpdateMobileNumber(ph, email);
				break;
			case 5:System.exit(0);
			default:System.out.println("Enter Valid Choice\n");
			}

		} while (choice != 5);
	}
	public void UpdateFNameDetails(String newValue, String email) throws SQLException {
		CallableStatement stmt = conn.prepareCall("{call updateFirstName(?,?)}");
		stmt.setString(1, newValue);
		stmt.setString(2, email);
		
		int i = stmt.executeUpdate();
		System.out.println(i + " Record Updated\n");
	}
	public void UpdateLNameDetails(String newValue, String email) throws SQLException {
		CallableStatement stmt = conn.prepareCall("{call updateLastName(?,?)}");
		stmt.setString(1, newValue);
		stmt.setString(2, email);
		
		int i = stmt.executeUpdate();
		System.out.println(i + " Record Updated\n");
	}
	public void UpdatePassword(String newValue, String email) throws SQLException {
		CallableStatement stmt = conn.prepareCall("{call updatePassword(?,?)}");
		stmt.setString(1, newValue);
		stmt.setString(2, email);
		
		int i = stmt.executeUpdate();
		System.out.println(i + " Record Updated\n");
	}
	public void UpdateMobileNumber(String newValue, String email) throws SQLException {
		CallableStatement stmt = conn.prepareCall("{call updateMobileNumber(?,?)}");
		stmt.setString(1, newValue);
		stmt.setString(2, email);
		
		int i = stmt.executeUpdate();
		System.out.println(i + " Record Updated\n");
	}
	public void deleteRecord() throws Exception
	{
		System.out.println("Enter Email id");
		String email=Utility.getString();
		
		CallableStatement stmt = conn.prepareCall("{call deleteRecord(?)}");
		stmt.setString(1, email);
		int i=stmt.executeUpdate();
		System.out.println(i+" Record Deleted\n");
		
		
	}
}
