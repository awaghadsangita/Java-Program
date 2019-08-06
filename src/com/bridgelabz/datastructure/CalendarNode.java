/*******************************************************************************************
 * @purpose	:calendar linked list node containing date field,day of week and next pointer
 * @author	:sangita avghad
 * @version	:1.0
 * @since	:06-08-2019
 *******************************************************************************************/
package com.bridgelabz.datastructure;

public class CalendarNode {
	int date;
	String day;
	CalendarNode next;
	CalendarNode(int date, String day) {
		this.date = date;
		this.day = day;
		this.next = null;
	}
}
