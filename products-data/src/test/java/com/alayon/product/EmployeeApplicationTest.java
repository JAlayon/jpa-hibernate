package com.alayon.product;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alayon.product.entities.Employee;
import com.alayon.product.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeApplicationTest {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void testTableGenerator() {
		final var employee1 = new Employee();
		employee1.setName("Employee-1");
		final var employee2 = new Employee();
		employee2.setName("Employee-2");
		final var employee3 = new Employee();
		employee3.setName("Employee-3");

		final Iterable<Employee> employees = employeeRepository.saveAll(Arrays.asList(employee1, employee2, employee3));

		employees.forEach(e -> System.out.println(e));

	}
}
