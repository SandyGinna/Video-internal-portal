package com.survey.service;

import java.util.ArrayList;

import com.survey.entity.SysUser;
import com.survey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		SysUser sysUser = userRepository.findByUsername(username);
		if (sysUser.getUsername().equals(username)) {
			return new User(sysUser.getUsername(), passwordEncoder.encode(sysUser.getPassword()),//"$2a$10$I9WcbivFEW6INkZKgXItK.7926KqSmQsu9JLg/tpvbsZ7s5q5.o6a",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}