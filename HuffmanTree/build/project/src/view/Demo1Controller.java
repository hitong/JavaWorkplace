package view;

import java.util.ArrayList;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import model.Code;
import util.Huffman.TreeNode;

public class Demo1Controller {
	@FXML
	private TableView<Code> tablePane;

	@FXML
	private Pane drawPane;

	@FXML
	private TableColumn<Code, String> ch;

	@FXML
	private TableColumn<Code, Number> weight;

	@FXML
	private TableColumn<Code, String> hfm;

	@FXML
	private TextField initData;// 接受初始化数据

	@FXML
	private TextField inputData;// 接受编码数据

	@FXML
	private TextField inputCode;// 接受译码数据

	@FXML
	private TextArea compressData;// 编码数据展示区域

	@FXML
	private TextArea deCodeong;// 译码数据展示区域

	@FXML
	private RadioButton clear;

	@FXML
	private RadioButton save;

	public Main main;

	@FXML
	private void initialize() {
		ch.setCellValueFactory(cellData -> cellData.getValue().chProperty());
		hfm.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		weight.setCellValueFactory(cellData -> cellData.getValue().weightProperty());
	}

	@FXML
	private void readFromFile() {
		this.tablePane.setItems(main.inputByFile());
		this.drawTree();
	}

	@FXML
	private void writeFile() {
		main.writeHuffmanCode();
	}

	@FXML
	private void printTreeToFile() {
		main.printTreeToFile();
	}

	public void setMain(Main main) {
		this.main = main;
		this.tablePane.setItems(main.getCodeData());
	}

	public void drawTree() {
		int width;
		try {
			width = main.hfm.getRoot().getWidth() * 320;
		} catch (Exception ex) {
			return;
		}
		list = new ArrayList<>();
		if (width > 320 * 35) {
			radius = 13;
		} else if (width > 320 * 30) {
			radius = 15;
		} else if (width > 320 * 20) {
			radius = 20;
		} else {
			radius = 25;
		}//通过数据量的大小，更改节点的图形大小
		this.disPlayTree(main.hfm.getRoot().getNode(), width / 2, 50, width / 4);
		this.drawPane.getChildren().clear();
		this.drawPane.getChildren().addAll(list);
	}

	ArrayList<Node> list;
	int radius = 25;
	int height = 90;

	public void disPlayTree(TreeNode.Node root, int x, int y, int width) {
		Circle arc = new Circle();
		arc.setCenterX(x);
		arc.setCenterY(y);
		arc.setRadius(radius);
		arc.setFill(Color.YELLOW);
		arc.setStroke(Color.DARKTURQUOISE);
		Label label = new Label(root.getCh() + "");
		label.setLayoutX(x - radius / 3);
		label.setLayoutY(y - radius / 3);
		list.add(arc);
		list.add(label);
		if (root.getLeft() != null) {
			connectLeftChilde(x - width, y + height, x, y);
			disPlayTree(root.getLeft(), x - width, y + height, width / 2);
		}
		if (root.getRight() != null) {
			connectRightChilde(x + width, y + height, x, y);
			disPlayTree(root.getRight(), x + width, y + height, width / 2);
		}
	}

	private void connectLeftChilde(int x1, int y1, int x2, int y2) {
		double d = Math.sqrt(height * height + (x2 - x1) * (x2 - x1));
		double x11 = (x1 + radius * (x2 - x1) / d);
		double y11 = (y1 - radius * height / d);
		double x21 = (x2 - radius * (x2 - x1) / d);
		double y22 = (y2 + radius * height / d);
		list.add(new Line(x11, y11, x21, y22));
		// Label l = new Label("0");
		// l.setLayoutX((x11 + x21) / 2);
		// l.setLayoutY((y11 + y22) / 2);;
		// list.add(l);
	}

	private void connectRightChilde(int x1, int y1, int x2, int y2) {
		double d = Math.sqrt(height * height + (x2 - x1) * (x2 - x1));
		double x11 = (x1 - radius * (x1 - x2) / d);
		double y11 = (y1 - radius * height / d);
		double x21 = (x2 + radius * (x1 - x2) / d);
		double y22 = (y2 + radius * height / d);
		list.add(new Line(x11, y11, x21, y22));
		// Label l = new Label("1");
		// l.setLayoutX((x11 + x21) / 2);
		// l.setLayoutY((y11 + y22) / 2);;
		// list.add(l);
	}

	@FXML
	public void keyEventInit() {
		String s = this.initData.getText();
		if (this.clear.selectedProperty().getValue()) {
			initData.clear();
		}
		this.tablePane.setItems(main.inputByTerminal(s, this.save.selectedProperty().getValue()));
		drawTree();
	}

	@FXML
	public void keyEventInputData() {
		String s = inputData.getText() + "";
		try {
			if (s == "") {
				this.compressData.setText("");
			} else {
				this.compressData.setText("编码成功：" + this.main.hfm.dataToBin(s));
			}
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			this.compressData.setText("编码失败：存在未初始化的字符。");
		}
	}

	@FXML
	public void keyEventDecoding() {
		String s = this.inputCode.getText() + "";
		try {
			if (s == "") {
				this.deCodeong.setText("");
			} else {
				this.deCodeong.setText("编码成功：" + this.main.hfm.binToData(s));
			}
		} catch (NoSuchFieldException e) {
			this.deCodeong.setText("编码失败：代码指向了未定义编码。");
		}
	}

	@FXML
	public void backMenu() {
		main.showMainMenu();
	}
}
