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

	@Override
	public boolean isUserDumplicate(String userId) {
		return false;
	}

}
