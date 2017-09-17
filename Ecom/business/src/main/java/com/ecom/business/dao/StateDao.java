package com.ecom.business.dao;

import java.util.List;

import com.ecom.common.vo.City;
import com.ecom.common.vo.State;

public interface StateDao {
	
	public void saveState(State state);
	public void saveCity(City city);
	public List<State> allCities(String stateName);
	
	public State findByState(String stateName);

}
