package com.caveof.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CennikRowMapper implements RowMapper<Cennik>{

	@Override
	public Cennik mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cennik cennik = new Cennik();
		cennik.setVehicleType(rs.getString("vehicleType"));
		cennik.setOneDay(rs.getDouble("oneDay"));
		cennik.setOneDayMoreThanWeek(rs.getDouble("oneDayMoreThanWeek"));
		cennik.setOneDayMoreThanMonth(rs.getDouble("oneDayMoreThanMonth"));

		return cennik;
	}

}
