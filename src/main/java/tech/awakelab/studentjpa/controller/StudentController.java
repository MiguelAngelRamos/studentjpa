package tech.awakelab.studentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView showEditForm(@PathVariable("id") int id) {
	    ModelAndView editStudent = new ModelAndView("edit-student");
	    Student student = studentService.getOne(id); //Obtienes el estudiante desde tu servicio
	    editStudent.addObject("student", student); //Agregas el estudiante al modelo
	    return editStudent;
	}

	@RequestMapping(value = "/student/edit", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student) {
	    studentService.update(student); // Actualizas el estudiante en tu servicio
	    return "redirect:/students"; // Rediriges al usuario a la lista de estudiantes
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable("id") int id) {
	    studentService.delete(id); // Eliminas el estudiante desde tu servicio
	    return "redirect:/students"; // Rediriges al usuario a la lista de estudiantes
	}


	

}
