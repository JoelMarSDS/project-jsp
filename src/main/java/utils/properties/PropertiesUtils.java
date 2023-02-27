package utils.properties;

public class PropertiesUtils {

	public static String getPathPage(String path){
		
		for (EnumPropertiesUtils enumPropertiesUtils : EnumPropertiesUtils.values()) {
			
			if (enumPropertiesUtils.toString().equalsIgnoreCase(path)) {
				return enumPropertiesUtils.getValue();
			}
		}
		
		return EnumPropertiesUtils.NOT_FOUND.getValue();
	}
}
