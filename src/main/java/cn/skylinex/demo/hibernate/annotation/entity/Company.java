package cn.skylinex.demo.hibernate.annotation.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.skylinex.demo.hibernate.annotation.common.entity.BaseEntity;

@Entity
@Table(name="t_company")
public class Company extends BaseEntity<Long>
{
	private String companyName;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="company",fetch=FetchType.LAZY)
	private List<Flight> flights = new ArrayList<Flight>();
	
	public Company() {}
	public Company(String companyName) {
		super();
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + "]";
	}
}
