/*
 * @purpose	:find number possibilities if number of node is given
 * @author	:sangita awaghad
 * @version	:1.0
 * @since	:06-08-2019  
 */
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class BinarySearchTree {
	public static void main(String args[])
	{
		Utility utility=new Utility();
		System.out.println("Enter Number of Nodes in binary tree");
		int node=utility.getInteger();
		
		for(int i=1;i<=node;i++)
		{
			System.out.println("For node "+i+" number of possibilities are :"+Utility.findNumberPossibleBinaryTree(i));
		}
	}
}
