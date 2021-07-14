package luminous.StudentForum;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import luminous.StudentForum.model.User;
import luminous.StudentForum.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setName("Fahim Faisal");
		user.setUserName("fahim");
		user.setPassword("hello");
		user.setType("admin");
		
		User savedUser = repo.save(user);
		User existUser =  entityManager.find(User.class, savedUser.getId());
		assertThat(existUser.getUserName()).isEqualTo(user.getUserName());
	}
	
}
