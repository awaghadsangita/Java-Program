/******************************************************************************************
 * @purpose	:Implement month of calendar using stack using linked list
 * @author 	:sangita avghad
 * @version	:1.0
 * @since	:06-08-2019
 ******************************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class CalenderStack {
	CalendarNode TOP;

	/*
	 * return true stack is empty else false
	 */
	public boolean isEmpty() {
		return TOP == null;
	}

	/*
	 * push new node to top of stack
	 */
	public void push(CalendarNode node) {
		if (isEmpty()) {
			TOP = node;
		} else {
			node.next = TOP;
			TOP = node;
		}
	}

	/*
	 * return top node of stack
	 */
	public CalendarNode pop() {
		CalendarNode current = TOP;
		TOP = TOP.next;
		return current;
	}

	public static void main(String args[]) {
		Utility utility = new Utility();
		int month = Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);

		String day[] = { "SUN", "MON", "THU", "WEN", "THR", "FRI", "SAT" };
		int d = Utility.dayOfWeek(1, month, year);// return day of week

		int totalDayInMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String Months[] = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		if (utility.checkerLeapYear(year))
			totalDayInMonth[2] = 29;
		int totaldayInMonth = totalDayInMonth[month];

		int totalDays = d + totaldayInMonth;
		while (totalDays % 7 != 0) {
			totalDays++;
		}
		int totalWeeks = totalDays / 7;

		int[][] weeks = new int[totalWeeks][7];
		int weekIndex = 0;
		int count = 0;

		while (count < d) {
			weeks[weekIndex][count] = 0;
			count++;

		}

		for (int i = 1; i <= totalDayInMonth[month]; i++) {
			weeks[weekIndex][count] = i;
			count++;
			if (count % 7 == 0) {
				count = 0;
				weekIndex++;
			}
		}

		while (count % 7 != 0) {
			weeks[weekIndex][count] = 0;
			count++;
		}
		weekIndex = 0;
		int dayIndex = 0;
		CalenderStack firstStack = new CalenderStack();
		for (int i = 0; i < totalDays; i++) {
			CalendarNode newNode = new CalendarNode(weeks[weekIndex][dayIndex], day[dayIndex]);

			firstStack.push(newNode); // add new node after last node in linked list
			dayIndex++;
			if (dayIndex % 7 == 0) {
				dayIndex = 0;
				weekIndex++;

			}
		}
		CalenderStack secondStack = new CalenderStack();
		for (int i = 0; i < totalDays; i++) {
			CalendarNode newNode = firstStack.pop();
			secondStack.push(newNode);
		}

		System.out.print("   " + Months[month] + " " + year + "\n");
		for (int i = 0; i < 7; i++) {
			System.out.print(day[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < totalDays; i++) {
			CalendarNode node = secondStack.pop();// remove first node from linked list

			if (node.date == 0)
				System.out.print("    ");
			else if (node.date < 10)
				System.out.print(node.date + "   ");
			else if (node.date <= totalDayInMonth[month])
				System.out.print(node.date + "  ");
			else
				System.out.print("    ");
			count++;
			if (count % 7 == 0) {
				count = 0;
				System.out.print("\n");
			}

		}
	}
}
