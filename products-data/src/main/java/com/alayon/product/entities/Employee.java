package com.alayon.product.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Employee {

	/*
	 * @GenericGenerator(name = "emp_id", strategy =
	 * "com.alayon.product.generator.CustomRandomIDGenerator")
	 *
	 * @GeneratedValue(generator = "emp_id")
	 */
	@Id
	@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", initialValue = 100, allocationSize = 10)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
