package com.example.demo.service;


import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;

@Service
public class EmployeeServiceImp implements EmployeeService {

	List<Employee> employees= new ArrayList<>();
	private static final AtomicLong counter = new AtomicLong(20260001);
	@Override
	public Employee save(Employee employee) {
		if(employee.getEmployeeId()==null || employee.getEmail().isEmpty()) {
			employee.setEmployeeId(String.valueOf(counter.getAndIncrement()));
		}
		employees.add(employee);
		return employee;
	}
	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}
	
	@Override
	public Employee getEmployeeById(String id) {
		        return  employees
				             .stream()
				             .filter(employee -> employee.getEmployeeId().equals(id))
				             .findFirst()
				             .orElseThrow(() -> new RuntimeException(""+"Employee not found with id "+id));
	}
	@Override
	public String deleteEmployeeById(String id) {
		Employee employee= employees.stream().filter(e->e.getEmployeeId().equalsIgnoreCase(id)).findFirst().get(); 
		employees.remove(employee);
		return "Employee deleted :"+id;
	}

}
