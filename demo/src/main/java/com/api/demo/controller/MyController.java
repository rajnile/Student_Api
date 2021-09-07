package com.api.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.demo.models.Student;
import com.api.demo.services.StudentService;

@RestController
public class MyController {
	@Autowired
	private StudentService service;

	@GetMapping("/students")
	public List<Student> getAllStud() {
		return this.service.getAllStudents();
	}

	@GetMapping("/students/{Id}")
	public Student getStudent(@PathVariable("Id") int Id) {

		return service.getStudentById(Id);
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {

		return this.service.addStudent(student);

	}

	@DeleteMapping("/students/{studId}")
	public void deleteStudent(@PathVariable("studId") int studId) {
		this.service.deleteStudent(studId);
	}

	@PutMapping("/students/{studId}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("studId") int studId) {
		this.service.updateStudent(student, studId);
		return student;
	}

}
