/**
 * 
 */
package test.repo;

import static org.junit.Assert.*;

import java.util.Optional;
import java.util.stream.Collectors;

import org.edtoktay.springtools.security.jwt.operations.TokenCreator;
import org.edtoktay.springtools.security.jwt.operations.TokenParser;
import org.edtoktay.testproject.Application;
import org.edtoktay.testproject.entity.User;
import org.edtoktay.testproject.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author deniz.toktay
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JwtPackage {
	@Autowired
	TokenCreator tokenCreator;
	@Autowired
	TokenParser tokenParser;
	@Autowired
	UserRepository userRepo;

	@Test
	public void test() {
		Optional<User> usr = userRepo.findByUsername("deniz");
		UserDetails context = new org.springframework.security.core.userdetails.User(usr.get().getUsername(),
				usr.get().getPassword(),
				usr.get().getRoles().stream()
						.map(authority -> new SimpleGrantedAuthority(authority.getRole().authority()))
						.collect(Collectors.toList()));
		String token = tokenCreator.createToken(context);
		System.out.println(token);
		assertTrue(context.equals(tokenParser.parseClaims(token)));
	}

}
