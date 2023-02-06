package com.jsp.schoolmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.schoolmanagement.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Student saveStudent(Student student) {
		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		System.out.println("Student Inserted");
		return student;
	}

	public Student deleteStudent(Student student) {
		Student student2 = entityManager.find(Student.class, student.getId());
		entityTransaction.begin();
		entityManager.remove(student2);
		entityTransaction.commit();
		System.out.println("Student deleted");
		return student2;
	}

	public Student updateStudent(Student student) {
		Student student2 = entityManager.find(Student.class, student.getId());
		if (student2 != null) {
			student2.setName(student.getName());
			student2.setEmail(student.getEmail());
			student2.setBalance(student2.getBalance());
			student2.setBalance(student.getFeespaid());

			entityTransaction.begin();
			entityManager.merge(student2);
			entityTransaction.commit();
			System.out.println("student updated");
		} else
			System.out.println("student not found");
		return student2;
	}

	public void getDetails() {
		String sql = "select s from Student s";
		Query query = entityManager.createQuery(sql);
		List<Student> students = query.getResultList();
		for (Student student : students) {
			System.out.println("===========================");
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getEmail());
			System.out.println(student.getPhno());
			System.out.println(student.getFeespaid());
			System.out.println(student.getBalance());
		}
	}
}
