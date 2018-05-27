package com.niit.SpringProjectBackend.DAO;

import java.util.List;

import com.niit.SpringProjectBackend.Model.Skill;

public interface Skill_Dao {

	public boolean insertSkill(Skill skill);
	public boolean deleteSkill(int empid);
	public boolean updateSkill(Skill skill);
	public List<Skill> getAllSkill();
	public Skill getSkillByEmpId(int empid);
	public List<Skill> getSkillByskill(String skill);
	
}
