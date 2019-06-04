package net.jeok.writemoon.service;

/**
 * 현재 아이디 / 자동 아이디 인터페이스
 */
public interface SecurityService {
	
	/**
	 * @return 현재 사용자
	 */
	String findLoggedInUsername();
	
	/**
	 * 회원 가입 후 자동 로그인 시 사용
	 */
	void autoLogin(String username, String password);

}
