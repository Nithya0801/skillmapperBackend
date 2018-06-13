package com.niit.SpringProjectBackend.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpringProjectBackend.Model.Employee;
import com.niit.SpringProjectBackend.Model.Skill;

@Repository("skilldao")
@Transactional
public class Skill_Dao_Impl implements Skill_Dao{

	@Autowired
	SessionFactory sessionFact;
	
	public boolean insertSkill(Skill skill) {
		try
		{
			sessionFact.getCurrentSession().save(skill);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public Skill getSkillByEmpId(int empid)
	{
		Skill skill=(Skill)sessionFact.getCurrentSession().createQuery("from Skill where employeeid = "+empid).uniqueResult();
		return skill;
	}

	public boolean deleteSkill(int empid) {
		try
		{
			sessionFact.getCurrentSession().delete(getSkillByEmpId(empid));
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	public boolean updateSkill(Skill skill) {
		try
		{
			sessionFact.getCurrentSession().update(skill);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}

	public List<Skill> getAllSkill() {
		List<Skill> ll=sessionFact.getCurrentSession().createQuery("from Skill").list();
		return ll;
	}

	public List<Employee> getSkillByskill(String skill) {
		List<Skill> sk=sessionFact.getCurrentSession().createQuery("from Skill where skill = '"+skill+"'").list();
		List<Employee> emp=null;
		for(Skill skil:sk)
		{
			int id=skil.getEmployee().getEmployeeid();
			 emp=sessionFact.getCurrentSession().createQuery("from Employee where employeeid="+id).list();
		
		}
		return emp;
	}

}
