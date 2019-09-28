package com.angulardemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.angulardemo.model.Student;
import com.angulardemo.service.StudentService;

@RestController
public class StudentController {
	@RequestMapping(value="/")
	public ModelAndView index()
	{
		ModelAndView index=new ModelAndView("student");
		return index;
	}
	
	@Autowired
	StudentService studentService;
	@RequestMapping(value="/savestudent",method=RequestMethod.POST)
	public Student addStudent(@RequestBody Student student)
	{
		System.out.println(student.getId());
		return studentService.saveStudent(student);
		
	}
	@RequestMapping(value="/allStudentList",method=RequestMethod.POST)
	public List<Student> getAllStudent() {
		return studentService.findAllStudent();
	}
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.POST)
	public void deleteStudent(@PathVariable("id") int id)
	{
		 
		  studentService.deleteStudentById(id);
	}
}
