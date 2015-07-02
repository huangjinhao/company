package hjh.company.service;

import java.util.List;

import hjh.company.domain.User;

public interface UserService {
	/**
	 * ע���û�
	 * @param user
	 * @return
	 */
    public User create(User user);
    /**
     * ɾ���û�
     * @param userId
     * @return
     */
    public boolean deleteById(String userId);
    /**
     * �����û�����
     * @param user
     * @return
     */
    public User update(User user);
    /**
     * ��ѯ�û���Ϣ
     * @param userId
     * @return
     */
    public User queryUserById(String userId); 
    /**
     * ��½
     * @param user
     * @return user
     */
    public User login(User user);
    /**
     * ����Ա��ݽ�ɫ����ģ���ѯ
     * @param user
     * @return
     */
    public List<User> queryUsersByRole(User user);
    
    public List<User> queryAllUsers();
}
