package jv.co.properties.model;

import java.util.Date;

public class Student {

	private Integer id;
	private String name;
	private String address;
	private String phone;
	private Date birthDay;
	private ClassIF classIF;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public ClassIF getClassIF() {
		return classIF;
	}

	public void setClassIF(ClassIF classIF) {
		this.classIF = classIF;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", birthDay="
				+ birthDay + ", classIF=" + classIF + "]";
	}
}
