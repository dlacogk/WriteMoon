package net.jeok.writemoon.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * 현재 아이디, 자동 로그인의 구현
 */
@Service // 로그인 절차 논리
public class SecurityServiceImpl implements SecurityService {

	@Autowired // 인증 관리
	private AuthenticationManager authenticationManager;
	
	@Autowired // 사용자 정보
	private UserDetailsService userDetailsService;
	
	// 에러 찾기할 때 사용
	private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
	
	/**
	 * 현재 로그인된 사용자 아이디 불러오기
	 * @return 현재 로그인된 사용자 (없을 시 null)
	 */
	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
	}

	/**
	 * 자동 로그인 절차
	 */
	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.debug(String.format("사용자 (%s) 자동로그인 됨", username));
        }
    }

}
