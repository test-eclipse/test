package cn.skylinex.demo.hibernate.annotation.common.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<PK extends Serializable> 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private PK id;
	//系统维护公共属性
	//创建人
	//创建时间
	//修改人
	//最后修改时间
	
	//数据权限标识
	
	public PK getId() {
		return id;
	}
	
	public void setId(PK id) {
		this.id = id;
	}
}
