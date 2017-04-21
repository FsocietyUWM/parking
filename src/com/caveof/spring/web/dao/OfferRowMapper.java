package com.caveof.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OfferRowMapper implements RowMapper<Offer>{

	@Override
	public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setEnabled(true);
		user.setAuthority(rs.getString("authority"));
		
		Offer offer = new Offer();
		offer.setId(rs.getInt("id"));
		offer.setText(rs.getString("text"));
		offer.setUser(user);

		return offer;
	}

}
