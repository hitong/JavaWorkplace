package listView;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.MainForLinked;

public class LinkedListController {
	@FXML
	Pane pane;
	
	@FXML
	TextField value;
	
	@FXML
	TextField index;
	
	private MainForLinked main;
	
	public void setMain(MainForLinked main) {
		this.main = main;
		showList();
	}
	
	private void showList() {
		pane.getChildren().clear();
		
		if(main.getSize() == 0) {
			Label l = new Label("No Data");
			l.setFont(new Font(30));
			pane.getChildren().add(l);
		} else {
			list.MyList<String> tmpList = main.getList();
			double valueSize = 70;
			double indexSize = 30;
			double start = 50;
			for(int i = 0; i < tmpList.size(); i++) {
				Label l1 = new Label(tmpList.get(i));
				Label l2 = new Label("");
				l1.setMinSize(valueSize, 30);
				l1.setMaxSize(valueSize, 30);
				l2.setMinSize(indexSize, 30);
				l2.setMaxSize(indexSize, 30);
				l1.setLayoutX(150 * i + start);
				l2.setLayoutX(150 * i + valueSize + start);
				l1.setLayoutY(150);
				l2.setLayoutY(150);
				l1.setStyle("-fx-border-style:solid;");
				l2.setStyle("-fx-border-style: solid;");
				l1.setAlignment(Pos.CENTER);
				pane.getChildren().addAll(l1,l2);
				if(i + 1 < tmpList.size()) {
					Line line1 = new Line(150 * i + valueSize + start + indexSize / 2, 165,150 *( i + 1)+ start, 165);
					Line l1t = new Line(150 *( i + 1)+ start - 20, 160, 150 *( i + 1)+ start, 160);
					Line l2t = new Line(150 *( i + 1)+ start - 20, 170, 150 *( i + 1)+ start, 170);
					l1t.setRotate(30);
					l2t.setRotate(-30);
					pane.getChildren().addAll(line1,l1t,l2t);
				}
			}
			Text head = new Text("head");
			head.setFont(new Font(15));
			head.setLayoutX(start  - 20);
			head.setLayoutY(85);
			Line headLine = new Line(start + valueSize / 2, 150,start,89);
			Line thl1 = new Line(start + valueSize / 2, 145,start + valueSize / 2 - 20, 145);
			thl1.setRotate(24);
			Line thl2 = new Line(start + valueSize / 2 + 10, 140,start + valueSize / 2 - 10, 140);
			thl2.setRotate(95);
			
			Text tail = new Text("tail");
			tail.setFont(new Font(15));
			tail.setLayoutX(150 *( tmpList.size()) - 35);
			tail.setLayoutY(85);
			Line tailLine = new Line(150 *( tmpList.size()) - 65, 150,150 *( tmpList.size()) - 28 ,89);
			Line ttl1 = new Line(150 *( tmpList.size()) - 45, 145,150 *( tmpList.size()) - 65, 145);
			ttl1.setRotate(156);
			Line ttl2 = new Line(150 *( tmpList.size()) - 55, 140,150 *( tmpList.size()) - 65 - 10, 140);
			ttl2.setRotate(95);
			pane.getChildren().addAll(head,headLine,thl1,thl2,tail,tailLine,ttl1,ttl2);
		}
	}
	
	@FXML
	public void search() {
		System.out.println("search");
		int tmp = main.search(value.getText());
		if(tmp == -1) {
			main.showInfor("Not found the value in the linked list!");	
		} else {
			main.showInfor("the vaule is found at " + tmp + " in the linked list!");
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
}	
