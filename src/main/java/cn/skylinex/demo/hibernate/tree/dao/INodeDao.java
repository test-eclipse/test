package cn.skylinex.demo.hibernate.tree.dao;

import java.util.List;

import cn.skylinex.demo.hibernate.tree.entity.Node;

public interface INodeDao {
	public void save(Node node);
	public void update(Node node);
	public void delete(Node node);
	
	public Node findOne(Long id);
	public List<Node> findAll();
}
