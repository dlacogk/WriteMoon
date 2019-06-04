package net.jeok.writemoon.service;

import net.jeok.writemoon.model.User;

/**
 * 회원 가입 인터페이스
 */
public interface UserService {
	
	/** 
	 * 계정 저장
	 */
    void save(User user);

    /**
     * 아이디로 사용자 객체 불러오기
     * @param username (아이디)
     * @return 사용자 정보
     */
    User findByUsername(String username);
}