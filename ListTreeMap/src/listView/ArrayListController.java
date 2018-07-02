package listView;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import main.MainForArr;

public class ArrayListController {
	private MainForArr main;
	
	@FXML
	Pane pane;
	
	@FXML
	Label title;
	
	@FXML 
	TextField value;
	
	@FXML
	TextField index;
	
	public void setMain(MainForArr main) {
		this.main = main;
		showList();
	}
	
	private void showList() {
		list.MyList<String> tmpList = main.getList();
		HBox hb = new HBox();
		pane.getChildren().clear();
		for(int i = 0; i < tmpList.size(); i++) {
			Label l = new Label(tmpList.get(i));
			l.setStyle("-fx-border-style: solid;");
			l.setMinSize(100, 30);
			l.setMaxSize(100, 30);
			l.setAlignment(Pos.CENTER);
			hb.getChildren().add(l);
		}
		for(int j = 0; j < main.getRealSize() - tmpList.size(); j++) {
			StackPane sp = new StackPane();
			Label l = new Label(" ");
			l.setMinSize(100, 30);
			l.setMaxSize(100, 30);
			l.setAlignment(Pos.CENTER);
			l.setStyle("-fx-border-style: solid;");
			double x = l.getLayoutX();
			double y = l.getLayoutY();
			Line line = new Line(x, y+30 , x + 99, y);
			sp.getChildren().add(line);
			sp.getChildren().add(l);
			hb.getChildren().add(sp);
		}
		title.setText("array list: size = " + tmpList.size() + "  capacity = " + main.getRealSize());
		pane.getChildren().add(hb);
	}
	
	@FXML
	public void search(){
		System.out.println("search");
		int tmp = main.search(value.getText());
		if(tmp == -1) {
			main.showInfor("Not found the value in the array list!");	
		} else {
			main.showInfor("the vaule is found at " + tmp + " in the array list!");
		}
	}
	
	@FXML
	public void insert() {
		System.out.println("insert");
		if(this.index.getText().length() == 0) {
			main.insert(this.value.getText(), main.getList().size());
		} else {
			try {
				main.insert(this.value.getText(), Integer.parseInt(index.getText()));
			}catch(Exception ex) {
				main.showErr("Please check index");
			}
		}
		showList();
	}
	
	@FXML
	public void delete() {
		System.out.println("delete");
		if(this.index.getText().length() == 0) {
			main.delete(value.getText());
		} else {
			try {
				main.delete(Integer.parseInt(index.getText()));
			}catch(Exception ex) {
				main.showErr("Please check index");
			}
		}
		showList();
	}
	
	@FXML
	public void trimToSize() {
		System.out.println("trimToSize");
		main.trimToSize();
		showList();
	}
	
	@FXML
	public void Check() {
		System.out.println(this.index.getText());
		try {
			if(this.index.getText().length() != 0) {
				Integer.parseInt(this.index.getText());
			} else {
			}
		} catch(Exception ex) {
			this.index.setText("");
		}
	}
}
