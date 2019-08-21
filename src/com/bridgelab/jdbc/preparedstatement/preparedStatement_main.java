package com.bridgelab.jdbc.preparedstatement;

import java.sql.SQLException;

import com.bridgelab.jdbc.statement.UserCrudImpl;
import com.bridgelab.utility.Utility;

public class preparedStatement_main {
	public static void main(String args[]) throws SQLException
	{
		int choice;
		do
		{
			System.out.println("1.Add User");
			System.out.println("2.Update User");
			System.out.println("3.Delete User");
			System.out.println("4.Display User Details");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice");
			choice=Utility.getInteger();
			Operation(choice);
			
		}while(choice!=5);
	}
	public static void Operation(int choice) throws SQLException
	{
		UserCrudImpl obj=new UserCrudImpl();
		switch(choice)
		{
		case 1:System.out.println("***************************************");
		       System.out.println("\t\tRegistration");
		       obj.addUser();
		       break;
		case 2:System.out.println("****************************************");
				System.out.println("\t\tEdit User Details");
				obj.editUser();
				break;
		case 3:System.out.println("****************************************");
				System.out.println("\t\tDelete User Record");
				obj.deleteUser();
				break;
		case 4:
			System.out.println("****************************************");
			System.out.println("\t\tDisplay User Details");
			obj.displayUser();
			break;
		}
	}
}
