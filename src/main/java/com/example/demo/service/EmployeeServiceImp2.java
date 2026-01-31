package com.example.demo.service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeServiceImp2 implements EmployeeService {

	private static final AtomicLong counter = new AtomicLong(20260001);

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Employee save(Employee employee) {
		if (employee.getEmployeeId() == null || employee.getEmail().isEmpty()) {
			employee.setEmployeeId(String.valueOf(counter.getAndIncrement()));
		}
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		employeeRepo.save(entity);

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
		return employeeEntityList.stream().map(employeeEntity -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			return employee;

		}).collect(Collectors.toList());

	}

	@Override
	public Employee getEmployeeById(String id) {
		EmployeeEntity employeeEntity= employeeRepo.findById(id).get();
		Employee employee= new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}

	@Override
	public String deleteEmployeeById(String id) {
		 employeeRepo.deleteById(id);
		 return "Employee deleted :"+id;
	}

}
