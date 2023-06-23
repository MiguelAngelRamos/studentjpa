package tech.awakelab.studentjpa.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.awakelab.studentjpa.model.entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Integer>{

}
