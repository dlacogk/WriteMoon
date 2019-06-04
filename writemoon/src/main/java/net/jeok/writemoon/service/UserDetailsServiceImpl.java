package net.jeok.writemoon.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.jeok.writemoon.model.Role;
import net.jeok.writemoon.model.User;
import net.jeok.writemoon.repository.UserRepository;

/**
 * 
 * ***수정하지 말아주세요*** (Spring Security의 필수 클래스)
 *
 */
@Service // 사용자 정보 처리 논리(logic) 
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * 로그인 절차
	 * 1) 아이디를 찾는다.
	 * 2) 없으면 에러 : 있으면 사용자의 역할을 가져온다.
	 * 3) 아이디, 비밀번호, 역할 목록을 UserDetail(계정정보)로 리턴한다.
	 */
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
