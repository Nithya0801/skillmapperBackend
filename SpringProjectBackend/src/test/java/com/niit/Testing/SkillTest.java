package com.niit.Testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.SpringProjectBackend.Model.Employee;
import com.niit.SpringProjectBackend.Model.Skill;
import com.niit.SpringProjectBackend.config.ProjectConfiguration;
import com.niit.SpringProjectBackend.service.EmployeeService;
import com.niit.SpringProjectBackend.service.SkillService;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=ProjectConfiguration.class) 
public class SkillTest {

	@Autowired
	SkillService skillService;
	
	@Autowired
	EmployeeService empservice;
	
	Skill skill;
	@Before
	public void setUp() throws Exception {
		skill = new Skill();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void addSkillTest() {
		
		Employee e=empservice.getEmployeeService(11);
		boolean b=false;
		if(e!=null)
		{
		skill.setSkillid(3);
		skill.setEmployee(e);
		skill.setSkill("J2ee");
		skill.setVoucher("none");
		 b=skillService.insertSkillService(skill);
		}
		
		
		assertEquals("Success", true,b);
	}
	
	@Test
	public void getSkillByEmpIdTest()
	{
	Skill s=skillService.getSkillByEmpIdService(121);
		//for(Skill s:l)
			System.out.println(s.getEmployee().getEmployeeid()+"\t"+s.getEmployee().getEmployeename()+"\t"+s.getEmployee().getPhoneno()+"\t"+s.getSkill());
		
		assertEquals("No List",true,s!=null);
	}

	@Test
	public void updateSkillService()
	{
		Employee e=empservice.getEmployeeService(121);
		boolean b=false;
		if(e!=null)
		{
		skill.setSkillid(3);
		skill.setEmployee(e);
		skill.setSkill("Java");
		skill.setVoucher("none");
		 b=skillService.updateSkillService(skill);
		}
	}
}
