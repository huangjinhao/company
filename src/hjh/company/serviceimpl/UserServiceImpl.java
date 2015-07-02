package hjh.company.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import hjh.company.dao.UserDAO;
import hjh.company.domain.User;
import hjh.company.domain.UserRole;
import hjh.company.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User create(User user) {
		return userDAO.create(user);
	}

	@Override
	public boolean deleteById(String userId) {
		return userDAO.deleteById(userId);
	}

	@Override
	public User update(User user) {
		return  userDAO.update(user);
	}

	@Override
	public User queryUserById(String userId) {
		return userDAO.queryUserById(userId);
	}

	@Override
	public User login(User user) {
		if("".equals(user.getUserId()) || user.getUserId() == null
				|| user.getPassword() == null || "".equals(user.getPassword())){
			return null;
		}
		User newUser = queryUserById(user.getUserId());
		if(newUser == null) return null;
		if(user.getPassword().equals(newUser.getPassword())){
			return newUser;
		}
		return null;
	}

	@Override
	public List<UserRole> queryUsersByRole(User user) {
		List<User> users =  userDAO.queryUsersByRole(user);
		if(users == null) return null;
		List<UserRole> userRoles = new ArrayList<UserRole>();
		for(int i = 0; i < users.size();i++){
			UserRole userRole = new UserRole(users.get(i));
			userRoles.add(userRole);
		}
		
		return userRoles;
	}

	@Override
	public 	List<UserRole> queryAllUsers() {
		List<User> users = userDAO.queryAllUsers();
		if(users == null) return null;
		List<UserRole> userRoles = new ArrayList<UserRole>();
		for(int i = 0; i < users.size();i++){
			UserRole userRole = new UserRole(users.get(i));
			userRoles.add(userRole);
		}
		
		return userRoles;
	}

}
