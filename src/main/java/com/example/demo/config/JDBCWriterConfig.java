package com.example.demo.config;

import com.example.demo.entity.Employee;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;



@Configuration
public class JDBCWriterConfig {
    @Bean
    public JdbcBatchItemWriter<Employee> employeeWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Employee>()
                .dataSource(dataSource)
                .sql("INSERT INTO employee (emp_id, name, address, salary) VALUES (:empId, :name, :address, :salary)")
                .beanMapped()
                .build();
    }
}
