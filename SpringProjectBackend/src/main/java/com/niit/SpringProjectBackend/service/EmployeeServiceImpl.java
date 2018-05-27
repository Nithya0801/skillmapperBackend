package com.niit.SpringProjectBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SpringProjectBackend.DAO.Employee_Dao;
import com.niit.SpringProjectBackend.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	Employee_Dao employeedao;
	public boolean registerService(Employee employee) {
		// TODO Auto-generated method stub
		return (employeedao.registerEmployee(employee));
	}

	public boolean deleteService(int employee_id) {
		return (employeedao.deleteEmployee(employee_id));
	}
	
	public Employee getEmployeeService(int employeeid)
	{
		return employeedao.getEmployeeById(employeeid);
	}
	
	public boolean updateService(Employee employee)
	{
		return employeedao.updateEmployee(employee);
	}
	
	public List<Employee> listService()
	{
		return employeedao.fetchAllEmployee();
	}
}
