package com.niit.SpringProjectBackend.DAO;

import java.util.List;

import com.niit.SpringProjectBackend.Model.Employee;

public interface Employee_Dao {

	public boolean registerEmployee(Employee employee);
	public boolean deleteEmployee(int employee_id);
	public Employee getEmployeeById(int employee_id);
	public List<Employee>  fetchAllEmployee();
	public boolean updateEmployee(Employee employee);
	
}
