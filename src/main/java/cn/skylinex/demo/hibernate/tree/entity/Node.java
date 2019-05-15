package cn.skylinex.demo.hibernate.tree.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_tree")
public class Node {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(length=32)
	private String category;
	@ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private Node parent;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="parent",cascade=CascadeType.ALL)
	private List<Node> child=new ArrayList<Node>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public List<Node> getChild() {
		return child;
	}
	public void setChild(List<Node> child) {
		this.child = child;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", category=" + category + "]";
	}
}
