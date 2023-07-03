package tech.awakelab.studentjpa.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
  
    private static final Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	// http://localhost:8080/students
	@RequestMapping(value="/students", method = RequestMethod.GET)
	public ModelAndView mostrarStudents() {
	    logger.info("Obteniendo todos los estudiantes de la base de datos");
		List<Student> students = studentService.getAll(); // select * from "student";
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


	// Para el formulario de login
	
	@RequestMapping(value="/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/error")
	public ModelAndView errorLogin() {
		return new ModelAndView("login", "error", "true");
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logout() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return new ModelAndView("redirect:/login?logout");
	}
	

}
