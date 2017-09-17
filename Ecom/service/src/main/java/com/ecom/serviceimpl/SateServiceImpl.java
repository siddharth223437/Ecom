package com.ecom.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.business.dao.StateDao;
import com.ecom.common.vo.City;
import com.ecom.common.vo.State;
import com.ecom.service.StateService;

@Service
public class SateServiceImpl implements StateService {
	
	@Autowired
	private StateDao stateDao;
	
	
	@Override
	public Map<String, List<City>> mapCityStae(String state) {
		State st = stateDao.findByState(state);
		List<City> getCi = st.getCity();
		Map<String,List<City>> mapCS = new HashMap<>();
		if(!mapCS.containsKey(state)) {
			mapCS.put(state, getCi);
		}
		return mapCS;
	}


	@Override
	public List<City> getCityBySt(String state) {
		List<City> allC = new ArrayList<>();
		Map<String,List<City>> mapResult = mapCityStae(state);
		System.out.println("till here");
		if(mapResult.containsKey(state)) {
			mapResult.get(state);
		}
		for(Map.Entry<String, List<City>> entry : mapResult.entrySet()) {
			allC = entry.getValue();
		}
		return allC;
	}
	
	


}
