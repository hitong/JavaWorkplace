package view;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import work.Init;
import work.Model;

public class ViewControl {
	@FXML
	private TableView<Model> table;
	
	@FXML
	private TableColumn<Model, String>  numberCol;
	
	@FXML
	private TableColumn<Model, String>  mainConcent;
	
	@FXML
	private TableColumn<Model, String>  comeFromText;
	
	@FXML
	private TableColumn<Model, String>  comeFromFile;
	
	@FXML
	private TableColumn<Model, String>  data;
	
	@FXML
	private TableColumn<Model, String>  depart;
	
	@FXML
	private TableColumn<Model, String>  sender;
	
	@FXML
	private TableColumn<Model, String>  del;
	
	@FXML
	private TableColumn<Model, String> change;
	
	@FXML
	private TableColumn<Model, String> view;
	@FXML 
	private TextArea search;
	
	@FXML
	private ChoiceBox<String> choiceBox;
			
	@FXML
	private void addClick(){
		main.showAlter(null);
	}

	@FXML
	private void initialize() {
		mainConcent.setCellValueFactory(cellData -> cellData.getValue().getMainConcent());
		comeFromText.setCellValueFactory(cellData -> cellData.getValue().getComeFromText());
		comeFromFile.setCellValueFactory(cellData -> cellData.getValue().getComeFromFile());
		data.setCellValueFactory(cellData -> cellData.getValue().getData());
		depart.setCellValueFactory(cellData -> cellData.getValue().getDepart());
		sender.setCellValueFactory(cellData -> cellData.getValue().getSender());
		numberCol.setCellFactory((col) -> {
            TableCell<Model, String> cell = new TableCell<Model, String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    this.setText(null);
                    this.setGraphic(null);
                    if (!empty) {
                        int rowIndex = this.getIndex() + 1;
                        this.setText(String.valueOf(rowIndex));
                    }
                }
            };
            return cell;
        });
		
		  del.setCellFactory((col) -> {
	            TableCell<Model, String> cell = new TableCell<Model, String>() {
	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    this.setText(null);
	                    this.setGraphic(null);
	                    if (!empty) {
	                    	ImageView imageView = new ImageView(new Image("img/d.png"));
	                    	imageView.setFitWidth(20);
	                    	imageView.setFitHeight(20);
	                        Button delBtn = new Button(null,imageView);
	                        this.setGraphic(delBtn);
	                        delBtn.setOnMouseClicked((me) -> {
	                        	Model clickedModel = this.getTableView().getItems().get(this.getIndex());
	                        	main.delMessage(clickedModel);
	                        });
	                    }
	                }
	            };
	            return cell;
	        });
		  
		  change.setCellFactory((col) -> {
	            TableCell<Model, String> cell = new TableCell<Model, String>() {
	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    this.setText(null);
	                    this.setGraphic(null);
	                    if (!empty) {
	                    	ImageView imageView = new ImageView(new Image("img/c.png"));
	                    	imageView.setFitWidth(20);
	                    	imageView.setFitHeight(20);
	                        Button delBtn = new Button(null,imageView);
	                        this.setGraphic(delBtn);
	                        delBtn.setOnMouseClicked((me) -> {
	                        	Model model = this.getTableView().getItems().get(this.getIndex());
	                        	Init init = new Init("修改", model);
	                        	main.showAlter(init);
	                        });
	                    }
	                }
	            };
	            return cell;
	        });
		  
		  view.setCellFactory((col) -> {
	            TableCell<Model, String> cell = new TableCell<Model, String>() {
	                @Override
	                public void updateItem(String item, boolean empty) {
	                    super.updateItem(item, empty);
	                    this.setText(null);
	                    this.setGraphic(null);
	                    if (!empty) {
	                    	ImageView imageView = new ImageView(new Image("img/view.png"));
	                    	imageView.setFitWidth(20);
	                    	imageView.setFitHeight(20);
	                        Button viewBt = new Button(null,imageView);
	                        this.setGraphic(viewBt);
	                        viewBt.setOnMouseClicked((me) -> {
	                        	Model model = this.getTableView().getItems().get(this.getIndex());
	                        	Init init = new Init("查看", model);
	                        	main.showAlter(init);
	                        });
	                    }
	                }
	            };
	            return cell;
	        });
		  ObservableList<String> value = FXCollections.observableArrayList();
		  value.add("全局搜索");
		  value.add("发件人");
		  value.add("发布日期");
		  value.add("出台部门");
		  value.add("所属文件");
		  value.add("所属条文");
		  value.add("主要内容");
		  choiceBox.setItems(value);
		  choiceBox.setValue("全局搜索");
		  choiceBox.setTooltip(new Tooltip("选择你的搜索类型"));
		  choiceBox.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
				main.setSearchType(value.get((int) newv));
				showSearch();
		  	}
		  );
	}

	Main main;
	
	public void setMain(Main main) {
		this.main = main;
		this.table.setItems(main.getData());
	}
	
	public void showSearch(){
		main.showSearch(search.getText());
	}
}
