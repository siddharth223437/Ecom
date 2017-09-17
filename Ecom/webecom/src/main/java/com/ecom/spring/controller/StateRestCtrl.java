package com.ecom.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.vo.City;
import com.ecom.service.StateService;

@RestController
public class StateRestCtrl {
	
	@Autowired
	private StateService stateService;
	
	@GetMapping("/test/{state}")
	public List<City> byStae(@PathVariable("state") String state){
		List<City> cityList = stateService.getCityBySt(state);
		for(City s : cityList) {
			System.out.println(s.getCityId());
		}
		return cityList;
	}
	
	@GetMapping("/test1/{state}")
	public Map<String,List<City>> mapCi(@PathVariable("state") String state){
		Map<String,List<City>> finMap = stateService.mapCityStae(state);
		
		for(Map.Entry<String, List<City>> entry : finMap.entrySet()) {
			System.out.println(entry.getKey() +" "+entry.getValue());
		}
		System.out.println("");
		return finMap;
	}

}
