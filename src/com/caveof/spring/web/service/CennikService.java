package com.caveof.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveof.spring.web.dao.Cennik;
import com.caveof.spring.web.dao.CennikDao;

@Service("cennikService")
public class CennikService {
	
	private CennikDao cennikDao;
	
	@Autowired
	public void setCennikDao(CennikDao cennikDao) {
		this.cennikDao = cennikDao;
	}
	
	//////////////////////////////////////////////////////////
	
	
	public List<Cennik> getCennik() {
		return cennikDao.getCennik();
	}
	
	public Cennik getCennikByVehicleType(String vehicleType) {
		return cennikDao.getCennikByVehicleType(vehicleType);
	}
	
	public void saveOrUpdate(Cennik cennik) {
		cennikDao.saveOrUpdate(cennik);
	}
	
	public void delete(Cennik cennik) {
		cennikDao.delete(cennik);
	}
}
