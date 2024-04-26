/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.jdbc;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImpl;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author rahul
 */

@Configuration
@ComponentScan(basePackages={"com.spring.jdbc.Dao"})
public class JdbcConfig {
    
    @Bean("ds")
    public DataSource getDataSource()
    {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        ds.setUsername("root");
        ds.setPassword("");
        
        return ds;
    }
    
    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        
        return jdbcTemplate;
    }
    
//    @Bean("studentDao")
//    public StudentDao getStudentDao()
//    {
//        StudentDaoImpl studentDao = new StudentDaoImpl();
//        studentDao.setJdbcTemplate(getTemplate());
//        return studentDao;
//    }
}
