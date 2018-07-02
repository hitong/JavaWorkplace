package partSix;

public class CreditCard {
	
     public static boolean isValid(long number){
    	 if(!prefixMatched(number , getSize(number)) )
    		 return false;
    	 else if(!sumOfDoubleEvenPlace(number))
    		 return false;
    	 else 
    		 return true;
 	 
     }
     
     public static boolean sumOfDoubleEvenPlace(long number){
    	 int[] sum = new int[2];
    	 int times = 0;
    	 int temp = 0;
    	 while(number > 0){
    		 times++;
    		 if(times % 2 == 0){
    			 temp = (int)(number % 10) ;
    			 temp = getDigit(temp * 2);
    			 sum[0] = temp + sum[0]; 
    			 number = number / 10;
    		 }
    		 else {
    			 temp = (int)(number % 10);
    			 temp = getDigit((int)temp);
    			 sum[1] = (int)temp + sum[1]; 
    			 number = number / 10;			 
    		 }
    		 
    	 }  	 
    	 
    	 if(((sum[0] + sum[1]) % 10) == 0)
    		 return true;
    	 else
    		 return false;
     }
    
     
     public static int getDigit(int number){
    	 if(number < 10)
    		 return number;
    	 else 
    		 return number % 10  + number / 10;
     }
    
     public static boolean prefixMatched(long number, int d){
    	 int one = (int)(number / Math.pow(10, getSize(number) - 1));
    	 int two = (int)(number / Math.pow(10, getSize(number) - 2));
		
    	 if(one != 4 && one != 5 && one != 6 && two != 47 )
    		 return false;
    	 else if( d < 13 || d > 18)
    		 return false;
    	 else
    		 return true;
     }
     
     public static int getSize(long d){
    	 int size = 0;
    	 while(d > 0){
    		 size++;
    		 d = d / 10;
    	 }
    	 return size;
     }
     
}

	 

	 
	
	  
	 
