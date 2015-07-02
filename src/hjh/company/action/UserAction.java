package hjh.company.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hjh.company.domain.Role;
import hjh.company.domain.User;
import hjh.company.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private User user = new User();
	private User fromDBUser;
	private UserService userService;
	
	private Map<String,Object> userMap = new HashMap<String,Object>();
	
	
	public Map<String, Object> getUserMap() {
		return userMap;
	}

	public void setUserMap(Map<String, Object> userMap) {
		this.userMap = userMap;
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
  /**
   * 注册用户
   * @return
   * @throws Exception
   */
	public String register() throws Exception{
		if(isLogin()){
			//判断是否已经登陆
			userMap.put("registeStatus","0");
			return LOGIN;
		}
		
		fromDBUser = userService.create(user);
		if(fromDBUser == null) {
			//表示已经注册或者系统故障
			userMap.put("registStatus","1");
			return LOGIN;
		}
		//注册成功
		userMap.put("registStatus","2");
		return SUCCESS;
	}
	/**
	 * 登陆用户
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception{
		if(isLogin()){
			//判断是否已经登陆
			userMap.put("loginStatus","-1");
			return LOGIN;
		}
		
		fromDBUser = userService.login(user);
		if(fromDBUser == null){
			//登陆失败
			userMap.put("loginStatus","0");
			return LOGIN;
		}
		//登陆成功
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("loginUser",fromDBUser);
		userMap.put("loginStatus","1");
        userMap.put("options", fromDBUser);
		return SUCCESS;
	}
	
	
	
	/**
	 * 查询个人信息
	 * @return
	 * @throws Exception
	 */
	public String querySelfInfo() throws Exception{
		if(!isLogin()){
			userMap.put("loginStatus","0");
			return LOGIN;
		}
		
		fromDBUser = userService.queryUserById(user.getUserId());
		
		if(fromDBUser == null){
			userMap.put("queryStatus","0");
			return ERROR;
		}
		
		userMap.put("queryStatus","0");
		userMap.put("infos", fromDBUser);
		return SUCCESS;
	}
	/**
	 * 更新用户个人信息
	 * @return
	 * @throws Exception
	 */
	public String updateSelfInfo() throws Exception{
		if(!isLogin()){
			userMap.put("loginStatus",0);
			return LOGIN;
		}

		fromDBUser = userService.update(user);
		
		if(fromDBUser == null){
			userMap.put("updateStatus","0");
			return ERROR;
		}
		
		userMap.put("updateStatus","1");
		userMap.put("afterUpdateInfos",fromDBUser);

		return SUCCESS;
	}
	
	//*****************************************************
	//以下是管理员特有权限
	public String delete() throws Exception{
		if(!isManager()){
			userMap.put("loginStatus","0");
			return LOGIN;
		}
		
		boolean result = userService.deleteById(user.getUserId());
		if(result){
			userMap.put("deleteStatus","1");
			return SUCCESS;
		}
		
		userMap.put("deleteStatus","0");
		return ERROR;
	}
	
	public String queryByRole() throws Exception{
		if(!isManager()){
			userMap.put("loginStatus","0");
			return LOGIN;
		}
		List<User> users = userService.queryUsersByRole(user);
        if(users == null){
			userMap.put("queryByRoleStatus","0");
        	return ERROR;
        }
        
		userMap.put("queryByRoleStatus","1");
		userMap.put("users",users);
        return SUCCESS;
	}
	
	/**
	 * 判断当前是否有用户登陆
	 * @return
	 */
	public boolean isLogin(){
		ActionContext ac = ActionContext.getContext();
        User loginUser = (User) ac.getSession().get("loginUser");
        if(loginUser == null) return false;
        return true;
	}
	
	/**
	 * 判断当前用户是否为管理员角色
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
