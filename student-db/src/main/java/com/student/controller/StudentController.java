package com.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.domain.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public void createStudent(@RequestBody Student student) {

		studentService.createStudent(student);
	}

	@GetMapping("/findByStudentId/{customerId}")
	public Student findByStudentId(@PathVariable int studentId) {
		Student student = new Student();
		student = studentService.findByStudentId(studentId);
		return student;
	}

	@GetMapping("/findByFirstName/{firstName}")
	public Student findByFirstName(@PathVariable String firstName) {
		Student student = new Student();
		student = studentService.findByStudentFirstName(firstName);

		return student;
	}

	@GetMapping("/findAllStudents")
	public List<Student> findAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentService.findAllStudents();
		return studentList;
	}

	@DeleteMapping("delete/{customerId}")
	public void deleteCustomerById(@PathVariable int customerId) {

		studentService.deleteStudent(customerId);

	}

}
