package ifi.internaltool.allocation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ifi.internaltool.allocation.model.AppUser;
import ifi.internaltool.allocation.repo.AppUserDAO;
@Service
public class AppUserService implements UserDetailsService {
	
	@Autowired
	private AppUserDAO appuserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		AppUser user= appuserRepository.findByUserName(username);
		if(user == null)
				throw new UsernameNotFoundException(username);
		return new UserDetailsImpl(user);
	}

}
