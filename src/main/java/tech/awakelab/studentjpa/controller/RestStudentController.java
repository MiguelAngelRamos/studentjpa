package tech.awakelab.studentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.awakelab.studentjpa.model.entity.Student;
import tech.awakelab.studentjpa.model.service.StudentService;

@RestController
public class RestStudentController {

  @Autowired
  private StudentService studentService;

  @RequestMapping(value="/api/students", headers = "Accept=application/json")
  public List<Student> getStudent() {
    return studentService.getAll();
  }
}
