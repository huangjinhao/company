package hjh.company.daoimpl;

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
	 * 注册用户
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
	 * 检查注册用户是否已经存在，如果存在，返回true，否则false；
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
	 * 根据用户id查找用户
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
	 * 根据用户Id删除用户
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
	 * 更新用户
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

}
