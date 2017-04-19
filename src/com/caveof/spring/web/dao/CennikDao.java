package com.caveof.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("cennikDao")
public class CennikDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	
	public List<Cennik> getCennik() {

		return jdbc.query("select * from pricelist", new RowMapper<Cennik>() {

			public Cennik mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cennik cennik = new Cennik();

				cennik.setVehicleType(rs.getString("vehicleType"));
				cennik.setOneDay(rs.getDouble("oneDay"));
				cennik.setOneDayMoreThanWeek(rs.getDouble("oneDayMoreThanWeek"));
				cennik.setOneDayMoreThanMonth(rs.getDouble("oneDayMoreThanMonth"));

				return cennik;
			}
		});
	}
	
	// Metoda aktualizujaca rekord w bazie danych
	public boolean update(Cennik cennik) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(cennik);
		
		return jdbc.update("update pricelist set oneDay = :oneDay, oneDayMoreThanWeek = :oneDayMoreThanWeek, oneDayMoreThanMonth = :oneDayMoreThanMonth where vehicleType = :vehicleType", params) == 1;
	}


}
