package jv.co.properties.main;

import java.util.Date;

import jv.co.properties.model.Student;
import jv.co.properties.utils.PropertiesInfo;
import jv.co.properties.utils.PropertiesUtil;

public class SetPropertiesMain {

	public static void main(String[] args) {

		/**
		 * ****************************<br>
		 * example 1: set properties
		 */
		Student student = new Student();

		/**
		 * we can set data to object by properties name
		 */
		PropertiesUtil.setProperties(student, "name", "Mr.Hoang");
		System.out.println(student);// "Mr.Hoang"

		/**
		 * classIF.classNumber<br>
		 * If classIF is NULL, we can set classIF.classNumber with
		 * "isNewInstanceIfNull = true" so that classIF will declare with
		 * default constructor method.
		 */
		PropertiesUtil.setProperties(student, "classIF.classNumber", "08CK01", true);
		System.out.println(student);// "08CK01"

		/**
		 * classIF.classNumber<br>
		 * If classIF is not NULL, we can set classIF.classNumber do without
		 * setting isNewInstanceIfNull
		 */
		PropertiesUtil.setProperties(student, "classIF.classNumber", "08CK02");
		System.out.println(student);

		/**
		 * example 2. set full data to student.
		 */
		student = new Student();
		PropertiesUtil.setProperties(student,
				new PropertiesInfo()//
						.addValue("id", new Integer(10001))//
						.addValue("name", "David Troc")//
						.addValue("address", " Ho Chi Minh City, Vietnam")//
						.addValue("phone", "(+84) 982 291 607")//
						.addValue("birthDay", new Date())//
		);
		System.out.println(student);

		/**
		 * *********************************************************************
		 * If you want to set data to classIF.classNumber, classIF.className,
		 * classIF.totalStudents when classIF is NULL. You can set
		 * isNewInstanceIfNull= true so that ALll sub class will be constructor.
		 */
		PropertiesUtil.setProperties(student,
				new PropertiesInfo()//
						.addValue("classIF.classNumber", "08CK03")//
						.addValue("classIF.className", "IT software")//
						.addValue("classIF.totalStudents", new Integer(20))//
				, true// isNewInstanceIfNull = true
		);
		System.out.println(student);

		/**
		 * *********************************************************************
		 * If classIF is not Null. You can set data to classIF.classNumber,
		 * classIF.className, classIF.totalStudents do without setting
		 * isNewInstanceIfNull= true.
		 */
		PropertiesUtil.setProperties(student,
				new PropertiesInfo()//
						.addValue("classIF.classNumber", "08CK04")//
						.addValue("classIF.className", "History")//
						.addValue("classIF.totalStudents", new Integer(100))//
		);
		System.out.println(student);

		/**
		 * we can add null or empty to object
		 */
		PropertiesUtil.setProperties(student,
				new PropertiesInfo()//
						.addNull("id")//
						.addEmpty("name")//
						.addNull("address")//
						.addEmpty("phone")//
						.addNull("birthDay")//
		);
		System.out.println(student);
	}
}
