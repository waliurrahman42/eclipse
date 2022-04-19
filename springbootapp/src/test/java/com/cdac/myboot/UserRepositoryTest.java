package com.cdac.myboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepo;
	@Autowired
	private TestEntityManager entityManager;
	
//	@Test
//	public void testCreateUser() {
//		
//		User user=new User();
//		user.setEmail("wal1i@gmail.com");
//		user.setFirstname("waliur");
//		user.setLastName("rahman");
//		user.setPassword("1234");
//		
//		// insert user
//		User savedUser= urepo.save(user);
//		// fetch user 
//		User existUser =entityManager.find(User.class, savedUser.getUserId());
//		// email test 
//		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
//		
//	}
	
	@Test
	public void testFindByEmail(){
	
	String emaiString="wali324@gmail.com";
		 	
	User user=urepo.findByEmail(emaiString);
	System.out.println(user);
	assertThat(user).isNotNull();
		
	}
}
