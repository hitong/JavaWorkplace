package partNine;

public class Exercise9point13 {
	public static void main(String[] args){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("Enter the number of rows and columns in the arrary: "
				);
		int rows = input.nextInt();
		int columns = input.nextInt();
		
		double[][] array = new double[rows][columns];
		
		System.out.println("Enter the array:");
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++)
				array[i][j] = input.nextDouble();
		}
		
		Location location = locateLargest(array);
		
		System.out.print("The location of the largest element is " +
				location.maxValue + " at (" + 
				location.rows + ", " + 
				location.column + ") ");
	
	}		
		
	public static Location locateLargest(double[][] a){
		Location location = new Location(a[0][0]);
		
		
		for(int i = 0; i < a.length; i++){
			for(int j = 0; j < a[i].length; j++){
				if(a[i][j] > location.maxValue){
					location.maxValue = a[i][j];
					location.rows = i;
					location.column = j;
				}
			}			
		}
		return location;
	}
		
}

class Location{
	int rows;
	int column;
	double maxValue;
	
	Location(double maxValue){
		this.maxValue = maxValue;
	}
}
