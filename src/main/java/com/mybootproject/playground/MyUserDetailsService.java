package com.mybootproject.playground;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mybootproject.playground.model.UserInfo;
import com.mybootproject.playground.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Go to DB and check if username is present
		UserInfo uInfo = userRepository.getByUsername(username);
		
		if(uInfo==null)
			throw new UsernameNotFoundException("Username Invalid!!");
		
		List<GrantedAuthority> list = new ArrayList<>();
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(uInfo.getRole());
		list.add(sga);
		
		User user = new User(uInfo.getUsername(), uInfo.getPassword(),list);
		// convert user into userdetails. Return UserDetails(username,password,role) 
		return user;
	}
 
}
