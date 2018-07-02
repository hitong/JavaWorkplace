package partNine;

public class TotalArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleWithPrivateDataFields[] circleArray;
		
		//create circleArray
		circleArray = createCircleArray();
		
		//print circleArray and total areas of the circles
		printCircleArray(circleArray);

	}
	
	//create an array of circle objects
	public static CircleWithPrivateDataFields[] createCircleArray(){
		CircleWithPrivateDataFields[] circleArray = new CircleWithPrivateDataFields[5];
		
		for(int i = 0 ; i < circleArray.length ; i++){
			circleArray[i] = new CircleWithPrivateDataFields(Math.random() * 100);
			
		}
		return circleArray;
	}
	
	//Print an array of circles and their total area
	public static void printCircleArray(CircleWithPrivateDataFields[] circleArray){
		System .out .printf("%-30s%-15s\n","Radius","Area");
		for(int i = 0 ; i < circleArray.length ; i++){
			System .out .printf("%-30f%-15f\n",circleArray[i].getRadius(),circleArray[i].getArea());
		}
		
		System .out .println("--------------------------------------------------------");
		
		//compute and display the result
		System .out .printf("%-30s%-15f\n","The total area of circles is ",sum(circleArray));
		
	}
	
	//add circle areas
	public static double sum(CircleWithPrivateDataFields[] circleArray){
		//initialize sum
		double sum = 0;
		
		//add areas to sum
		for(int i = 0 ; i < circleArray.length ; i++)
			sum += circleArray[i].getArea();
		
		return sum;
		
	}

}
