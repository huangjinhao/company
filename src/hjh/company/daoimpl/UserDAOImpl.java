package hjh.company.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hjh.company.dao.UserDAO;
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
		if(isUserDumplicate(user.getUserId())) return null;
		Session session = sessionFactory.openSession();
		
		return null;
	}

	@Override
	public boolean isUserDumplicate(String userId) {
		return false;
	}

}