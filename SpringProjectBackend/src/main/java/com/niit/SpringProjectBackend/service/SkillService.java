package com.niit.SpringProjectBackend.service;

import java.util.List;

import com.niit.SpringProjectBackend.Model.Employee;
import com.niit.SpringProjectBackend.Model.Skill;

public interface SkillService {

	public boolean insertSkillService(Skill skill);
	public boolean deleteSkillService(int empid);
	public boolean updateSkillService(Skill skill);
	public List<Skill> getAllSkillService();
	public Skill getSkillByEmpIdService(int empid);
	public List<Employee> getSkillService(String skill);
}
