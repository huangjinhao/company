package hjh.test;

import hjh.company.daoimpl.UserDAOImpl;
import hjh.company.domain.User;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDAOImplTest2 {

	private static UserDAOImpl userDAOImpl;
	private User user;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
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


//	@Test
	public void testCreate() {
		User user = new User();
		user.setAddress("gdou");
		user.setAge(33);
		user.setEmail("123@sina.com");
		user.setName("hjh");
		user.setPassword("hjh");
		user.setSex("man");
		user.setTel("110");
		user.setUserId("12345");
		this.user = userDAOImpl.create(user);
	}

//	@Test
	public void testDelete(){
		boolean result = userDAOImpl.deleteById("12345");
		System.out.println(result);
	}
	
//	@Test
	public void testUpdate(){
		User user = new User();
		user.setName("huangjinhao");
		user.setTel("119");
		user.setUserId("1234");
		this.user = userDAOImpl.update(user);
	}
	
//	@Test
	public void testQuery(){
		this.user = userDAOImpl.queryUserById("1234");
	}
	@Test
	public void testQueryAll(){
		List<User> users = userDAOImpl.queryAllUsers();
		for(int i = 0; i < users.size();i++){
			//JSONObject jsonObject = new JSONObject();
			//jsonObject.accumulate("user", users.get(i));
			//System.out.println(jsonObject.toString());
		}
	}
}









