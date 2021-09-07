package com.api.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.demo.models.Student;

public interface StudRepository extends CrudRepository<Student, Integer> {
	public Student findById(int id);

}
