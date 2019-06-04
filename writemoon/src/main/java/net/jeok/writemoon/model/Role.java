package net.jeok.writemoon.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;;

/**
 * 사용자의 권한을 설정하는 역할 모델(model)
 */
@Entity // 객체
@Table(name="role") // db에 테이블명이 role
public class Role {
	@Id // 아래는 primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 자동증가 (+1)
	private Long id;
	
	private String name; // 역할 명

	@ManyToMany(mappedBy="roles") // 양방향 (객채가 두 개 있을 때 사용)
	private Set<User> users;
	
/**
 * 기본적인 getter/setter
 * @param id, name, users
 */
	public void setId(Long id) {this.id = id;}
	public Long getId() {return id;}
	public void setName(String name) {this.name=name;}
	public String getName() {return name;}
	public void setUsers(Set<User> users) {this.users=users;}
	public Set<User> getUsers() {return users;}

}
