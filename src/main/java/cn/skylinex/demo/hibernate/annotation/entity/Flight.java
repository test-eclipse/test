package cn.skylinex.demo.hibernate.annotation.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.skylinex.demo.hibernate.annotation.common.entity.BaseEntity;

@Entity
@Table(name="t_flight")
public class Flight extends BaseEntity<Long>
{
	private String flightCode;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)//多对一级联删除，使用ALL建议先移除关系（update）再delete
	private Company company;

	public String getFlightCode() {
		return flightCode;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Flight [flightCode=" + flightCode + "]";
	}
}
