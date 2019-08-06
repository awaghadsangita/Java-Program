/*************************************************************************************************
 * @purpose	:create a slot of 10 to store Chain of numbers that belong to each slot to efficiently
 * 			 search a number from a given set of number
 * @auther	:sangita awaghad
 * @version	:1.0
 * @since	:03-08-2019
 **************************************************************************************************/
package com.bridgelabz.datastructure;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.bridgelabz.utility.Utility;

public class HashingFunction {
	public static void main(String args[]) {
		try {
			Utility utility = new Utility();
			LinkList<Integer>[] list = new LinkList[11];
			FileReader filereader = new FileReader("/home/user/Desktop/sangita.txt");
			Scanner scanner = new Scanner(filereader);
			
			for(int i=0;i<11;i++)
			{
				list[i]=new LinkList<Integer>();
			}

			int data;
			int searchItem;
			while (scanner.hasNext()) {
				data = scanner.nextInt();
				int index = data % 11;
				list[index].append(data);
			}

			do {
				System.out.println("Link list item");

				for (int i = 0; i < list.length; i++) {
					System.out.print("Slot :" + i +"=>");
					list[i].show();
				}

				System.out.println("\nEnter number to Search or if you Want exit press 0");
				searchItem = utility.getInteger();
				if (searchItem != 0) {
					int headIndex = searchItem % 11;
					int index = list[headIndex].index(searchItem);
					if (index != -1) {
						System.out.println(
								searchItem + " is FOUND in slot " + searchItem % 11 + " in " + index + " node");
						list[headIndex].Pop(index);
					} else if (index == -1) {
						System.out.println(searchItem + " is NOT FOUND in slot ");
						list[headIndex].append(searchItem);
					}
				}

			} while (searchItem != 0);

			FileWriter writer = new FileWriter("/home/user/Desktop/sangita.txt", false);

			for (int i = 0; i < list.length; i++) {
				Node<Integer> temp = list[i].HEAD;
				while (temp != null) {
					writer.write(temp.data + " ");
					writer.flush();

					temp = temp.getNext();
				}
			}
			writer.close();
			scanner.close();
		}

		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
