package com.example.demo.config;

import com.example.demo.entity.Employee;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@StepScope
public class CsvReaderConfig  {
    private Iterator<Employee> iterator;
    public FlatFileItemReader<Employee> ExcelEmployeeReader(@Value("${file.input}") String filePath) {
        FlatFileItemReader<Employee> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource(filePath));
        reader.setLinesToSkip(1); // skip header
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("empId", "name", "address", "salary"); // put the actual column name
                setDelimiter(",");
            }});
            setFieldSetMapper(fieldSet -> {
                Employee emp = new Employee();
                emp.setEmpId(fieldSet.readInt("empId"));
                emp.setName(fieldSet.readString("name"));
                emp.setAddress(fieldSet.readString("address"));
                emp.setSalary(fieldSet.readDouble("salary"));
                return emp;
            });
        }});
        return reader;
    }
}
