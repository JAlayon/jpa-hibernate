package com.alayon.product.entities;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @TableGenerator(name = "employee_gen",
                    table="id_gen",
                    pkColumnName = "gen_name",
                    valueColumnName = "gen_val",
                    allocationSize = 100)
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
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
