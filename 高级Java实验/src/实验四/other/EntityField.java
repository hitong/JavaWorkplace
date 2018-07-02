package 实验四.other;
	
public class EntityField {
	   String fieldName;
	   String column;
	   String type;
	   private boolean isKey;
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		if(utils.NullTest.isNull(type)){
			return;
		}
		this.type = type;
	}
    public boolean isKey(){
    	return isKey;
    }
	public void setKey(boolean isKey) {
		this.isKey = isKey;
	}
	@Override
	public String toString() {
		return "EntityField [fieldName=" + fieldName + ", column=" + column + ", type=" + type + ", isKey=" + isKey
				+ "]";
	}	   
}
