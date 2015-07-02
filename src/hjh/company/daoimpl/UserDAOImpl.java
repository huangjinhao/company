package hjh.company.daoimpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hjh.company.dao.UserDAO;
import hjh.company.domain.Role;
import hjh.company.domain.User;

public class UserDAOImpl implements UserDAO {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * ע���û�
	 */
	@Override
	public User create(User user) {
		if (isUserDumplicate(user.getUserId()))
			return null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			Role role = (Role) session.get(Role.class,0);
			user.getRoles().add(role);
			session.save(user);
			tx.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	/**
	 * ���ע���û��Ƿ��Ѿ����ڣ������ڣ�����true������false��
	 */
	@Override
	public boolean isUserDumplicate(String userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			User user = (User) session.get(User.class,userId);
			tx.commit();
			if(user != null) return true;
			return false;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			return true;
		} finally {
			session.close();
		}	
	}

	/**
	 * ����û�id�����û�
	 */
	@Override
	public User queryUserById(String userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			User user = (User) session.get(User.class,userId);
			tx.commit();
			if(user != null) return user;
			return null;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}	
	}

	/**
	 * ����û�Idɾ���û�
	 */
	@Override
	public boolean deleteById(String userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			User user = (User) session.get(User.class,userId);
			session.delete(user);
			tx.commit();
			return true;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			System.out.println("fsfsf");
			return false;
		} finally {
			session.close();
		}	
	}

	/**
	 * �����û�
	 */
	@Override
	public User update(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			User oldUser = (User) session.get(User.class,user.getUserId());
			if(user.getAddress() != null && !"".equals(user.getAddress()))
			    oldUser.setAddress(user.getAddress());
			if(user.getAge() != 0)
			    oldUser.setAge(user.getAge());
			if(user.getEmail() != null && !"".equals(user.getEmail()))
			    oldUser.setEmail(user.getEmail());
			if(user.getName() != null && !"".equals(oldUser.getName()))
			    oldUser.setName(user.getName());
			if(user.getPassword() != null && !"".equals(user.getPassword()))
			    oldUser.setPassword(user.getPassword());
			if(user.getSex() != null && !"".equals(user.getSex()))
			    oldUser.setSex(user.getSex());
			if(user.getTel() != null && !"".equals(user.getTel()))
			    oldUser.setTel(user.getTel());
			session.saveOrUpdate(oldUser);
			tx.commit();
			return oldUser;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}	
	}

	/**
	 * ����Ա��ݽ�ɫ���в���
	 */
	@Override
	public List<User> queryUsersByRole(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
        List<User> users = null;
		try {
			SQLQuery sqlQuery = session.createSQLQuery("select * from user where userId in (select userId from user_role where roleId=" + 
		              user.getRoles().iterator().next().getRoleId() +")");
			users = sqlQuery.list();
			tx.commit();
			return users;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}	
	}

	@Override
	public List<User> queryAllUsers() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
        List<User> users = null;
		try {
			Query query = session.createQuery("from User");
			users = query.list();
			for(int i = 0; i < users.size();i++){
				User user = users.get(i);
				Set<Role> roles = user.getRoles();
				roles.iterator().next().getAuthorities().clear();
			}
			tx.commit();	
			return users;
		} catch (Exception e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}	
	}

}
