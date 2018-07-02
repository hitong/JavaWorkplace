package exteaWork;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.*;



public class Caculator extends Application{
	public ArrayList<Object> s = new ArrayList<>(); 
	TextField stext = new TextField();
	TextField etext = new TextField();
	boolean havaPast = false;
	static boolean point = false;
	static boolean pastPoint = false;
	static double firstNumber = 0;
	static double secondNumber = 0;
	int size = 0;
	
	static int pointNumber = 0;
	static int pastPointNumber = 0;
	static double result = 0;
	
	public void start(Stage primaryStage){
		s.add(0);
		BorderPane pane1 = new BorderPane();
		BorderPane pane3 = new BorderPane();
		GridPane pane2 = new GridPane();
		etext.setEditable(false);
		stext.setEditable(false);
		stext.setPrefColumnCount(15);
		stext.setPrefHeight(89);
		etext.setPrefColumnCount(15);
		etext.setPrefHeight(89);
		etext.setAlignment(Pos.BASELINE_RIGHT);
		stext.setAlignment(Pos.BASELINE_RIGHT);
		pane3.setTop(etext);
		pane3.setBottom(stext);
		
		pane1.setTop(pane3);
		pane1.setPrefHeight(60);
		pane1.setPrefWidth(60);
		
		String[][] s2 = {
				{"\n		%		\n" , "\n		��		\n", 
					"\n		x		\n", "\n		 1/x		\n"},
				{"\n		CE		\n" , "\n		C		\n",
					"\n		S		\n", "\n		 ��		\n"},
				{"\n		7		\n" , "\n		8		\n",
					"\n		9		\n", "\n		 ��		\n"},
				{"\n		4		\n" , "\n		5		\n",
					"\n		6		\n", "\n		 - 		\n"},
				{"\n		1		\n" , "\n		2		\n", 
					"\n		3		\n", "\n		 +		\n"},
				{"\n		��		\n" , "\n		0		\n", 
					"\n		.		\n", "\n		 =		\n"}
		};
		Button[][] button = new Button[6][4];
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 4; j++){
				button[i][j] = new Button("" + s2[i][j]);
					switch(i * 4 + j){
						case 0:button[i][j].setOnAction(new b00());break;
						case 1:button[i][j].setOnAction(new b01());break;
						case 2:button[i][j].setOnAction(new b02());break;
						case 3:button[i][j].setOnAction(new b03());break;
						case 4:button[i][j].setOnAction(new b10());break;
						case 5:button[i][j].setOnAction(new b11());break;
						case 6:button[i][j].setOnAction(new b12());break;
						case 7:button[i][j].setOnAction(new b13());break;
						case 8:button[i][j].setOnAction(new b20());break;
						case 9:button[i][j].setOnAction(new b21());break;
						case 10:button[i][j].setOnAction(new b22());break;
						case 11:button[i][j].setOnAction(new b23());break;
						case 12:button[i][j].setOnAction(new b30());break;
						case 13:button[i][j].setOnAction(new b31());break;
						case 14:button[i][j].setOnAction(new b32());break;
						case 15:button[i][j].setOnAction(new b33());break;
						case 16:button[i][j].setOnAction(new b40());break;
						case 17:button[i][j].setOnAction(new b41());break;
						case 18:button[i][j].setOnAction(new b42());break;
						case 19:button[i][j].setOnAction(new b43());break;
						case 20:button[i][j].setOnAction(new b50());break;
						case 21:button[i][j].setOnAction(new b51());break;
						case 22:button[i][j].setOnAction(new b52());break;
						case 23:button[i][j].setOnAction(new b53());break;					
				}
				pane2.add(button[i][j], j, i);
			}
		}
	
		
		
			
		pane1.setBottom(pane2);	
		Scene scene = new Scene(pane1, 536, 400);

		primaryStage.setTitle("Caculator");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	
	public static void main(String[] args){
			
			Application.launch(args);
	}
	
	
	
	
	
	public class b00 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(s.isEmpty())
				return;		
			else if(s.get(s.size() - 1) instanceof String){
				s.set(s.size() - 1 , "%");
			}
			else
				s.add("%");		
		}
	}
	public class b01 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
		}
	}
	public class b02 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
		}
	}
	public class b03 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
		}
	}
	public class b10 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(!s.isEmpty() && !point)
				s.set(s.size() - 1, 0);	
			else if(point && pointNumber > 0){
				s.remove(s.size() - 1);
				s.remove(s.size() - 1);
				if(!s.isEmpty())
					s.remove(s.size() - 1);
			}
			else if(point && pointNumber == 0){
				s.remove(s.size() - 1);
				point = false;
			}
		}
	}
	public class b11 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			s.clear();		
			s.add(0);
		}
	}
	
	public class b12 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){		
			if(!s.isEmpty() && !point)
				s.set(s.size() - 1, 0);	
			else if(point && pointNumber > 0){
				if((int)s.get(s.size() - 1) < 10)
					s.remove(s.size() - 1);
				s.set(s.size() - 1, (int)s.get(s.size() - 1) / 10);		
			}
			else if(point && pointNumber == 0){
				s.remove(s.size() - 1);
				point = false;
			}
				
		}
	}
	public class b13 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(!havaPast){
				pastPointNumber = pointNumber;
				pastPoint = point;
				havaPast = true;				
				if(point && pointNumber == 0){
					s.add(0);
					pastPointNumber++;
				}			
			}
			else	{
				result = getResult(s);
				s.clear();
				point = false;
				pointNumber = 0;
				size = 0;
				pastPointNumber = 0;
				double x = result - (int)result;	
				pastPoint = false;								
				while(x==0){
					pastPoint = true;
					pastPointNumber++;
					double y = x * 10 - (int)(x * 10);
					x = y;
				}
				s.add((int)result);
				if(pastPoint){
					s.add(".");
					s.add((result - (int)result) *
							Math.pow(10, pastPointNumber));
				}
				s.add("��");
			}
		}
	}
	public class b20 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(7);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 7);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 7);
			view(s,stext);
		}
	}
	public class b21 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(8);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 8);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 8);
			view(s,stext);
		}
	}
	public class b22 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(9);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 9);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 9);
			view(s,stext);
		}
	}
	public class b23 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(!havaPast){
				pastPointNumber = pointNumber;
				pastPoint = point;
				havaPast = true;				
				if(point && pointNumber == 0){
					s.add(0);
					pastPointNumber++;
				}			
			}
			else	{
				result = getResult(s);
				s.clear();
				point = false;
				pointNumber = 0;
				size = 0;
				pastPointNumber = 0;
				double x = result - (int)result;	
				pastPoint = false;								
				while(x==0){
					pastPoint = true;
					pastPointNumber++;
					double y = x * 10 - (int)(x * 10);
					x = y;
				}
				s.add((int)result);
				if(pastPoint){
					s.add(".");
					s.add((result - (int)result) *
							Math.pow(10, pastPointNumber));
				}
				s.add("��");
			}
		}
	}
	public class b30 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(4);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 4);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 4);
			view(s,stext);
		}
	}
	public class b31 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(5);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 5);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 5);
			view(s,stext);
		}
	}
	public class b32 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(6);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 6);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 6);
			view(s,stext);
		}
	}
	public class b33 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(!havaPast){
				pastPointNumber = pointNumber;
				pastPoint = point;
				havaPast = true;				
				if(point && pointNumber == 0){
					s.add(0);
					pastPointNumber++;
				}			
			}
			else	{
				result = getResult(s);
				s.clear();
				point = false;
				pointNumber = 0;
				size = 0;
				pastPointNumber = 0;
				double x = result - (int)result;	
				pastPoint = false;								
				while(x==0){
					pastPoint = true;
					pastPointNumber++;
					double y = x * 10 - (int)(x * 10);
					x = y;
				}
				s.add((int)result);
				if(pastPoint){
					s.add(".");
					s.add((result - (int)result) *
							Math.pow(10, pastPointNumber));
				}
				s.add("-");
			}
		}
		
	}
	public class b40 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(1);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 1);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 1);
			view(s,stext);
		}
	}
	public class b41 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(2);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 2);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 2);
			view(s,stext);
		}
		
	}
	public class b42 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(3);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 3);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 3);
			view(s,stext);
		}
	}
	public class b43 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(!havaPast){
				pastPointNumber = pointNumber;
				pastPoint = point;
				havaPast = true;	
				point = false;
				size = 0;
				pointNumber = 0;
				if(point && pointNumber == 0){
					s.add(0);
					pastPointNumber++;
				}			
			}
			else	{
				if(!(s.get(s.size() - 1) instanceof String)){
				result = getResult(s);
				s.clear();
				point = false;
				pointNumber = 0;
				size = 0;
				s.add(0, (int)result);
				pastPointNumber = 0;
				double x = result - (int)result;	
				pastPoint = false;	
				
				while(x!=0){
					pastPoint = true;
					pastPointNumber++;
					double y = x * 10 - (int)(x * 10);
					x = y;
				}
				s.add((int)result);
				if(pastPoint){
					s.add(".");
					s.add((result - (int)result) *
							Math.pow(10, pastPointNumber));
				}
				s.add("+");
				view(s,stext);
				}
			}
		}
	}
	public class b50 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			s.add("+-");
			System.out.println(s.get(0));
		}
	}
	public class b51 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(point){
				size++;
				if(size == 1){
					s.remove(s.size() - 1);
					s.add(0);
				}
				else
					s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 0);
			}
			else
				s.set(s.size() - 1, (int)(s.get(s.size() - 1)) * 10 + 0);
			view(s,stext);
		}
	}
	public class b52 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			if(!point){
				s.add(".");
				s.add("");
			}
			point = true;
			view(s,stext);
		}
	}
	
	public class b53 implements EventHandler<ActionEvent>{
		public void handle(ActionEvent e){
			s.add(".");
			point = true;
		}
	}

	
	
	
	
	
	
	
	
	
	public static double getNumber(int index, int size, ArrayList<Object> s){
		
		int i = (int)s.get(index);
		double j = (int)s.get(index + 2) /
				Math.pow(10, Math.pow(10.0, size));
		double number = i + j;		

		return number;
	}
	
	public static double getResult(ArrayList<Object> s){
		double result = 0;
		if(!point && !pastPoint){		
			switch((char)s.get(s.size() - 2)){
			case '+':result = (int)s.get(s.size() - 1) + 
					(int)s.get(s.size() - 3);break;
			case '-':result = (int)s.get(s.size() - 1) - 
					(int)s.get(s.size() - 3);break;
			case '*':result = (int)s.get(s.size() - 1) * 
					(int)s.get(s.size() - 3);break;
			case '/':result = (int)s.get(s.size() - 1) / 
					(int)s.get(s.size() - 3);break;
			}
	
		}
		else if(!point && pastPoint){
			double past = getNumber(0 , pastPointNumber, s);
	
			switch((char)s.get(s.size() - 2)){
			case '+':result = past + 
					(int)s.get(s.size() - 3);break;
			case '-':result = past - 
					(int)s.get(s.size() - 3);break;
			case '*':result = past * 
					(int)s.get(s.size() - 3);break;
			case '/':result = past / 
					(int)s.get(s.size() - 3);break;
		
			}
		}
		else if(point && !pastPoint){
			double there = getNumber(2 , pointNumber, s);
	
			switch((char)s.get(s.size() - 4)){
			case '+':result = (int)s.get(s.size() - 1) + 
					there;break;
			case '-':result = (int)s.get(s.size() - 1) - 
					there;break;
			case '*':result = (int)s.get(s.size() - 1) * 
					there;break;
			case '/':result = (int)s.get(s.size() - 1) / 
					there;break;
			}
		}
		else{
			double past = getNumber(0 , pastPointNumber, s);
			double there = getNumber(4 , pointNumber, s);
			switch((char)s.get(s.size() - 4)){
			case '+':result = past + 
					(int)s.get(s.size() - 3);break;
			case '-':result = past - there;break;
			case '*':result = past * there;break;
			case '/':result = past / there;break;
			}
		}
		return result;
	}
	
	public static void view(ArrayList<Object> s,TextField text){
		String string = "";
		for(int i = 0; i < s.size(); i++)
			string = string + s.get(i).toString();
		text.setText(string);
		
	}
}



