package been;

public class Book {
	private String ISBN = "";
	private String name = "";
	private String editor = "";
	private String price = "";
	private String pub = "";
	private String message = "";
	private String stock = "";
	private String type = "";
	private String img = "";
	private int time = 0;
	
	public String getISBN() {
		return ISBN;
	}
	
	public void set(String s){	
		switch(time++){
		case 0:this.setISBN(s);break;
		case 1:this.setName(s);break;
		case 2:this.setEditor(s);break;
		case 3:this.setPrice(s);break;
		case 4:this.setPub(s);break;
		case 5:this.setMessage(s);break;
		case 6:this.setStock(s);break;
		case 7:this.setType(s);break;
		case 8:this.setImg(s);break;
		default:;
		}
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
