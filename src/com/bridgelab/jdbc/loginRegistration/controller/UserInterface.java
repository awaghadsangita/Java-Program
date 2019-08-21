package com.bridgelab.jdbc.loginRegistration.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.bridgelab.utility.Utility;

public class UserInterface {

	public static void main(String[] args) throws SQLException, NoSuchAlgorithmException, ClassNotFoundException {
		int decision;
		do 
		{
			System.out.println("1.Login\n2.Registration\n3.Exit\nEnter the Your Choice");
			decision=Utility.getInteger();
			functionaCalls(decision);
			
		}while(decision!=3);

	}
	public static void functionaCalls(int decision) throws NoSuchAlgorithmException, SQLException, ClassNotFoundException
	{
		UserImpl obj=new UserImpl();
		switch(decision)
		{
		case 1:System.out.println("********************");
				System.out.println("\t\tLogin");
			   System.out.print("Enter the Email Id :");
			   String emailid=Utility.getString();
			   System.out.print("Enter Password :");
			   String pwd=Utility.getString();
			   boolean result=obj.signIn(emailid,pwd);
			   if(!result)
			   {
				   System.out.println("Invalid Username or Password");
//				   functionaCalls(1);
			   }
			   else
			   {
				   
			   }
				   
		break;
		case 2: System.out.println("********************");
				System.out.println("\t\tRegistration");
				obj.Register();
				functionaCalls(1);
				break;
		}
	}

}
