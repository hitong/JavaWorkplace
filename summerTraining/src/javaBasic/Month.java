package javaBasic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Month {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		int year = 0;
		int month;
		
		System.out.print("Enter year: ");
		
		boolean flag = true;
		
		int temp;
		while(true){
			try{
				if(flag){
					temp = input.nextInt();
					if(temp <= 0){
						throw new DataOutOfBoundsException();
					}
				}
				
				flag = false;
				
				System.out.print("Enter month: ");
				month = input.nextInt();
				
				if(month <= 0 || month > 12){
					throw new DataOutOfBoundsException();
				}
				
				break;
			}catch(InputMismatchException ex){
				input.next();
				System.out.println("Please input a integer");
			}catch(DataOutOfBoundsException ex){
				if(flag)
					System.out.println("The number of year must bigger than 0");
				else
					System.out.println("The number of month between 1 and 12");
			}
		}
				
		print(year, month);
		
		input.close();
	}
	
	
	
	public static void print(int year, int month){
		String[] week = {
				"Sun", "Mon", "Tue" , "Wed", "Thu", "Fri", "Sat", "Sun"
		};
		int feb = NumberOfDaysAYear.numberOfDaysInAYear(year) - 337;
		/**�жϸ����ƽ��������Ӷ���ȡ��Ӧ�Ķ�������*/
		
		int[] day = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Calendar c = new GregorianCalendar(year, month - 1, 2);
		int temp1 = c.get(Calendar.DAY_OF_WEEK) ;
		/**temp1���ڴ洢year��month��1�յ�������*/
		
		/**ͨ����׼��������ȡ���������µĵ�һ����������*/
		
		for(int i = 0; i < 7; i++){
			System.out.print(week[i] + " ");
		}
		
		System.out.println();
		
		for(int i = 0; i < temp1 && temp1 % 7 != 0; i++){
			System.out.print("    ");
		}
		/**��ѭ�����ڿ���ÿ�ܵ�һǰ�ļ�϶���Ӷ�ʹ��һ������ڶ�Ӧ��������*/
		
		
		for(int i = 0; i < day[month - 1]; i++){
			if((i + temp1) % 7 == 0 && i !=0 )
				System.out.println();
				
			System.out.printf("%3d ", i + 1);
		}
		/**ѭ�������Ӧ����*/
	}
}

@SuppressWarnings("serial")
class DataOutOfBoundsException extends Exception{
	
}
