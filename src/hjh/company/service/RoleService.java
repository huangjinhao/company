package hjh.company.service;

import hjh.company.domain.Role;
import hjh.company.domain.User;

public interface RoleService {
	/**
	 * ������ɫ
	 * @return
	 */
	public Role create();
	/**
	 * ɾ����ɫ
	 * @param role
	 * @return
	 */
	public boolean deleteById(Role role);
	/**
	 * ���½�ɫ
	 * @param role
	 * @return
	 */
	public Role update(Role role);
	/**
	 * ��ѯ��ɫ
	 * @param role
	 * @return
	 */
	public Role queryById(Role role);
	/**
	 * ��ĳ���û������ɫ
	 * @param user
	 * @param role
	 * @return
	 */
	public boolean assignRole(User user ,Role role);
	/**
	 * ɾ��ĳ���û������еĽ�ɫ
	 * @param user
	 * @param role
	 * @return
	 */
	public boolean removeRole(User user,Role role);
}
