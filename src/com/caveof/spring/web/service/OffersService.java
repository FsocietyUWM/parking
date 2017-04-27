package com.caveof.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.caveof.spring.web.dao.Offer;
import com.caveof.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {

	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}
	
	//////////////////////////////////////////////////////////

	
	public List<Offer> getOffers() {
		return offersDao.getOffers();
	}
	

	public Offer getOffer(String username) {

		if (username == null) {
			return null;
		}

		List<Offer> offers = offersDao.getOffers(username);
		if (offers.size() == 0) {
			return null;
		}

		return offers.get(0);
	}
	
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void saveOrUpdate(Offer offer) {
		offersDao.saveOrUpdate(offer);
	}
	

	public void delete(int id) {
		offersDao.delete(id);
	}


	public boolean hasOffer(String username) {

		if (username == null) {
			return false;
		}

		List<Offer> offers = offersDao.getOffers(username);
		if (offers.size() == 0) {
			return false;
		}

		return true;
	}

}
