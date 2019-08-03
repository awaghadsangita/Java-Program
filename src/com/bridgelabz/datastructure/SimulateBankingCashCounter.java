/*
 * @purpose	:create a program which creates banking cash counter where people come in to deposit Cash and withdraw Cash
 * 			add people in queue
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:03-08-2019
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class SimulateBankingCashCounter {
	//start point of main program
	public static void main(String arg[])
	{
		Utility utility=new Utility();
		int availableCash=50000;
		
		int choice;
		Queue que=new Queue();
		System.out.println("Availble Cash :"+availableCash);
		
		do {
			System.out.println("Availble Cash :"+availableCash);
			System.out.println("\n1.Deposit\n2.Withdrawal\n3.Add Person in Queue\n4.Exit\nEnter your Choice");
			choice=utility.getInteger();
			switch(choice)
			{
			case 1:
				if(que.isEmpty())
				{
					System.out.println("Queue is EMPTY cannot deposit");
					break;
				}
				else
				{
					System.out.println("Enter the Amount to Deposit");
					int depositAmount=utility.getInteger();
					availableCash=availableCash+depositAmount;
					que.dequeue();
					
					que.showQue();
					break;
				}
			case 2:
				if(que.isEmpty())
				{
					System.out.println("Queue is EMPTY cannot Widthdraw");
					break;
				}
				else
				{
					
					System.out.println("Enter the Amount for withdraw");
					int withdrawAmt=utility.getInteger();
					if(availableCash>withdrawAmt)
					{
						availableCash=availableCash-withdrawAmt;
						que.dequeue();
						
						que.showQue();
					}
					else
						System.out.println("Bank Does NOT have Enough Cash for withdraw");
					
					break;
				}
			
			case 3:
					System.out.println("How many People You want to add in Queue");
					int noOfPerson=utility.getInteger();
					for(int i=0;i<noOfPerson;i++)
						que.enqueue();
					System.out.println("Queue Status");
					que.showQue();
					break;
			default:
					System.out.println("Enter choice between 1 to 4");
				break;
				
			}	
		}while(choice!=4);
	}
}
