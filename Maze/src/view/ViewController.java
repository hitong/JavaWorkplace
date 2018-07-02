package view;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import util.MyButton;

public class ViewController {
	@FXML
	Pane pane;
	
	int[][] table;
	Main main;
	
	public void setMain(Main main) {
		this.main = main;
	}
	
	public void setTable(int[][] table) {
		this.table = new int[table.length][table[0].length];
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				this.table[i][j] = table[i][j];
			}
		}
	}
	
	public void showTable(int[][] table) {
		this.pane.getChildren().clear();
		VBox vb = new VBox();
		int row = 0;
		int col = 0;
		for (int[] x : table) {
			HBox hb = new HBox();
			col = 0;
			for (int y : x) {
				MyButton b = new MyButton(row, col++);
				b.setMinWidth(45);
				b.setMinHeight(45);
				b.setOnAction( event ->{
					if((b.x == table.length - 1 && b.y ==table[0].length - 1)|| (b.x == 0 && b.y == 0)) {
						return;
					}
					else {
						if(this.table[b.x][b.y] == Integer.MIN_VALUE) {
							this.table[b.x][b.y] = 0;
							b.setStyle("-fx-background-color: #8B8682");
						}
						else {
							this.table[b.x][b.y] = Integer.MIN_VALUE;
							b.setStyle("-fx-background-color: #191970");
						}
					}
				});
				if (y == Integer.MIN_VALUE) {
					b.setStyle("-fx-background-color: #191970");
				} else {
					b.setStyle("-fx-background-color: #8B8682");
				}
				
				if(row == table.length - 1&&col == table[0].length) {
					b.setStyle("-fx-background-color: #FFEC8B");
				}
				else if(row == 0 && col == 1){
					b.setStyle("-fx-background-color: #d6ed6e");
				}
				else {
					
				}
				hb.getChildren().add(b);
			}
			row++;
			vb.getChildren().add(hb);
		}
		
		this.pane.getChildren().add(vb);
	}
	
	@FXML
	public void addRow() {
		if(this.table.length >= 40) {
			return;
		}
		int[][] tmp = new int[this.table.length + 1][this.table[0].length];
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				tmp[i][j] = table[i][j];
			}
		}
		this.table = tmp;
		this.showTable(table);
	}
	
	@FXML
	public void addCol() {
		if(this.table[0].length >= 40) {
			return;
		}
		int[][] tmp = new int[this.table.length][this.table[0].length + 1];
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				tmp[i][j] = table[i][j];
			}
		}
		this.table = tmp;
		showTable(table);
	}
	
	@FXML
	public void reSet() {
		for(int i = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				table[i][j] = 0;
			}
		}
		this.showTable(table);
	}
	
	@FXML
	public void delRow() {
		if(table.length <= 1) {
			return;
		}
		else {
			int[][] tmp = new int[table.length - 1][table[0].length];
			for(int i = 0; i < tmp.length; i++) {
				for(int j = 0; j < tmp[0].length; j++) {
					tmp[i][j] = table[i][j];
				}
			}
			tmp[0][0] = 0;
			tmp[tmp.length - 1][tmp[0].length - 1] = 0;
			this.table = tmp;
			showTable(table);
		}
	}
	
	@FXML
	public void delCol() {
		if(table[0].length <= 1) {
			return;
		}
		else {
			int[][] tmp = new int[table.length][table[0].length - 1];
			for(int i = 0; i < tmp.length; i++) {
				for(int j = 0; j < tmp[0].length; j++) {
					tmp[i][j] = table[i][j];
				}
			}
			tmp[0][0] = 0;
			tmp[tmp.length - 1][tmp[0].length - 1] = 0;
			this.table = tmp;
			showTable(table);
		}
	}
	
	@FXML
	public void randomBuilt() {
		for(int i  = 0; i < table.length; i++) {
			for(int j = 0; j < table[0].length; j++) {
				if(Math.random() > 0.7) {
					table[i][j] = Integer.MIN_VALUE;
				}
				else {
					table[i][j]  = 0;
				}
			}
		}
		table[table.length - 1][table[0].length - 1]  = 0;
		table[0][0]  = 0;
		showTable(table);
	}
	
	@FXML
	public void saveData() {
		System.out.println("saveData");
		main.writeToFile(table);
	}
	
	@FXML
	public void readDate() {
		System.out.println("readData");
		this.setTable(main.readFromFile());
		this.showTable(table);
	}
	
	@FXML
	public void complete() {
		main.setTable(table);
		main.showMainView();
	}
	
	@FXML
	public void cancel() {
		main.showMainView();
	}
}
