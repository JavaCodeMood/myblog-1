package net.myblog.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * @description 权限操作的Vo类
 * @author Nicky
 * @date 2017年3月6日
 */
@Entity(name="sys_permission")
public class Permission implements Serializable {

	
	private int id;
	private String desc;
	private String name;
	private static final long serialVersionUID = 1L;
	
	private Menu menu;
	
	private Set<Operation> operations = new HashSet<Operation>();

	public Permission() {
		super();
	}   
	
	@GeneratedValue
	@Id
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToOne(targetEntity=Menu.class,cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	//@JoinColumn(name="menuId",referencedColumnName="menuId")
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@ManyToMany(targetEntity=Operation.class,cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	//@JoinTable(name="sys_permission_operation",joinColumns=@JoinColumn(name="permissionId",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="operationId",referencedColumnName="id"))
	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
}