package partSeventeen;

import java.util.*;
import java.io.*;

public class SaveLoan {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		double sum = 0;
		
		String s = "F:\\JavaFile\\Exercise 17_06.dat";
		File file = new File(s);
/**		
		try(ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(file, file.exists()))){		
			out.writeObject(new Loan());
			out.writeObject(new Loan());
		}
		***/	
		try{
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(file));
			System.out.println(((Loan)(in.readObject())).getLoanDate());
	/**		while(true){	
				sum += ((Loan)in.readObject()).getLoanAmount();					
			}*/
		}	
		
		catch(EOFException ex){
			System.out.println("All of the loanAmount is " + sum);			
		}
	}
}
