package data.access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.model.User;

/**
 * DAO Class for User
 * @author cz17a
 * @version 1.1
 * @category DAO
 */

public class UserDAO {
	
	/**
	 * Gets a User from DataBase by ID
	 * @param id ID of the User
	 * @return User Object
	 */
	public User getUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select u from Person u where u.id = :id");
		query.setParameter("id", id);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	/**
	 * Overloaded function, gets an User by nickname (since nicknames have to be unique) from DataBase
	 * @param nickname String of nickname
	 * @return User Object
	 */
	public User getUser(String nickname) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select u from Person u where u.nickname = :nickname");
		query.setParameter("nickname", nickname);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	/**
	 * Gets an User by email from DataBase
	 * @param email String of email
	 * @return User Object
	 * @since 1.1
	 */
	public User getUserByMail(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select u from Person u where u.mail = :mail");
		query.setParameter("mail", email);
		User user = (User) query.uniqueResult();
		session.close();
		return user;
	}
	
	
	public boolean usernameExist(String name) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select u from Person u where u.nickname = :nickname");
		query.setParameter("nickname", name);
		User user = (User) query.uniqueResult();
		session.close();
		if(user != null) return true;
		return false;	
	}
	
	public boolean emailExist(String email) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select u from Person u where u.mail = :mail");
		query.setParameter("mail", email);
		User user = (User) query.uniqueResult();
		session.close();
		if(user != null) return true;
			return false;
	}
	
	/**
	 * Gets a List of all Users
	 * @return List of User Objects
	 */
	public List<User> getUsers(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("from Person");
		List<User> users = query.list();
		session.close();
		return users;
	}
	/**
	 * Adds a User to DB, but only if the ID and name is not already in the DB
	 * @param user User Object
	 */
	public void addUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select u.id from Person u");
		List<Integer> userIDs = query.list();
		Query query2 = session.createQuery("Select u.nickname from Person u");
		List<String> userNames = query.list();
		if(!(userIDs.contains(user.getId())) && !(userNames.contains(user.getNickname()))) { //only add the user if the ID and name is not in the DB
			Transaction ts = session.beginTransaction();
			session.save(user);
			ts.commit();
		}
		session.close();
	}
	/**
	 * counts the number of users in the DB, (used to later generate new ID's for users)
	 * @return Integer Number of users
	 */
	public int countUsers() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select count(u) from Person u");
		int numberOfUsers = (int) (long) query.uniqueResult();
		session.close();
		return numberOfUsers;
	}
	/** 
	 * removes a user from the DB 
	 * @param id ID of the User
	 */ 
	public void removeUser(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Delete from Person where id = :id");
		query.setParameter("id", id).executeUpdate();
		session.close();
	}
}