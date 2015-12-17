package com.im.service;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import com.im.entity.PieChart;
import com.im.entity.PieChartElement;

@Service
public class ChartServiceImplementation implements ChartService {

	@Autowired
	private MongoOperations mongoOperations;

	public PieChart policyStatusData() {
		PieChart pieChart = new PieChart(new ArrayList<String>(), new ArrayList<String>());
		Aggregation agg = newAggregation(group("status").count().as("total"));
		AggregationResults<PieChartElement> aggregate = mongoOperations.aggregate(agg, "policies",
				PieChartElement.class);
		List<PieChartElement> mappedResults = aggregate.getMappedResults();
		for (PieChartElement m : mappedResults) {
			pieChart.getLabels().add(m.get_id());
			pieChart.getData().add(m.getTotal());
		}
		return pieChart;
	}
	public PieChart claimTypeData() {
		PieChart pieChart = new PieChart(new ArrayList<String>(), new ArrayList<String>());
		Aggregation agg = newAggregation(group("claimType").count().as("total"));
		AggregationResults<PieChartElement> aggregate = mongoOperations.aggregate(agg, "claimDetails",
				PieChartElement.class);
		List<PieChartElement> mappedResults = aggregate.getMappedResults();
		for (PieChartElement m : mappedResults) {
			pieChart.getLabels().add(m.get_id());
			pieChart.getData().add(m.getTotal());
		}
		return pieChart;
	}
	
	
}
