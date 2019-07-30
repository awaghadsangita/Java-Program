/*
 * @purpose	:Read .a List of Numbers from a file and arrange it ascending Order in a
 * Linked List. Take user input for a number, if found then pop the number out of the
 * list else insert the number in appropriate position
 * @auhor	:sangita awaghad
 * @since	:30-07-2019
 */

package com.bridgelabz.datastructure;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class OrderedList {

	public static void main(String args[])
	{
		try {
			
			FileReader fr=new FileReader("/home/user/Desktop/sangita.txt");
			Scanner scanner=new Scanner(fr);
			Scanner scannerUserValue=new Scanner(System.in);
			int data;
			while(scanner.hasNext())
			{
				data=scanner.nextInt();
//				System.out.println(data);
				LinkedList.add(data);
			}
			int search;
			Node previous=LinkedList.HEAD;
			System.out.println();
			LinkedList.sort();
			do
			{
				System.out.println("Link list item");
				LinkedList.show();
				System.out.println("\nEnter number to Search or if you Want exit press 0");
				search=scannerUserValue.nextInt();
				if(search!=0)
				{
					int position=LinkedList.index(search);//finding position of item in linked list
					if(position!=-1)
					{
						System.out.println(search +" is FOUND");
						System.out.println(position +" is FOUND");
						LinkedList.delete(position);
						
					}
					else //item not present add node in linked list
					{
						
						System.out.println(search +" is NOT FOUND in slot ");
//						LinkedList.add(search);
						LinkedList.addDataInSortedList(search);
					}
				}
				
			}while(search!=0);
			LinkedList.sort();
			Writer wr= new FileWriter("/home/user/Desktop/sangita.txt",false);
			
			Node temp=LinkedList.HEAD;
			while(temp!=null)
			{
				wr.write(temp.number+" ");
				wr.flush();
				temp=temp.next;
			}
			
			
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
