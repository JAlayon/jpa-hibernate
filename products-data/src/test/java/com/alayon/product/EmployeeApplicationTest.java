package com.alayon.product;

import com.alayon.product.entities.Employee;
import com.alayon.product.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class EmployeeApplicationTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void testTableGenerator(){
        var employee1 = new Employee();
        employee1.setName("Employee-1");
        var employee2 = new Employee();
        employee2.setName("Employee-2");

        final Iterable<Employee> employees = employeeRepository.saveAll(Arrays.asList(employee1, employee2));

        employees.forEach(e -> System.out.println(e));


    }
}
