package com.angulardemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angulardemo.model.Student;
import com.angulardemo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository; 

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public List<Student> findAllStudent(){
		
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
		
		
	}
	

}
