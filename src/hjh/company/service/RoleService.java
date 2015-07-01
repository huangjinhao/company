package hjh.company.service;

import hjh.company.domain.Role;
import hjh.company.domain.User;

public interface RoleService {
	/**
	 * 创建角色
	 * @return
	 */
	public Role create();
	/**
	 * 删除角色
	 * @param role
	 * @return
	 */
	public boolean deleteById(Role role);
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	public Role update(Role role);
	/**
	 * 查询角色
	 * @param role
	 * @return
	 */
	public Role queryById(Role role);
	/**
	 * 给某个用户分配角色
	 * @param user
	 * @param role
	 * @return
	 */
	public boolean assignRole(User user ,Role role);
	/**
	 * 删除某个用户的已有的角色
	 * @param user
	 * @param role
	 * @return
	 */
	public boolean removeRole(User user,Role role);
}
