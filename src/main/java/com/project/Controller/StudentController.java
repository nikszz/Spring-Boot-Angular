package com.project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojo.Student;
import com.project.service.StudentService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping("save-student")
	public boolean saveStudent(@RequestBody Student student) {
		 return studentservice.saveStudent(student);
		
	}
	
	@GetMapping("students-list")
	public List<Student> allstudents() {
		 return studentservice.getStudents();
	}
	
	@DeleteMapping("delete-student/{student_id}")
	public void deleteStudent(@PathVariable("student_id") int student_id,Student student) {
		student.setStudent_id(student_id);
		studentservice.deleteStudent(student);
	}

	@GetMapping("student/{student_id}")
	public Optional<Student> allstudentByID(@PathVariable("student_id") int student_id,Student student) {
		System.out.println("crnt ctrl id"+student_id);
		 student.setStudent_id(student_id);
		 return this.studentservice.getStudentByID(student);
	}
	
	@PostMapping("update-student/{student_id}")
	public boolean updateStudent(@RequestBody Student student,@PathVariable("student_id") int student_id) {
		System.out.println("crnt updatectrl id"+student_id);
		student.setStudent_id(student_id);
		return studentservice.updateStudent(student);
	}

}
