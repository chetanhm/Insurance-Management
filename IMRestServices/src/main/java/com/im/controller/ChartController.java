package com.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.im.entity.PieChart;
import com.im.service.ChartService;

@CrossOrigin
@RestController
@RequestMapping(value = "/imservices")
public class ChartController {

	@Autowired
	ChartService chartService;
	
	@RequestMapping(value = "/chart/policy", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PieChart policyStatusChartData() {
	
		return 	chartService.policyStatusData();				 
		
	}
	@RequestMapping(value = "/chart/claim/type", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PieChart claimTypeChartData() {
	
		return 	chartService.claimTypeData();				 
		
	}
}
