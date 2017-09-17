package com.ecom.service;

import java.util.List;
import java.util.Map;

import com.ecom.common.vo.City;
import com.ecom.common.vo.State;

public interface StateService {
	
	public Map<String,List<City>> mapCityStae(String state);
	public List<City> getCityBySt(String state);
	


}
