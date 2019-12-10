
package com.asset.management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asset.management.dao.entity.Login;
import com.asset.management.dao.repository.LoginRepository;

@Service
public class UserLoginServiceImpl implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		final Login user = loginRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found.");
		}
		final List<SimpleGrantedAuthority> auths = new ArrayList<>();
		return new User(username, user.getPassword(), auths);
	}

}
