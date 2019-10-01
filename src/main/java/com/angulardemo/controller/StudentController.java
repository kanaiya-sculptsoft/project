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

import com.angulardemo.model.Country;
import com.angulardemo.model.Student;
import com.angulardemo.service.CountryService;
import com.angulardemo.service.StudentService;

@RestController
public class StudentController {
	@RequestMapping(value="/")
	public ModelAndView index()
	{
		ModelAndView index=new ModelAndView("register");
		return index;
	}
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CountryService countryService;
	

	@RequestMapping(value="/allCountrylist",method=RequestMethod.POST)
	public List<Country> listCountry()
	{
	   return countryService.findAllCountry();	
	}
	
	@RequestMapping(value="/savestudent",method=RequestMethod.POST)
	public Student addStudent(@RequestBody Student student)
	{
		
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
