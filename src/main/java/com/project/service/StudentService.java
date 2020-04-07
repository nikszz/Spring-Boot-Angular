package com.project.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.Repository.StudentRepository;
import com.project.pojo.Student;


@Service
@Transactional
public class StudentService{
 
	@Autowired
	private StudentRepository repo;
	
	public boolean saveStudent(Student student) {
		return repo.save(student) != null;
	}

	public List<Student> getStudents() {
		return (List<Student>) repo.findAll();
	}

	public void deleteStudent(Student student) {
		repo.delete(student);
	}

	public Optional<Student> getStudentByID(Student student) {
		System.out.println("crnt servce id" + student.getStudent_id());
		return repo.findById(student.getStudent_id());
	}
	
	public boolean updateStudent(Student student) {
		return repo.save(student) != null;
	}

}
