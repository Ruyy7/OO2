package ar.edu.unlp.oo2.persitencia;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRepositoryProxyTest {
	UserRepository UserRepo;
	UserRepositoryProxy UserRepoProxy;
	
	@BeforeEach
	void setUp() {
		UserRepo = new UserRepository();
		UserRepoProxy = new UserRepositoryProxy(UserRepo);
	}
	
	@Test
	public void findUserByUsernameProxy() {
		assertThrows(RuntimeException.class, () -> UserRepoProxy.findUserByUsername("john_doe"));
		UserRepoProxy.requestDeploy();
		PersistableUser user = UserRepoProxy.findUserByUsername("john_doe");
		assertEquals("john_doe", user.getUsername());
		assertEquals("john.doe@example.com", user.getEmail());

//		 Incluir estas condiciones en el test final
		 assertEquals(1, user.getPosts().size());
		 assertTrue(user.getPosts().stream()
			.anyMatch(post -> post.getText().equals("¡Acabo de publicar mi primer post!")));
	}
	
}
