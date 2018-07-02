package Test;

import org.json.JSONException;
import org.json.JSONObject;

public class TestJson {
	public static void main(String[] args){
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("sad", 123);
			jsonObject.put("userName", 156);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			JSONObject t = new JSONObject(jsonObject.toString());
			System.out.println(t.get("userName"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
