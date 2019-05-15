package cn.skylinex.demo.hibernate.hbm;

import java.util.Date;

import org.junit.Test;

import cn.skylinex.demo.hibernate.hbm.dao.EventDao;
import cn.skylinex.demo.hibernate.hbm.dao.IEventDao;
import cn.skylinex.demo.hibernate.hbm.entity.Event;

public class TestHBM {
	@Test
	public void testHBM() {
		IEventDao eventDao = new EventDao();

		for (int i = 0; i < 100; i++) {
			Event event = new Event();
			event.setTitle("标题"+i);
			event.setDate(new Date());
			eventDao.save(event);
		}
		
		Event e = eventDao.findOne(1L);
		System.out.println(e);
	}
}
