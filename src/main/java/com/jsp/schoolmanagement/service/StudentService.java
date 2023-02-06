package com.jsp.schoolmanagement.service;

import com.jsp.schoolmanagement.dao.StudentDao;
import com.jsp.schoolmanagement.dto.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	public Student deleteStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

	public Student updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public void getDetails() {
		studentDao.getDetails();
	}

}
