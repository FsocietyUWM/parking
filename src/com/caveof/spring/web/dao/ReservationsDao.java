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
@Component("reservationsDao")
public class ReservationsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	//////////////////////////////////////////////////////////

	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli reservations
	@SuppressWarnings("unchecked")
	public List<Reservation> getReservations() {
		Criteria crit = session().createCriteria(Reservation.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}
	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli reservations
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicles() {
		Criteria crit = session().createCriteria(Vehicle.class);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicles(String username) {
		Criteria crit = session().createCriteria(Vehicle.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Vehicle> getVehicles(int reservationID) {
		Criteria crit = session().createCriteria(Vehicle.class);
		crit.createAlias("reservation", "r");
		crit.add(Restrictions.eq("r.reservationID", reservationID));
		return crit.list();
	}
	
	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli reservations konkretnego uzytkownika
	@SuppressWarnings("unchecked")
	public List<Reservation> getReservations(String username) {
		Criteria crit = session().createCriteria(Reservation.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}

	
	// Metoda tworzaca lub aktualizujaca rezerwacje bazie danych
	public void saveOrUpdate(Reservation reservation) {
		session().saveOrUpdate(reservation);
	}


	// Metoda usuwajaca z bazy rekord o podanym id
	public boolean delete(int reservationID) {
		Query query = session().createQuery("delete from Reservation where reservationID=:reservationID");
		return query.executeUpdate() == 1;
	}

	
	// Metoda wyciagajaca z bazy rekord o podanym id
	public Reservation getReservation(int reservationID) {
		Criteria crit = session().createCriteria(Reservation.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(reservationID));
		return (Reservation)crit.uniqueResult();
	}
	
	// Metoda tworzaca lub aktualizujaca pojazd w bazie danych
	public void saveVehicle(Vehicle vehicle) {
		session().save(vehicle);
	}
	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli parking_spaces
	@SuppressWarnings("unchecked")
	public List<ParkingSpace> getParkingSpaces() {
		Criteria crit = session().createCriteria(ParkingSpace.class);
		return crit.list();
	}
	
	// Metoda tworzaca miejsce parkingowe w BD
	public void saveParkingSpace(ParkingSpace parkingSpace) {
		session().save(parkingSpace);
	}
	
	// Metoda aktualizujaca miejsce parkingowe w BD
	public void updateParkingSpace(ParkingSpace parkingSpace) {
		session().update(parkingSpace);
	}
	
	@SuppressWarnings("unchecked")
	public ParkingSpace getAvailableParkingSpace() {
		Criteria crit = session().createCriteria(ParkingSpace.class);
		crit.add(Restrictions.eq("available", true));
		return (ParkingSpace)crit.list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<ParkingSpace> getAvailableParkingSpaces() {
		Criteria crit = session().createCriteria(ParkingSpace.class);
		crit.add(Restrictions.eq("available", true));
		return crit.list();
	}
	
	public int getNumberOfAllParkingSpaces() {
		Criteria crit = session().createCriteria(ParkingSpace.class);
		return crit.list().size();
	}
	
	public int getNumberOfAvailableParkingSpaces() {
		Criteria crit = session().createCriteria(ParkingSpace.class);
		crit.add(Restrictions.eq("available", true));
		return crit.list().size();
	}
	
	public int getNumberOfTakenParkingSpaces() {
		Criteria crit = session().createCriteria(ParkingSpace.class);
		crit.add(Restrictions.eq("available", false));
		return crit.list().size();
	}
	
	public void delete(ParkingSpace parkingSpace) {
		session().delete(parkingSpace);
	}
	
	public void saveOrUpdate(ParkingSpace parkingSpace) {
		session().saveOrUpdate(parkingSpace);
	}

}
