package hjh.company.action;

import java.util.Iterator;

import org.apache.struts2.ServletActionContext;

import hjh.company.domain.Role;
import hjh.company.domain.User;
import hjh.company.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user = new User();
	private User fromDBUser;
	private UserService userService;
	private String nextPage;
	
   
	public String getNextPage() {
		return nextPage;
	}

	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}

	public User getFromDBUser() {
		return fromDBUser;
	}

	public void setFromDBUser(User fromDBUser) {
		this.fromDBUser = fromDBUser;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
  
	public String register() throws Exception{
		fromDBUser = userService.create(user);
		if(fromDBUser == null) return LOGIN;
		return SUCCESS;
	}
	
	public String login() throws Exception{
		fromDBUser = userService.login(user);
		if(fromDBUser == null) return LOGIN;
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("loginUser",fromDBUser);
		
//		forwardTo(fromDBUser);
		return SUCCESS;
	}
	
//	public String querySelfInfo() throws Exception{
//		
//	}
	
	
//	private String forwardTo(User user){
//		Role role = user.getRoles().iterator().next();
//		String roleName = role.getRoleName();
//		if("管理员".equals(roleName)){
//			nextPage = "manager";
//		}
//		if("不明身份".equals(roleName)){
//			nextPage = "unknow";
//		}
//		return nextPage;
//	}
}
