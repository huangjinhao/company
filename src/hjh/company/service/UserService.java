package hjh.company.service;

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
}
