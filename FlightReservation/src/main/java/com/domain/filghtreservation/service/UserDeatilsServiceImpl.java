package com.domain.filghtreservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.domain.filghtreservation.entities.User;
import com.domain.filghtreservation.repos.UserRepositry;

@Service
public class UserDeatilsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepositry userRepositry;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepositry.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found"+username);
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),user.getRoles());
	}

}
