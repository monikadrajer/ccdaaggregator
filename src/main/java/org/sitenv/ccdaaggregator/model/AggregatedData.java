package org.sitenv.ccdaaggregator.model;

import java.util.HashMap;
import java.util.Map;

public class AggregatedData {
	
	public AggregatedData(){
		aggregatedDataMap = new HashMap<>();
	}
	
	private Map<String, PatientAggregatedData> aggregatedDataMap;

	public Map<String, PatientAggregatedData> getAggregatedDataMap() {
		return aggregatedDataMap;
	}

	public void setAggregatedDataMap(Map<String, PatientAggregatedData> aggregatedDataMap) {
		this.aggregatedDataMap = aggregatedDataMap;
	}
}
