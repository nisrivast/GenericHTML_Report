package Report;

import java.util.Properties;

public class ConfigPropertyReader {

	private static String defaultConfigFile = "Config.properties";

	public ConfigPropertyReader() {
	}

	public static String getProperty(String propFile, String Property) {
		try {
			if (System.getProperty(Property) != null) {
				return System.getProperty(Property);

			} else {
				Properties prop = ResourceLoader.loadProperties(propFile);
				return prop.getProperty(Property);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String getProperty(String property) {
		return getProperty(defaultConfigFile, property);
	}

	public static boolean checkIfValueIsNull(String value) {
		try {
			value.isEmpty();
			return false;
		} catch (NullPointerException ex) {
			return true;
		}

	}
}
