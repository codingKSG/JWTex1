package com.cos.jwtex1.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.jwtex1.domain.User;

public class PrincipalDetails implements UserDetails{

	private User user;

	public PrincipalDetails(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 해당 계정 만료
	@Override
	public boolean isAccountNonExpired() {
		// 해당 계정이 만료 안됬는지
		return true;
	}

	// 로그인 반복 실패시 잠금
	@Override
	public boolean isAccountNonLocked() {

		// 잠금되지 않았는지
		return true;
	}

	// 비밀번호 만료
	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 만료 안됬는지
		return true;
	}

	// 계정 활성화
	@Override
	public boolean isEnabled() {
		// 계정 활성화 됬는지
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collecters = new ArrayList<>();
		collecters.add(() -> "ROLE_"+user.getRole());
		return collecters;
	}
	

}
