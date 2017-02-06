/**
 * 
 */
package org.edtoktay.testproject.rest;

import java.util.Optional;
import java.util.stream.Collectors;

import org.edtoktay.springtools.security.jwt.operations.TokenCreator;
import org.edtoktay.testproject.entity.User;
import org.edtoktay.testproject.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deniz.toktay
 *
 */
@RestController
public class LoginService {
	@Autowired
	TokenCreator tokenCreator;
	@Autowired
	UserRepository userRepo;
	@RequestMapping(value = "/api/login", method = RequestMethod.GET)
	public String logIn(@RequestParam("username") String username, @RequestParam("password") String password) {
		Optional<User> user = userRepo.findByUsername(username);
		if (!user.get().getPassword().equals(password))
			return "Authorization error";
		UserDetails context = new org.springframework.security.core.userdetails.User(user.get().getUsername(),
				user.get().getPassword(),
				user.get().getRoles().stream()
						.map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
						.collect(Collectors.toList()));
		String token = tokenCreator.createToken(context);
		return token;
	}
	
	@RequestMapping(value="/api/auth/aus", method = RequestMethod.GET)
	public String test(@RequestParam("test") String test){
		return "Hello " + test;
	}
}
