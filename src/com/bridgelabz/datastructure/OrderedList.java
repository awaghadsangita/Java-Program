/*
 * @purpose	:Ordered linked list,find element in list if find remove element if not add in linklist
 * @auhor	:sangita awaghad
 * @since	:30-07-2019
 */

package com.bridgelabz.datastructure;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class OrderedList {

	public static void main(String args[])
	{
		try {
			File f=new File("/home/user/Desktop/sangita.txt");
			FileReader filereader=new FileReader(f);
			Scanner scanner=new Scanner(filereader);
			Scanner scannerUserValue=new Scanner(System.in);
			int data;
			while(scanner.hasNext())
			{
				data=scanner.nextInt();
//				System.out.println(data);
				LinkedList.add(data);
			}
			int search;
//			Node previous=LinkedList.HEAD;
//			System.out.println();
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
			Writer writer= new FileWriter(f,false);
			
			Node temp=LinkedList.HEAD;
			while(temp!=null)
			{
				writer.write(temp.number+" ");
				writer.flush();
				temp=temp.next;
			}
			scanner.close();
			scannerUserValue.close();
			writer.close();
		}catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
