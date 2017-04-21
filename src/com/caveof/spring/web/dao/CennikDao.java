package com.caveof.spring.web.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("cennikDao")
public class CennikDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public List<Cennik> getCennik() {

		return jdbc.query("select * from pricelist", new CennikRowMapper());
	}
	
	// Metoda aktualizujaca rekord w bazie danych
	public boolean update(Cennik cennik) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(cennik);
		
		return jdbc.update("update pricelist set oneDay = :oneDay, oneDayMoreThanWeek = :oneDayMoreThanWeek, oneDayMoreThanMonth = :oneDayMoreThanMonth where vehicleType = :vehicleType", params) == 1;
	}


}
