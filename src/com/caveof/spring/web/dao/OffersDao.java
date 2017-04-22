package com.caveof.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("offersDao")
public class OffersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli offers
	@SuppressWarnings("unchecked")
	public List<Offer> getOffers() {
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}
	
	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli offers konkretnego uzytkownika
	@SuppressWarnings("unchecked")
	public List<Offer> getOffers(String username) {
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	
	// Metoda tworzaca lub aktualizujaca rekord w bazie danych
	public void saveOrUpdate(Offer offer) {
		session().saveOrUpdate(offer);
	}


	// Metoda usuwajaca z bazy rekord o podanym id
	public boolean delete(int id) {
		Query query = session().createQuery("delete from Offer where id=:id"); // mozna by uzyc session().delete(), ale metoda ta przyjmuja obiekt a nie id
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	
	// Metoda wyciagajaca z bazy rekord o podanym id
	public Offer getOffer(int id) {
		Criteria crit = session().createCriteria(Offer.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(id));
		return (Offer)crit.uniqueResult();
	}

}
