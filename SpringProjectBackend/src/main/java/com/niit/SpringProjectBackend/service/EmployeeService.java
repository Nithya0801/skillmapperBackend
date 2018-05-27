package com.niit.SpringProjectBackend.service;

import java.util.List;

import com.niit.SpringProjectBackend.Model.Employee;

public interface EmployeeService {

	public boolean registerService(Employee employee);
	public boolean deleteService(int employee_id);
	public Employee getEmployeeService(int employeeid);
	public boolean updateService(Employee employee);
	public List<Employee> listService();
}
