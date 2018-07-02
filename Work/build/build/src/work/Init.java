package work;

public class Init {
	private String type;
	private Model model;
	
	public Init(String type,Model model){
		this.type = type;
		this.model = model;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	
}
