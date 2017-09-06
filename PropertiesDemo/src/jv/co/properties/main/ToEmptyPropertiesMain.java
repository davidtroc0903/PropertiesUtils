package jv.co.properties.main;

import jv.co.properties.model.Student;
import jv.co.properties.utils.PropertiesUtil;

public class ToEmptyPropertiesMain {

	public static void main(String[] args) {

		// to empty all String null value
		Student student = new Student();
		PropertiesUtil.toEmptyProperties(student);
		System.out.println(student);
	}
}
