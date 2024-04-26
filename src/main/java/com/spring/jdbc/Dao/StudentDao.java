/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.jdbc.Dao;

import com.spring.jdbc.entities.Student;
import java.util.List;

/**
 *
 * @author rahul
 */
public interface StudentDao {
    
    public int insert(Student student);
    public int change(Student student);
    public int delete(int id);
    public Student getStudent(int id);
    public List<Student> getAllStudent();
    
}
