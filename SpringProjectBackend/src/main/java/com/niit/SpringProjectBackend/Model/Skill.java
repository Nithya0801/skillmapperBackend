package com.niit.SpringProjectBackend.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="skilltable")
public class Skill {

	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name="employeeid")
	@Id
	int skillid;
	public int getSkillid() {
		return skillid;
	}

	public void setSkillid(int skillid) {
		this.skillid = skillid;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeid")
	Employee employee;
	
	@Column(name="skill")
	String skill;
	
	@Column(name="voucher")
	String voucher;

	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	
	
}
