package com.bridgelab.jdbc.loginRegistration.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.bridgelab.jdbc.loginRegistration.repository.UserRepository;
import com.bridgelab.jdbc.loginRegistration.repository.UserRepositoryImpl;
import com.bridgelab.utility.Utility;


public class UserImpl {
	private static UserRepository userRepoistory;
	private static User user;
	public UserImpl() {
		try {
			userRepoistory = new UserRepositoryImpl();
			user = new User();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void Register() {

		boolean isvalid = false;
		try {
		do {
			isvalid = true;
			System.out.print("Enter the First Name :");
			user.setFirstname(Utility.getString());
			isvalid = Utility.isOnlyAlphabets(user.getFirstname());
			if (!isvalid)
				System.out.println("First name must contain atleast 2 characters");
		} while (isvalid == false);

		do {
			isvalid = true;
			System.out.print("Enter the Last Name :");
			user.setLastname(Utility.getString());
			isvalid = Utility.isOnlyAlphabets(user.getLastname());
			if (!isvalid)
				System.out.println("Last name must contain atleast 2 characters and must contain only aphabets");
		} while (isvalid == false);
		do {
			isvalid = true;
			System.out.print("Enter the Email id :");
			user.setEmailid(Utility.getString());
			isvalid = Utility.isValidEmail(user.getEmailid());
			if (!isvalid)
				System.out.println("Email is must contain @ and dot(.)");
		} while (isvalid == false);
		do {
			isvalid = true;
			System.out.print("Enter the Password :");
			user.setPassword(Utility.getString());
			isvalid = Utility.isValidPassword(user.getPassword());
			if (!isvalid)
				System.out.println("password is must contain atleast one lowercase letter and one number");
		} while (isvalid == false);
		do {
			isvalid = true;
			System.out.print("Enter the Mobile Number :");
			user.setMobilenumber(Utility.getString());
			;
			isvalid = Utility.isValidMobileNumber(user.getMobilenumber());
			if (!isvalid)
				System.out.println("mobile number must start with 7,8 or 9 is only ten digit long");
		} while (isvalid == false);

		boolean isRegister = userRepoistory.addUser(user);
		System.out.println(isRegister);
		do {
			if (!isRegister) {
				do {
					isvalid = true;
					System.out.print("Enter the Email id :");
					user.setEmailid(Utility.getString());
					isvalid = Utility.isValidEmail(user.getEmailid());
					if (!isvalid)
						System.out.println("Email is must contain @ and dot(.)");
				} while (isvalid == false);
				isRegister = userRepoistory.addUser(user);
				
				
			}
			if(isRegister)
				System.out.println("Successfully Registered");
		} while (!isRegister);
		}catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public boolean signIn(String emailid,String pwd) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException
	{
		
		if(userRepoistory.isValidUserNameAndPassword(emailid, pwd))
		{
			user=userRepoistory.getUserDetails(emailid, pwd);
			System.out.println("***********************************************");
			System.out.println("Successfully Log In!!!");
			System.out.println("User Id :"+user.getUid());
			System.out.println("Name :"+user.getFirstname()+" "+user.getLastname());
			System.out.println("Email Id :"+user.getEmailid());
			MessageDigest md = MessageDigest.getInstance("MD5");
			 BigInteger no = new BigInteger(1, md.digest(user.getPassword().getBytes())); 
				System.out.println("Password :"+no);
				System.out.println("***********************************************");	
			return true;
		}
		else
			return false;
		
	}

}
