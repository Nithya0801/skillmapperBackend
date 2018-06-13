package com.niit.SpringProjectBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.SpringProjectBackend.DAO.Skill_Dao;
import com.niit.SpringProjectBackend.Model.Employee;
import com.niit.SpringProjectBackend.Model.Skill;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	Skill_Dao skilldao;
	
	
	public boolean insertSkillService(Skill skill) {
		
		return (skilldao.insertSkill(skill));
	}

	public boolean deleteSkillService(int empid) {
		// TODO Auto-generated method stub
		return (skilldao.deleteSkill(empid));
	}

	public boolean updateSkillService(Skill skill) {
		// TODO Auto-generated method stub
		return (skilldao.updateSkill(skill));
	}

	public List<Skill> getAllSkillService() {
		// TODO Auto-generated method stub
		return (skilldao.getAllSkill());
	}

	public Skill getSkillByEmpIdService(int empid) {
		// TODO Auto-generated method stub
		return (skilldao.getSkillByEmpId(empid));
	}
	
	public List<Employee> getSkillService(String skill)
	{
		return (skilldao.getSkillByskill(skill));
	}

}
