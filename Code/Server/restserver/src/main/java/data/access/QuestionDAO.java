package data.access;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import data.model.Question;

public class QuestionDAO {
	
	public Question getQuestion(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("select q from Question q where q.id = :id");
		query.setParameter("id", id);
		Question question = (Question) query.uniqueResult();
		session.close();
		return question;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> getQuestions(){ //should this getQuestions be parameterised to a topic, such that u only get the questions on a specific topic (since rounds are binded to a topic) instead of all questions?
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select q from Question q"); //if yes, this has to be changed
		
		System.out.println("Query:"+query.getQueryString());
		
		
		List<Question> questions = query.list();
		
		System.out.println("result: "+questions);
		
		
		session.close();
		return questions;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Question> getQuestionsByTopic(String topic){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("Select q from Question q where q.topic = :topic");
		query.setParameter("topic", topic);
		
		System.out.println("Query:"+query.getQueryString());
		
		
		List<Question> questions = query.list();
		
		System.out.println("result: "+questions);
		
		session.close();
		return questions;
	}
	
	
	public void addQuestion(Question question) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(question);
		transaction.commit();
		session.close();
	}

}
