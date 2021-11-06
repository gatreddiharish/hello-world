package com.student.service;

import java.util.List;

import com.student.domain.Student;

public interface StudentService {

	public void createStudent(Student student);

	public Student findByStudentId(int studentId);

	public Student findByStudentFirstName(String firstName);

	public void deleteStudent(int studentId);

	public List<Student> findAllStudents();
}
