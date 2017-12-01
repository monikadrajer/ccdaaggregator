package org.sitenv.ccdaaggregator.configuration;

import java.util.ArrayList;
import java.util.List;

import org.sitenv.ccdaaggregator.model.AggregatedData;

public class CCDAAggregatorSingleton {

	private static CCDAAggregatorSingleton instance;
	private List<AggregatedData> aggregatorList;
	
	private CCDAAggregatorSingleton() {
		aggregatorList = new ArrayList<>();
	}

	public static CCDAAggregatorSingleton getInstance() {
		if (instance == null) {
			instance = new CCDAAggregatorSingleton();
		}
		System.out.println("Instance size:" + instance.getAggregatorList().size());
		return instance;
	}

	public List<AggregatedData> getAggregatorList() {
		return aggregatorList;
	}

	public void setAggregatorList(List<AggregatedData> aggregatorList) {
		this.aggregatorList = aggregatorList;
	}
}
