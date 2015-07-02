package hjh.company.service;

import java.util.List;

import hjh.company.domain.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
    public User create(User user);
    /**
     * 删除用户
     * @param userId
     * @return
     */
    public boolean deleteById(String userId);
    /**
     * 更新用户资料
     * @param user
     * @return
     */
    public User update(User user);
    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public User queryUserById(String userId); 
    /**
     * 登陆
     * @param user
     * @return user
     */
    public User login(User user);
    /**
     * 管理员根据角色进行模糊查询
     * @param user
     * @return
     */
    public List<User> queryUsersByRole(User user);
}
