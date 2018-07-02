package work;

public class MySwitch {
	public static boolean mySwitch(Model model, int choise, String content) {
		if (choise > 5 || choise < 0) {
			return false;
		}
		switch (choise) {
		case 0:
			model.setMainConcent(content);
			break;
		case 1:
			model.setComeFromText(content);
			break;
		case 2:
			model.serComeFromFile(content);
			break;
		case 3:
			model.setData(content);
			break;
		case 4:
			model.setDepart(content);
			break;
		case 5:
			model.setSender(content);
			break;
		}
		return true;
	}

	public static String mySwitch(Model model, int choise) {
		switch (choise) {
		case 0:
			return model.getMainConcent().getValue();
		case 1:
			return model.getComeFromText().getValue();
		case 2:
			return model.getComeFromFile().getValue();
		case 3:
			return model.getData().getValue();
		case 4:
			return model.getDepart().getValue();
		case 5:
			return model.getSender().getValue();
		}
		return null;
	}
}
