package jv.co.properties.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongduchoang
 */
public class PropertiesInfo {

	/**
	 * declare variables
	 */
	private Map<String, String> properties = null;
	private Map<String, Object> propertieValues = null;

	/**
	 * @comment constructor properties info
	 */
	public PropertiesInfo() {
		properties = new HashMap<String, String>();
		propertieValues = new HashMap<String, Object>();
	}

	/**
	 * @comment copy properties same name
	 * @param key
	 * @return PropertiesInfo
	 */
	public PropertiesInfo add(String key) {
		try {
			if (this.properties.containsKey(key)) {
				throw new Exception("Key is  duplicate...!!!");
			}
			if (key == null || "".equals(key)) {
				throw new Exception("Key cannot null or empty...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
		properties.put(key, key);
		return this;
	}

	/**
	 * @comment copy by difference properties name
	 * @param keyTo
	 * @param KeyFrom
	 * @return PropertiesInfo
	 */
	public PropertiesInfo add(String keyTo, String KeyFrom) {
		try {
			if (this.properties.containsKey(keyTo)) {
				throw new Exception("Key is  duplicate...!!!");
			}
			if (keyTo == null || "".equals(keyTo) || KeyFrom == null || "".equals(KeyFrom)) {
				throw new Exception("Key cannot null or empty...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
		properties.put(keyTo, KeyFrom);
		return this;
	}

	/**
	 * @comment set value by properties name
	 * @param key
	 * @param value
	 * @return PropertiesInfo
	 */
	public PropertiesInfo addValue(String key, Object value) {
		try {
			if (this.properties.containsKey(key)) {
				throw new Exception("Key is  duplicate...!!!");
			}
			if (key == null || "".equals(key)) {
				throw new Exception("Key cannot null or empty...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
		propertieValues.put(key, value);
		return this;
	}

	/**
	 * @comment set null by properties name
	 * @param key
	 * @return PropertiesInfo
	 */
	public PropertiesInfo addNull(String key) {
		try {
			if (this.propertieValues.containsKey(key)) {
				throw new Exception("Key is  duplicate...!!!");
			}
			if (key == null || "".equals(key)) {
				throw new Exception("Key cannot null or empty...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
		propertieValues.put(key, null);
		return this;
	}

	/**
	 * @comment set empty by properties name
	 * @param key
	 * @return PropertiesInfo
	 */
	public PropertiesInfo addEmpty(String key) {
		try {
			if (this.propertieValues.containsKey(key)) {
				throw new Exception("Key is  duplicate...!!!");
			}
			if (key == null || "".equals(key)) {
				throw new Exception("Key cannot null or empty...!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return this;
		}
		propertieValues.put(key, "");
		return this;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public Map<String, Object> getPropertieValues() {
		return propertieValues;
	}

	public void setPropertieValues(Map<String, Object> propertieValues) {
		this.propertieValues = propertieValues;
	}
}
