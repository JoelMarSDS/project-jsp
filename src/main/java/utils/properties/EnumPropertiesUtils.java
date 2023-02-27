package utils.properties;

public enum EnumPropertiesUtils {
	
	HOME("../home/home.jsp"),
	NOT_FOUND("../erro/404.jsp");

	private String value;
	
	EnumPropertiesUtils(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
