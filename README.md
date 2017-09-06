# PropertiesUtils
# 1. I can get object by propertyName.
#    a. Get property: Object ClassName = PropertiesUtils.getProperties(classInfo, "className");
#    b. Get deep property: Object classAddress = PropertiesUtils.getProperties(classInfo, "address.fullAddress");
#    c. get String Value:  String ClassName = PropertiesUtils.getStringValue(classInfo, "className");
#    d. get Empty Value:   String ClassName = PropertiesUtils.getEmptyValue(classInfo, "className");
#
# 2. I can set data to object by propertyName.
#    a. Set property: PropertiesUtils.setProperties(classInfo, "className", "08Ck01");
#    b. Set deep property: PropertiesUtils.setProperties(classInfo, "address.fullAddress", "Ho Chi Minh City");
#
# 3. I can set empty when property null to all properties.
#    PropertiesUtil.toEmptyProperties(student);
#
# 4. I can copy data to object by propertyName.
#    a. copy properties to Object:
#       	 Student student = new Student();
#          PropertiesUtil.setProperties(student, new PropertiesInfo()//
#                  .addValue("id", new Integer(10001))//
#                  .addValue("name", "DavidTroc")//
#                  .addValue("address", " Ho Chi Minh City, Vietnam")//
#                  .addValue("phone", "(+84) 982 291 607")//
#                  .addValue("birthDay", new Date())//
#                  .addValue("classIF.classNumber", "08CK01")//
#                  .addValue("classIF.className", "IT software")//
#                  .addValue("classIF.totalStudents", new Integer(20))//
#              , true// isNewInstanceIfNull = true
#          );
#
#    b. copy from Object to Object:
#        Teacher teacher = new Teacher();
#		     PropertiesUtil.copyProperties(teacher, student, new PropertiesInfo()//
#				      .addValue("id", new Integer(10000))// teacher.id <= 10000
#				      .add("name")// teacher.name <= student.name
#				      .add("mobilePhone", "phone")// teacher.mobilePhone <= student.phone
#		     );
#
#   c. copy all propeties with same name from Object to Object:
#		    PropertiesUtil.copyProperties(teacher, student);
