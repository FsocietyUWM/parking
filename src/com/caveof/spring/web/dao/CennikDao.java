package com.caveof.spring.web.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("cennikDao")
public class CennikDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	//////////////////////////////////////////////////////////
	
	
	@SuppressWarnings("unchecked")
	public List<Cennik> getCennik() {
		return session().createQuery("from Cennik").list();
	}
	
	// Metoda tworzaca lub aktualizujaca rekord w BD
	public void saveOrUpdate(Cennik cennik) {
		session().saveOrUpdate(cennik);
	}
	
	public void delete(Cennik cennik) {
		session().delete(cennik);
	}
	
	/* Usuwanie po id
	public boolean delete(int id) {
		Query query = session().createQuery("delete from Cennik where id=:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}
	*/

}
