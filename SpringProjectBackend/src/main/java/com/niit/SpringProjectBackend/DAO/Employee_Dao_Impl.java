package com.niit.SpringProjectBackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpringProjectBackend.Model.Employee;

@Repository("employeedao")
@Transactional
public class Employee_Dao_Impl implements Employee_Dao{

	@Autowired
	SessionFactory sessionFact;
	
	public boolean registerEmployee(Employee employee) {
		try
		{
		
		sessionFact.getCurrentSession().save(employee);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteEmployee(int employee_id) {
		try
		{
			sessionFact.getCurrentSession().delete(getEmployeeById(employee_id));
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public Employee getEmployeeById(int employee_id) {
		
		try
		{
			Employee employee=(Employee)sessionFact.getCurrentSession().createQuery("from Employee where employeeid="+employee_id).uniqueResult();
			return employee;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<Employee> fetchAllEmployee() {
		List<Employee> fetch=sessionFact.getCurrentSession().createQuery("from Employee").list();
		return fetch;
	}

	public boolean updateEmployee(Employee employee) {
		try
		{
		sessionFact.getCurrentSession().update(employee);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	

}
