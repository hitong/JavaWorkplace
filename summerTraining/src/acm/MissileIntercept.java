package acm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MissileIntercept {
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){		
		int[] missile = MissileIntercept.CreatAArray();
		
				
		System.out.println(
				MissileIntercept.numbeOfCalculationSystems(missile));
		
		input.close();
	}
	
	/**
	 * ���뵼����Ŀ,������Ҫ�䱸������ϵͳ����
	 * @param missile
	 * @param intercept
	 * @return
	 */
	public static int numbeOfCalculationSystems(int[] missile){
		int[] intercept = new int[missile.length];
		int number = 1;
		int temp1 = 0;
		int temp2 = 0;
		intercept[0] = missile[0];
		boolean flag = false ;		
		int index = 0;		
		for(int i = 0; i < missile.length; i++){
				 
			flag = true;	/** ��ʼ������״̬*/
			for(int j = 0; j < number; j++){
				temp1 = intercept[j] - missile[i]; 
			
				if(temp1 >= 0 && flag){
					temp2 = temp1;
					flag = false;
					index = j;
				}
				
				if(temp2 > temp1 && temp1 >= 0 && !flag){
					temp2 = temp1;
					index = j;
				}
			}
			/**�Ķδ��룬ͨ���������ؼ�࣬�ж���������*/
			
			if(flag){
				intercept[number++] = missile[i];
			}
			else{
				intercept[index] = missile[i];
			}	
			/**
			 * ��������������޸�����ϵͳ��Ϣ�����������ϵͳ
			 */
		}
		
		return number;
	}
	
	/**
	 * ������������
	 * @return
	 */
	public static int[] CreatAArray(){
		int[] arr;
		int temp;
		
		while(true){
			try{
				temp = input.nextInt();
				if(temp > 0){
					arr = new int[temp];
				}
				else{
					throw new IntegerOutRangeException();
				}
				
				break;
			}catch(IndexOutOfBoundsException ex){
				input.next();
				System.out.println("Misslen's number must bigger than 0");
			
			}catch(InputMismatchException ex){
				input.next();
				System.out.println("Please input a integer");
			
			}catch(IntegerOutRangeException ex){
				System.out.println("The number of missiles must be greater than 0");
			
			}
		
		}
		
		
		/**
		 * �û�������ÿ�������ĸ߶�
		 */
		for(int i = 0; i < arr.length; i++){
			while(true){
				try{
					temp = input.nextInt();
					if(temp > 30000 || temp < 0){
						throw new IntegerOutRangeException();
					}
					else{
						arr[i] = temp;
					}
					
					break;
				}catch(InputMismatchException ex){
					input.next();
					System.out.println("Please input a integer");
					
				}catch(IntegerOutRangeException ex){
					System.out.println("Missile altitude range:0 - 30000");
					
				}
			}
		}
		
		return arr;
	}
}

@SuppressWarnings("serial")
class IntegerOutRangeException extends Exception{
}