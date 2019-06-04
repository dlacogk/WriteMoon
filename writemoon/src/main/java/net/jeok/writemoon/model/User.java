package net.jeok.writemoon.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 사용자 정보 모델(model)
 * TODO: 나이, 성별 등 추가하기
 */
@Entity // 객체
@Table(name="user") // DB 테이블명(명="user")
public class User {
	
	@Id // 아래는 primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY) // 자동증가 (+1)
	private Long id;
	
	private String username; // 아이디
	private String password; // 비밀번호
	
	@Transient // DB에 저장하지 않음
	private String passwordConfirm; // 비밀번호 재확인
	
	@ManyToMany // 양방향 (객채가 두 개 있을 때 사용)
	private Set<Role> roles;
	
/**
 * 기본적인 getter/setter
 * @param id, username, password, passwordConfirm, roles
 */
	public void setId(Long id) {this.id = id;}
	public Long getId() {return id;}
	public void setUsername(String username) {this.username=username;}
	public String getUsername() {return username;}
	public void setPassword(String password) {this.password=password;}
	public String getPassword() {return password;}
	public void setPasswordConfirm(String passwordConfirm) {this.passwordConfirm=passwordConfirm;}
	public String getPasswordConfirm() {return passwordConfirm;}
	public void setRoles(Set<Role> roles) {this.roles = roles;}
	public Set<Role> getRoles() {return roles;}
	
}
