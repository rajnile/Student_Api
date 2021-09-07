package com.api.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.demo.dao.StudRepository;
import com.api.demo.models.Student;

@Component
public class StudentService {

	@Autowired
	private StudRepository repository;

	public List<Student> getAllStudents() {
		List<Student> list = (List<Student>) this.repository.findAll();
		return list;
	}

	public Student getStudentById(int id) {

		Student student = null;
		try {
			student = this.repository.findById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;

	}

	public Student addStudent(Student student) {
		Student save = repository.save(student);
		return student;
	}

	public void deleteStudent(int id) {
		repository.deleteById(id);
	}

	public void updateStudent(Student student, int studId) {
		student.setId(studId);
		repository.save(student);

	}

}
