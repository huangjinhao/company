package hjh.company.action;

import java.util.Iterator;
import java.util.List;

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
	List<User> users;
//	private String nextPage;
	
   
//	public String getNextPage() {
//		return nextPage;
//	}
//
//	public void setNextPage(String nextPage) {
//		this.nextPage = nextPage;
//	}

	public User getFromDBUser() {
		return fromDBUser;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
  /**
   * ע���û�
   * @return
   * @throws Exception
   */
	public String register() throws Exception{
		fromDBUser = userService.create(user);
		if(fromDBUser == null) return LOGIN;
		System.out.println(fromDBUser);
		return SUCCESS;
	}
	/**
	 * ��½�û�
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		fromDBUser = userService.login(user);
		if(fromDBUser == null) return LOGIN;
		
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("loginUser",fromDBUser);
		
//		forwardTo(fromDBUser);
		return SUCCESS;
	}
	/**
	 * ��ѯ������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String querySelfInfo() throws Exception{
		if(!isLogin()) return LOGIN;
		
		fromDBUser = userService.queryUserById(user.getUserId());
		
		if(fromDBUser == null) return ERROR;
		System.out.println(fromDBUser);
		return SUCCESS;
	}
	/**
	 * �����û�������Ϣ
	 * @return
	 * @throws Exception
	 */
	public String updateSelfInfo() throws Exception{
		if(!isLogin()) return LOGIN;

		fromDBUser = userService.update(user);
		
		if(fromDBUser == null) return ERROR;
		System.out.println(fromDBUser);
		return SUCCESS;
	}
	
	//*****************************************************
	//�����ǹ���Ա����Ȩ��
	public String delete() throws Exception{
		if(!isManager()) return LOGIN;
		boolean result = userService.deleteById(user.getUserId());
		if(result) return SUCCESS;
		return ERROR;
	}
	
	public String queryByRole() throws Exception{
		if(!isManager()) return LOGIN;
		users = userService.queryUsersByRole(user);
        if(users == null) return ERROR;
        return SUCCESS;
	}
	
	/**
	 * �жϵ�ǰ�Ƿ����û���½
	 * @return
	 */
	public boolean isLogin(){
		ActionContext ac = ActionContext.getContext();
        User loginUser = (User) ac.getSession().get("loginUser");
        if(loginUser == null) return false;
        return true;
	}
	
	/**
	 * �жϵ�ǰ�û��Ƿ�Ϊ����Ա��ɫ
	 */
	
	public boolean isManager(){
		ActionContext ac = ActionContext.getContext();
        User loginUser = (User) ac.getSession().get("loginUser");
        if(loginUser == null) return false;

        Role role = loginUser.getRoles().iterator().next();
        if(role.getRoleId() == 1) return true;
        return false;
	}
}
