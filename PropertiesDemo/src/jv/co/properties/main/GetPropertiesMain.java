package jv.co.properties.main;

import java.util.Date;

import jv.co.properties.model.ClassIF;
import jv.co.properties.model.Student;
import jv.co.properties.utils.PropertiesInfo;
import jv.co.properties.utils.PropertiesUtil;

public class GetPropertiesMain {

	public static void main(String[] args) {

		/**
		 * set full data to student.
		 */
		Student student = new Student();
		PropertiesUtil.setProperties(student,
				new PropertiesInfo()//
						.addValue("id", new Integer(10001))//
						.addValue("name", "DavidTroc")//
						.addValue("address", " Ho Chi Minh City, Vietnam")//
						.addValue("phone", "(+84) 982 291 607")//
						.addValue("birthDay", new Date())//
						.addValue("classIF.classNumber", "08CK01")//
						.addValue("classIF.className", "IT software")//
						.addValue("classIF.totalStudents", new Integer(20))//
				, true// isNewInstanceIfNull = true
		);

		/**
		 * ******************************************************<br>
		 * get properties this method get object by property name
		 */
		String name = (String) PropertiesUtil.getProperties(student, "name");// "DavidTroc"
		String classNumber = (String) PropertiesUtil.getProperties(student, "classIF.classNumber");// "08CK01"

		/**
		 * "classIF is a ClassIF"
		 */
		ClassIF classIF = (ClassIF) PropertiesUtil.getProperties(student, "classIF");

		/**
		 * this method convert object to String value<br>
		 * when object is null, return null
		 */
		String totalStudents = PropertiesUtil.getStringValue(student, "classIF.totalStudents");// "20"
		PropertiesUtil.setProperties(student, "classIF.totalStudents", null);
		String nullTotalStudents = PropertiesUtil.getStringValue(student, "classIF.totalStudents");// null

		/**
		 * this method convert object to String value<br>
		 * If object is null, return empty<br>
		 * else return String value
		 */
		PropertiesUtil.setProperties(student, "classIF.totalStudents", new Integer(30));
		totalStudents = PropertiesUtil.getEmptyValue(student, "classIF.totalStudents");// "30"
		PropertiesUtil.setProperties(student, "classIF.totalStudents", null);
		String emptyTotalStudents = PropertiesUtil.getEmptyValue(student, "classIF.totalStudents");// ""

	}
}
