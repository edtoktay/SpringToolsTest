/**
 * 
 */
package test.repo;

import static org.junit.Assert.*;

import java.util.Optional;

import org.edtoktay.testproject.Application;
import org.edtoktay.testproject.entity.User;
import org.edtoktay.testproject.repo.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author deniz.toktay
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RepoTest {
	@Autowired UserRepository userRepo;
	@Test
	public void test() {
		try{
			Optional<User> usr = userRepo.findByUsername("deniz");
			assertNotNull(usr);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
