package hjh.company.serviceimpl;

import hjh.company.dao.UserDAO;
import hjh.company.domain.User;
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
		if(newUser == null){
			return null;
		
		}
		if(user.getPassword().equals(newUser.getPassword())){
			return newUser;
		}
		return null;
	}

}
