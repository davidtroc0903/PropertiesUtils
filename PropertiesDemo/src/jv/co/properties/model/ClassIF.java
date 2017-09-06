package jv.co.properties.model;

import java.io.Serializable;

public class ClassIF implements Serializable {

	private static final long serialVersionUID = 1L;
	private String classNumber;
	private String className;
	private Integer totalStudents;

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(Integer totalStudents) {
		this.totalStudents = totalStudents;
	}

	@Override
	public String toString() {
		return "ClassIF [classNumber=" + classNumber + ", className=" + className + ", totalStudents=" + totalStudents
				+ "]";
	}
}