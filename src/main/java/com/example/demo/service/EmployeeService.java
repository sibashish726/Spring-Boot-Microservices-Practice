package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
  Employee save(Employee employee);
  List<Employee> getAllEmployees();
  Employee getEmployeeById(String id);
  String deleteEmployeeById(String id);
}
