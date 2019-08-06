/******************************************************************************************
 * @purpose	:store the calendar in an 2D array,the first dimension the week of the month and 
 * 			the second dimension stores the day.prints the calendar of the month. 
of the week
 * @author 	:sangita avghad
 * @version	:1.0
 * @since	:06-08-2019
 ******************************************************************************************/
package com.bridgelabz.datastructure;

import com.bridgelabz.utility.Utility;

public class Calendar {
	
	public static void main(String args[])
	{
		Utility utility=new Utility();
		int month=Integer.parseInt(args[0]);
		int year=Integer.parseInt(args[1]);
		
		String day[]= {"SUN","MON","THU","WEN","THR","FRI","SAT"};
		int d=Utility.dayOfWeek(1,month,year); //giving day of a week
		
		int totalDayInMonth[]= {0,31,28,31,30,31,30,31,30,30,31,30,31};
		String Months[]= {"","January","February","March","April","May","June","July","August","September","October","November","December"};
		
		if(utility.checkerLeapYear(year))//checking whether given year is leap year or not
			totalDayInMonth[2]=29;
		
		int totalDays=d+totalDayInMonth[month];
		while(totalDays%7!=0)
		{
			totalDays++;
		}
		int totalWeeks=totalDays/7;
	
		int[][] weeks=new int[totalWeeks][7];
		
		int weekIndex=0;
		int count=0;
		
		while(count<d )
		{
			weeks[weekIndex][count]=0;
			count++;
		
		}
		for(int i=1;i<=totalDayInMonth[month];i++)
		{
			weeks[weekIndex][count]=i;
			
			count++;
			if(count%7==0)
			{
				count=0;
				weekIndex++;
			}
		}
		while(count%7!=0)
		{
			weeks[weekIndex][count]=0;
			count++;
		}
		System.out.print("   "+Months[month]+year+"\n");
		for(int i=0;i<7;i++)
		{
			System.out.print(day[i]+" ");
		}
		System.out.println();
		weekIndex=0;			
		count=0;
		
		for(int i=1;i<=(d+totalDayInMonth[month]);i++)
		{
			
			if(weeks[weekIndex][count]==0)
				System.out.print("    ");
			else if(weeks[weekIndex][count]<10)
				System.out.print(weeks[weekIndex][count]+"   ");
			else if(weeks[weekIndex][count]<totalDayInMonth[month])
				System.out.print(weeks[weekIndex][count]+"  ");
			else
				System.out.print("    ");
			count++;
			if(count%7==0)
			{	weekIndex++;
				count=0;
			  	System.out.print("\n");
			 }	
		}
	}
}
