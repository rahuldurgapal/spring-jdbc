/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.jdbc.Dao;

import com.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author rahul
 */


@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

   
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public int insert(Student student) {
        
        //insert query
        String query = "insert into student(name, city) values (?,?)";
        int result = this.jdbcTemplate.update(query,student.getName(),student.getCity());
        return result;
        
    }
    
    public int change(Student student)
    {
        //update query
        
        String query = "update student set name=?, city=? where id = ?";
        int res = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        
        return res;
    }
    
    public int delete(int id)
    {
        //delete query
        
        String query = "delete from student where id = ?";
        int res = this.jdbcTemplate.update(query,id);
        return res;
    }
    
    public Student getStudent(int id)
    {
        //selection student data
        
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,id);
        
        return student;
    }
    
    public List<Student> getAllStudent()
    {
        //selecting multiple students;
        
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query,new RowMapperImpl());
        
        return students;
    }
    
    
}
