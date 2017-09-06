package jv.co.properties.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * get set properties data
 * 
 * @author dongduchoang
 */
public class PropertiesUtil {

	/**
	 * @comment get String value by properties name
	 * @param object
	 * @param fieldName
	 * @return String
	 */
	public static String getStringValue(Object object, String fieldName) {
		try {
			if (object != null) {
				Class<?> clazz = object.getClass();
				if (fieldName.indexOf(".") < 0) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					return toString(field.get(object));
				}
				String properties = fieldName.substring(0, fieldName.indexOf("."));
				String nextPro = fieldName.substring(fieldName.indexOf(".") + 1);
				Field field = clazz.getDeclaredField(properties);
				field.setAccessible(true);
				return getStringValue(field.get(object), nextPro);
			}
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * get properties by properties name
	 * 
	 * @param object
	 * @param fieldName
	 * @return Object
	 */
	public static String getEmptyValue(Object object, String fieldName) {
		try {
			if (object != null) {
				Class<?> clazz = object.getClass();
				if (fieldName.indexOf(".") < 0) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					if (field.get(object) != null) {
						return toString(field.get(object));
					}
					return "";
				}
				String properties = fieldName.substring(0, fieldName.indexOf("."));
				String nextPro = fieldName.substring(fieldName.indexOf(".") + 1);
				Field field = clazz.getDeclaredField(properties);
				field.setAccessible(true);
				return getEmptyValue(field.get(object), nextPro);
			}
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * @comment get properties by properties name
	 * @param object
	 * @param fieldName
	 * @return Object
	 */
	public static Object getProperties(Object object, String fieldName) {
		try {
			if (object != null) {
				Class<?> clazz = object.getClass();
				if (fieldName.indexOf(".") < 0) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					return field.get(object);
				}
				String properties = fieldName.substring(0, fieldName.indexOf("."));
				String nextPro = fieldName.substring(fieldName.indexOf(".") + 1);
				Field field = clazz.getDeclaredField(properties);
				field.setAccessible(true);
				return getProperties(field.get(object), nextPro);
			}
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @comment set properties by value
	 * @param object
	 * @param fieldName
	 * @param fieldValue
	 * @return boolean
	 * @throws IllegalAccessException
	 */
	public static boolean setProperties(Object object, String fieldName, Object fieldValue) {
		try {
			if (object != null) {
				Class<?> clazz = object.getClass();
				if (fieldName.indexOf(".") < 0) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					if (String.class.equals(field.getType())) {
						field.set(object, toString(fieldValue));
					} else {
						field.set(object, deepClone(fieldValue));
					}
				} else {
					String properties = fieldName.substring(0, fieldName.indexOf("."));
					String nextPro = fieldName.substring(fieldName.indexOf(".") + 1);
					Field field = clazz.getDeclaredField(properties);
					field.setAccessible(true);
					return setProperties(field.get(object), nextPro, fieldValue);
				}
			}
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @comment set properties by value
	 * @param object
	 * @param fieldName
	 * @param fieldValue
	 * @param isNewInstanceIfNull
	 * @return boolean
	 */
	public static boolean setProperties(Object object, String fieldName, Object fieldValue,
			boolean isNewInstanceIfNull) {
		try {
			if (object != null) {
				Class<?> clazz = object.getClass();
				if (fieldName.indexOf(".") < 0) {
					Field field = clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					if (String.class.equals(field.getType())) {
						field.set(object, toString(fieldValue));
					} else {
						field.set(object, deepClone(fieldValue));
					}
				} else {
					String properties = fieldName.substring(0, fieldName.indexOf("."));
					String nextPro = fieldName.substring(fieldName.indexOf(".") + 1);
					Field field = clazz.getDeclaredField(properties);
					field.setAccessible(true);
					Object nextObj = field.get(object);
					if (nextObj == null && isNewInstanceIfNull && fieldValue != null) {
						nextObj = field.getType().newInstance();
						field.set(object, nextObj);
					}
					return setProperties(nextObj, nextPro, fieldValue, isNewInstanceIfNull);
				}
			}
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (IllegalAccessException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (InstantiationException e) {
			throw new RuntimeException(
					"Cannot access property " + fieldName + " on class:" + object.getClass().getName());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @commentset properties by values
	 * @param object
	 * @param properties
	 * @return boolean
	 */
	public static boolean setProperties(Object object, PropertiesInfo properties) {
		Object[] keys = properties.getPropertieValues().keySet().toArray();
		List<Object> lst = Arrays.asList(keys);
		sortKeys(lst);
		for (Object key : lst) {
			if (!setProperties(object, key.toString(), properties.getPropertieValues().get(key.toString()))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @comment set properties by values
	 * @param object
	 * @param properties
	 * @param isNewInstanceIfNull
	 * @return boolean
	 */
	public static boolean setProperties(Object object, PropertiesInfo properties, boolean isNewInstanceIfNull) {
		Object[] keys = properties.getPropertieValues().keySet().toArray();
		List<Object> lst = Arrays.asList(keys);
		sortKeys(lst);
		for (Object key : lst) {
			if (!setProperties(object, key.toString(), properties.getPropertieValues().get(key.toString()),
					isNewInstanceIfNull)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @comment sort properties name by length
	 * @param keys
	 */
	private static void sortKeys(List<Object> keys) {
		Collections.sort(keys, new Comparator<Object>() {
			public int compare(Object s1, Object s2) {
				return String.valueOf(s1).length() - String.valueOf(s2).length();
			}
		});
	}

	/**
	 * @comment copy properties by properties name
	 * @param objTo
	 * @param objFrom
	 * @param properties
	 * @param isNewInstanceIfNull
	 * @return boolean
	 */
	public static boolean copyProperties(Object objTo, Object objFrom, PropertiesInfo properties,
			boolean isNewInstanceIfNull) {

		// add properties and values
		List<Object> lstKey = new ArrayList<Object>();
		for (Object obj : properties.getPropertieValues().keySet().toArray()) {
			lstKey.add(obj);
		}

		// add properties
		for (Object obj : properties.getProperties().keySet().toArray()) {
			lstKey.add(obj);
		}

		// sort list properties
		sortKeys(lstKey);

		// set properties value
		for (Object key : lstKey) {
			String keyStr = String.valueOf(key);
			if (properties.getPropertieValues().containsKey(keyStr)) {
				if (!setProperties(objTo, keyStr, properties.getPropertieValues().get(keyStr), isNewInstanceIfNull)) {
					return false;
				}
			} else {
				if (!setProperties(objTo, keyStr, getProperties(objFrom, properties.getProperties().get(keyStr)),
						isNewInstanceIfNull)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @comment copy properties by properties name
	 * @param objTo
	 * @param objFrom
	 * @param properties
	 * @return boolean
	 */
	public static boolean copyProperties(Object objTo, Object objFrom, PropertiesInfo properties) {

		// add properties and values
		List<Object> lstKey = new ArrayList<Object>();
		for (Object obj : properties.getPropertieValues().keySet().toArray()) {
			lstKey.add(obj);
		}

		// add key properties
		for (Object obj : properties.getProperties().keySet().toArray()) {
			lstKey.add(obj);
		}

		// sort list key
		sortKeys(lstKey);

		// set properties data
		for (Object key : lstKey) {
			String keyStr = String.valueOf(key);
			if (properties.getPropertieValues().containsKey(keyStr)) {
				if (!setProperties(objTo, keyStr, properties.getPropertieValues().get(keyStr))) {
					return false;
				}
			} else {
				if (!setProperties(objTo, keyStr, getProperties(objFrom, properties.getProperties().get(keyStr)))) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @comment copy object to object with same properties name
	 * @param objTo
	 * @param objFr
	 * @return boolean
	 */
	public static boolean copyProperties(Object objTo, Object objFr) {
		if (objTo == null || objFr == null) {
			return true;
		}

		List<String> feildNameTo = getListFieldsName(objTo);
		try {
			for (Field fieldFr : objFr.getClass().getDeclaredFields()) {
				fieldFr.setAccessible(true);
				if (Modifier.isFinal(fieldFr.getModifiers())) {
					continue;
				}

				Class<?> clazz = objTo.getClass();
				Field fieldTo = null;
				if (!feildNameTo.contains(fieldFr.getName())) {
					continue;
				}

				try {
					fieldTo = clazz.getDeclaredField(fieldFr.getName());
				} catch (SecurityException e) {
					throw new RuntimeException(
							"Cannot get property " + fieldFr.getName() + " on class:" + clazz.getName());
				} catch (NoSuchFieldException e) {
					throw new RuntimeException("No Such Field " + fieldFr.getName() + " on class:" + clazz.getName());
				}

				fieldTo.setAccessible(true);
				if (Modifier.isFinal(fieldTo.getModifiers())) {
					continue;
				}

				if (!fieldTo.getType().equals(fieldFr.getType())) {
					continue;
				}

				try {
					fieldTo.set(objTo, deepClone(fieldFr.get(objFr)));
				} catch (IllegalArgumentException e) {
					throw new RuntimeException(
							"IllegalArgument " + fieldTo.getName() + " on class:" + clazz.getName() + " invalid");
				} catch (IllegalAccessException e) {
					throw new RuntimeException("cannot access " + fieldTo.getName() + " on class:" + clazz.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @comment to empty all String property when null
	 * @param obj
	 * @return boolean
	 */
	public static boolean toEmptyProperties(Object obj) {
		try {
			if (obj != null) {
				for (Field field : obj.getClass().getDeclaredFields()) {
					field.setAccessible(true);
					if (!Modifier.isFinal(field.getModifiers())) {
						if (String.class.equals(field.getType())) {
							if (field.get(obj) == null) {
								field.set(obj, "");
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @comment This method makes a "deep clone" of any object it is given.
	 * @param object
	 * @return Object
	 */
	public static Object deepClone(Object object) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @comment get list name field
	 * @param obj
	 * @return List
	 */
	private static List<String> getListFieldsName(Object obj) {
		List<String> lst = new ArrayList<String>();
		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			lst.add(field.getName());
		}
		return lst;
	}

	/**
	 * @comment to String value
	 * @param obj
	 * @return String
	 */
	private static String toString(Object obj) {
		if (obj == null) {
			return null;
		}
		return String.valueOf(obj);
	}
}
