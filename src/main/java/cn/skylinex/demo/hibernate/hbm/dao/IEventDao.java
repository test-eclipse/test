package cn.skylinex.demo.hibernate.hbm.dao;

import java.util.List;

import cn.skylinex.demo.hibernate.hbm.entity.Event;

public interface IEventDao 
{
	public void save(Event event);
	public void update(Event event);
	public void delete(Event event);
	
	public Event findOne(Long id);
	public List<Event> findAll();
	
}
