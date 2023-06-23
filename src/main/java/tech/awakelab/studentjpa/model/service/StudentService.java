package tech.awakelab.studentjpa.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.awakelab.studentjpa.model.entity.Student;
import tech.awakelab.studentjpa.model.repository.IStudentRepository;

@Service
public class StudentService {

	@Autowired
	private IStudentRepository studentRepository;
	
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	public Student getOne(int id) {
		return studentRepository.getOne(id);
	}
	
	public void create(Student student) {
		studentRepository.save(student);
	}
	
	public void update(Student student) {
		studentRepository.save(student);
	}
	
	public void delete(int id) {
		studentRepository.delete(studentRepository.getOne(id));
	}
}
