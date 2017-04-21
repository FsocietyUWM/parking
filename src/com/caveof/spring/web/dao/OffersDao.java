package com.caveof.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli offers
	public List<Offer> getOffers() {

		return jdbc.query("select * from offers, users where offers.username=users.username and users.enabled = true",
				new OfferRowMapper());
	}
	
	// Metoda wyciagajaca z bazy wszystkie rekordy z tabeli offers konkretnego uzytkownika
	public List<Offer> getOffers(String username) {

		return jdbc.query("select * from offers, users where offers.username=users.username and users.enabled = true and offers.username=:username",
				new MapSqlParameterSource("username", username), new OfferRowMapper());
	}

	// Metoda aktualizujaca rekord w bazie danych
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("update offers set text = :text where id = :id", params) == 1;
	}

	// Metoda tworzaca rekord w bazie danych
	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);

		return jdbc.update("insert into offers (username, text) values (:username, :text)", params) == 1;
	}

	@Transactional
	// Metoda tworz¹ca wiele rekordów za jednym razem
	public int[] create(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());

		return jdbc.batchUpdate("insert into offers (username, text) values (:username, :text)", params);
	}

	// Metoda usuwajaca z bazy rekord o podanym id
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);

		return jdbc.update("delete from offers where id = :id", params) == 1;
	}

	// Metoda wyciagajaca z bazy rekord o podanym id
	public Offer getOffer(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject(
				"select * from offers, users where offers.username=users.username and users.enabled = true and id=:id",
				params, new OfferRowMapper());
	}

}
