package treeView;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import main.MainForTree;
import tree.BinaryTree.TreeNode;

public class TreeController {
	private MainForTree main;
	
	@FXML
	Pane pane;

	@FXML 
	TextField value;
	
	public void setMain(MainForTree main) {
		this.main = main;
		drawTree();
	}
	
	public void drawTree() {
		int width;
		this.pane.getChildren().clear();
		try {
			width = main.getTreeWidth() * 320;
			if(width == 0) {
				Label l = new Label("No Data");
				l.setFont(new Font(40));   
				this.pane.getChildren().add(l);
				return;
			}
		}
		catch(Exception ex) {
			return;
		}
		list = new ArrayList<>();
		if(width > 320 * 35) {
			radius = 13;
			maxSize = 10;
		}
		else if(width > 320 * 30) {
			radius = 15;
			maxSize = 20;
		}
		else if(width > 320 * 20) {
			radius = 20;
			maxSize = 30;
		}
		else {
			radius = 25;
			maxSize = 40;
		}
		this.disPlayTree(main.getTree().getRoot(), width / 2, 50, width / 4);
		this.pane.getChildren().addAll(list);
	}
	
	ArrayList<Node> list;
	int radius = 25;
	int height = 90;
	int maxSize = 40;
	public void disPlayTree(TreeNode<String> root, int x, int y, int width) {
		Circle arc = new Circle();
        arc.setCenterX(x );
        arc.setCenterY(y);
        arc.setRadius(radius);
        arc.setFill(Color.YELLOW);
        arc.setStroke(Color.DARKTURQUOISE);
        Label label = new Label(root.getElement() + "");
        label.setLayoutX(x - radius / 3);
        label.setLayoutY(y - radius / 3);
        label.setMaxWidth(maxSize);
        list.add(arc);
        list.add(label);
        if(root.getLeft() !=null) {
        	connectLeftChilde(x - width, y + height, x, y);
        	disPlayTree(root.getLeft(),x - width, y + height, width / 2);
        }
        if(root.getRight() != null) {
        	connectRightChilde(x + width, y + height, x ,y);
        	disPlayTree(root.getRight(), x + width, y + height, width / 2);
        }
	}
	
	private void connectLeftChilde(int x1, int y1, int x2, int y2) {
		double d = Math.sqrt(height * height + (x2 - x1) * (x2 - x1));
		double x11 = (x1 + radius * (x2 - x1)/ d);
		double y11 = (y1 - radius * height / d);
		double x21 = (x2 - radius * (x2 - x1) / d);
		double y22 = (y2 + radius * height / d);
		list.add(new Line(x11,y11,x21,y22));
//		Label l = new Label("0");
//		l.setLayoutX((x11 + x21) / 2);
//		l.setLayoutY((y11 + y22) / 2);;
//		list.add(l);
	}
	
	private void connectRightChilde(int x1, int y1, int x2, int y2) {
		double d = Math.sqrt(height * height + (x2 - x1) * (x2 - x1));
		double x11 = (x1 - radius * (x1 - x2)/ d);
		double y11 = (y1 - radius * height / d);
		double x21 = (x2 + radius * (x1 - x2) / d);
		double y22 = (y2 + radius * height / d);
		list.add(new Line(x11,y11,x21,y22));
//		Label l = new Label("1");
//		l.setLayoutX((x11 + x21) / 2);
//		l.setLayoutY((y11 + y22) / 2);;
//		list.add(l);
	}	
	
	@FXML
	public void search(){
		if(main.search(value.getText())) {
			main.showInfor("the vaule is found at in the tree!");
		} else {
			main.showInfor("Not found the value in the tree!");	
		}
	}
	
	@FXML
	public void insert() {
		main.insert(this.value.getText());
		drawTree();
	}
	
	@FXML
	public void delete() {
		main.delete(value.getText());
		System.out.println("s");
		drawTree();
	}
}
