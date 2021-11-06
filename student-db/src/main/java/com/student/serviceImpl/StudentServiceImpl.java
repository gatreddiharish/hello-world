package com.student.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.domain.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
@Transactional
public  class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void createStudent(Student student) {
		studentRepository.save(student);

	}

	@Override
	public Student findByStudentId(int studentId) {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		Student student = new Student();

		if (optionalStudent.isPresent()) {
			student = optionalStudent.get();
		}
		return student;

	}

	@Override
	public Student findByStudentFirstName(String firstName) {
		Student student = new Student();
		student = studentRepository.findByFirstName(firstName);
		return student;
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentRepository.findAll();
		return studentList;

	}
}

