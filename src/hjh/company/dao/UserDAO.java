package hjh.company.dao;

import hjh.company.domain.User;

public interface UserDAO {
	public boolean isUserDumplicate(String userId);
    public User create(User user);
    public boolean deleteById(String userId);
    public User update(User user);
    public User queryUserById(String userId); 
}
