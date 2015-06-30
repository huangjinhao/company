package hjh.test;

import static org.junit.Assert.*;
import hjh.company.daoimpl.UserDAOImpl;
import hjh.company.domain.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDAOImplTest {
   private static UserDAOImpl userDAOImpl;
   private User user;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userDAOImpl = (UserDAOImpl) ac.getBean("userDAOImpl");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(user);
	} 

	@Test
	public void test() {
		User user = new User();
		user.setAddress("gdou");
		user.setAge(22);
		user.setEmail("fsd ");
		user.setName("hjh");
		user.setPassword("hjh");
		user.setSex("ÄÐ");
		user.setTel("15322511343");
		user.setUserId("64grefsdf fdsd5 n");
		
		this.user = userDAOImpl.create(user);
	}

}
