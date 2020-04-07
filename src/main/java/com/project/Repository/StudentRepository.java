package com.project.Repository;


import org.springframework.data.repository.CrudRepository;

import com.project.pojo.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {


}
