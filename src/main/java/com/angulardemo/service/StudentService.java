package com.angulardemo.service;

import java.util.List;

import com.angulardemo.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> findAllStudent();
	public void deleteStudentById(int id);

}
