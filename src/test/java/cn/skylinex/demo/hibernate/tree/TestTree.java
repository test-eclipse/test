package cn.skylinex.demo.hibernate.tree;

import java.util.List;

import org.junit.Test;

import cn.skylinex.demo.hibernate.tree.dao.INodeDao;
import cn.skylinex.demo.hibernate.tree.dao.NodeDao;
import cn.skylinex.demo.hibernate.tree.entity.Node;

public class TestTree {
	@Test
	public void testSave() {
		INodeDao dao=new NodeDao();
		
		Node root=new Node();
		root.setParent(null);
		root.setCategory("根");
		
		Node node1=new Node();
		node1.setCategory("哺乳纲");
		node1.setParent(root);
		root.getChild().add(node1);

		Node node2=new Node();
		node2.setParent(node1);
		node2.setCategory("食肉目");
		Node node3=new Node();
		node3.setParent(node1);
		node3.setCategory("有袋目");
		Node node4=new Node();
		node4.setParent(node1);
		node4.setCategory("灵长目");
		node1.getChild().add(node2);
		node1.getChild().add(node3);
		node1.getChild().add(node4);
		
		Node node5=new Node();
		node5.setParent(node2);
		node5.setCategory("犬科");
		Node node6=new Node();
		node6.setParent(node2);
		node6.setCategory("猫科");
		node2.getChild().add(node5);
		node2.getChild().add(node6);
		
		Node node7=new Node();
		node7.setParent(node3);
		node7.setCategory("负鼠科");
		Node node8=new Node();
		node8.setParent(node3);
		node8.setCategory("袋鼠科");
		node3.getChild().add(node7);
		node3.getChild().add(node8);
		
		Node node9=new Node();
		node9.setParent(node4);
		node9.setCategory("长臂猿科");
		Node node10=new Node();
		node10.setParent(node4);
		node10.setCategory("猩猩科");
		node4.getChild().add(node9);
		node4.getChild().add(node10);
		
		dao.save(node1);
	}
	@Test
	public void testDelete() {
		findAll();
		
		long id=3L;
		INodeDao dao=new NodeDao();
		Node node=dao.findOne(id);
		Node grande=node.getParent();
		List<Node> grandChild=node.getChild();
		for(Node tempNode:grandChild) {
			tempNode.setParent(grande);
		}
		node.setParent(null);
		
		dao.update(node);
		node=dao.findOne(id);
		dao.delete(node);
		
		findAll();
	}
	@Test
	public void findAll() {
		find(1L);
	}
	public void find(long id) {
		INodeDao dao=new NodeDao();
		Node node=dao.findOne(id);
		System.out.println(node.getCategory());
		print(node.getChild(),1);
	}
	public void print(List<Node> list,int deep) {
		if(list.size()<1) {
			return;
		}
		for(Node node:list) {
			for(int i=0;i<deep;i++) {
				System.out.print("\t");
			}
			System.out.println(node.getCategory());
			print(node.getChild(),deep+1);
		}
	}
}
