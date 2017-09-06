package jv.co.properties.main;

import java.util.Date;

import jv.co.properties.model.ClassIF;
import jv.co.properties.model.Student;
import jv.co.properties.model.Teacher;
import jv.co.properties.utils.PropertiesInfo;
import jv.co.properties.utils.PropertiesUtil;

public class CopyPropertiesMain {

	public static void main(String[] args) {

		/**
		 * set full data to student.
		 */
		Teacher teacher = new Teacher();
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
		System.out.println(teacher);

		/**
		 * example 1.
		 */
		teacher = new Teacher();
		PropertiesUtil.copyProperties(teacher, student, new PropertiesInfo()//
				.addValue("id", new Integer(10000))// teacher.id <= 10000
				.add("name")// teacher.name <= student.name
				.add("mobilePhone", "phone")// teacher.mobilePhone <= student.phone
		);
		System.out.println(teacher);
		
		/**
		 * example 2.<br>
		 * When teacher.classIF is null, We can set teacher.classIF.classNumber by setting "isNewInstanceIfNull = true"
		 * so that classIF can declare with default constructor method.
		 */
		teacher = new Teacher();
		PropertiesUtil.copyProperties(teacher, student, new PropertiesInfo()//
				.add("classIF.classNumber")// teacher.classIF.classNumber <= student.classIF.classNumber
				,true // isNewInstanceIfNull = true
		);
		
		// OR
		teacher = new Teacher();
		PropertiesUtil.copyProperties(teacher, student, new PropertiesInfo()//
				.add("classIF.classNumber", "classIF.classNumber")// teacher.classIF.classNumber <= student.classIF.classNumber
				,true // isNewInstanceIfNull = true
		);
		System.out.println(teacher);
		
		
		/**
		 * example 2.<br>
		 * When teacher.classIF is not null, We can set teacher.classIF.classNumber 
		 * do without setting "isNewInstanceIfNull = true"
		 */
		teacher = new Teacher();
		teacher.setClassIF(new ClassIF());// classIF is not null
		PropertiesUtil.copyProperties(teacher, student, new PropertiesInfo()//
				.add("classIF.classNumber")// teacher.classIF.classNumber <= student.classIF.classNumber
		);
		
		// OR
		teacher = new Teacher();
		teacher.setClassIF(new ClassIF());// classIF is not null
		PropertiesUtil.copyProperties(teacher, student, new PropertiesInfo()//
				.add("classIF.classNumber", "classIF.classNumber")// teacher.classIF.classNumber <= student.classIF.classNumber
		);
		System.out.println(teacher);
		
		/**
		 * example 2.<br>
		 * we can copy all properties with same name from student to teacher
		 */
		teacher = new Teacher();
		PropertiesUtil.copyProperties(teacher, student);
		// teacher.mobilePhone is NULL because student don't have "mobilePhone" variable.
		// teacher.classIF <= student.classIF: when classIF is Serializable. 
		System.out.println(teacher);
	}
}
