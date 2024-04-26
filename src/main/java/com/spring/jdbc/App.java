    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.jdbc;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author rahul
 */
public class App {
    
    public static void main(String[] args) 
    {
        System.out.println("My Program started.........");
        //spring jdbc=> JdbcTemplate
        
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        StudentDao s1 = context.getBean("studentDao",StudentDao.class);
        
        //insert row
//        Student student = new Student(5,"Kumar Aniket","Dispur");
//        int res =  s1.insert(student);

         //update row
//          Student student = new Student(3,"Aman Yadav","Lucknow");
//          int res = s1.change(student);
//        
//           System.out.println("Data Changed "+res);

            //Delet row
//            int res = s1.delete(3);
//            
//            System.out.println("Data Delete "+res);

//            Student student = s1.getStudent(1);
//            System.out.println(student);

             List<Student> students = s1.getAllStudent();
             for(Student s: students)
             {
                 System.out.println(s);
             }
    }
 }



