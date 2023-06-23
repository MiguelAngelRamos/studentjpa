package tech.awakelab.studentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tech.awakelab.studentjpa.model.entity.Student;
import tech.awakelab.studentjpa.model.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ModelAndView mostrarStudents() {
		List<Student> students = studentService.getAll(); // Select 
		return new ModelAndView("students", "students", students);
	}
}
