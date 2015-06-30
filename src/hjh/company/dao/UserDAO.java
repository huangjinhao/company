package hjh.company.dao;

import hjh.company.domain.User;

public interface UserDAO {
	public boolean isUserDumplicate(String userId);
    public User create(User user);
    	
}
