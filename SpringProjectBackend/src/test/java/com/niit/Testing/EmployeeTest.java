package com.niit.Testing;

import static org.junit.Assert.*;

import java.util.List;

//import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SpringProjectBackend.Model.Employee;
import com.niit.SpringProjectBackend.config.ProjectConfiguration;
import com.niit.SpringProjectBackend.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ProjectConfiguration.class) 
public class EmployeeTest {

	@Autowired
	EmployeeService empService;
	
	Employee employee;
	
	@Before
	public void setUp() throws Exception {
		employee = new Employee();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void registertestPositive() {
		
		employee.setEmployeeid(135);
		
		employee.setAddress("Trichy");
		employee.setDesgn("AL");
		employee.setDob("01-01-1990");
		employee.setDoj("11-01-2014");
		employee.setEmployeename("Maddy");
		employee.setGender("Male");
		
		employee.setPhoneno("8890123456");
		employee.setQualification("B.Tech");
		
		
		assertEquals("Success",true,empService.registerService(employee));
		
		
	}
	
	@Test(expected=org.springframework.dao.DataIntegrityViolationException.class)
	public void registertestNull()
	{
		employee.setEmployeeid(189);
		employee.setAddress("Madurai");
		assertEquals("failure null value",false,empService.registerService(employee));
		
	}
	
	/*@Test
	public void registertestNegativeConstraint() {
		//long phno=(long)8007400000;
		//java.sql.Date date=new java.sql.Date(0000-00-00);
		
		
		employee.setAddress("Trichy");
		employee.setDesgn("AL");
		employee.setDob("01-01-1990");
		employee.setDoj("11-01-2014");
		employee.setEmployeename("Maddy");
		employee.setGender("Male");
		
		employee.setPhoneno("8890123456");
		employee.setQualification("B.Tech");
		
		employee.setEmployeeid(111);
		assertEquals("Success",false,empService.registerService(employee));
		
		
	}
	*/																																																														
	@Test
	public void registertestNegative() {
				
		employee=null;
		assertEquals("Not a Null Values",true,empService.registerService(employee));
		
	}
	
	@Test
	public void deleteTestPositive()
	{
		//empService.deleteService(101);
		assertEquals("Found and  deleted",true,empService.deleteService(134));
	}
	
	@Test
	public void deleteTestNegative()
	{
		//empService.deleteService(101);
		assertEquals("Not Found",true,empService.deleteService(101));
	}


	@Test
	public void getSingleTestPositive()
	{
		Employee emp=empService.getEmployeeService(111);
		assertEquals("Success",true,emp!=null);
	}
	
	@Test
	public void getSingleTestNegative()
	{
		Employee emp=empService.getEmployeeService(101);
		assertEquals("failure",true,emp!=null);
	}
	
	@Test
	public void updateTest()
	{
		Employee employee=empService.getEmployeeService(141);
		if(employee!=null)
		{
		employee.setQualification("BSC");
		employee.setPhoneno("9952377520");
		assertEquals("Successfully Updated", true,empService.updateService(employee));
		}
		else
		{
			assertEquals("Id Not found in database", true,empService.updateService(employee));
		}
	}
	
	
	/*@Test
	public void fetchAllTestNegative()
	{
		List<Employee> emp=empService.listService();
		assertEquals("FetchRecord",false,emp.isEmpty());
	}*/
	
	@Test
	public void fetchAllTestPositive()
	{
		List<Employee> emp=empService.listService();
		assertEquals("FetchRecord",false,emp.isEmpty());
	}
}
