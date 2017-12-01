package org.sitenv.ccdaaggregator.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class CCDAGoals {

	private static Logger log = Logger.getLogger(CCDAGoals.class.getName());
	
	private ArrayList<CCDAII>     templateIds;
	
	public CCDAGoals() {
		templateIds = new ArrayList<CCDAII>();
	}
	
	
	public void log() { 
		
		for(int j = 0; j < templateIds.size(); j++) {
			log.info(" Tempalte Id [" + j + "] = " + templateIds.get(j).getRootValue());
			log.info(" Tempalte Id Ext [" + j + "] = " + templateIds.get(j).getExtValue());
		}	
	}
}
