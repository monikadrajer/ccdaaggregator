package org.sitenv.ccdaaggregator.model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class CCDAVitalSigns {
	
	private static Logger log = Logger.getLogger(CCDAVitalSigns.class.getName());
	
	private ArrayList<CCDAII>			templateIds;
	private CCDACode					sectionCode;
	private ArrayList<CCDAVitalOrg>		vitalsOrg;
	
	public HashMap<String, CCDAVitalObs> getVitalObsMap() {
		
		HashMap<String, CCDAVitalObs> results = new HashMap<String, CCDAVitalObs>();
		log.info(" Iterating through Organizers ");
		for(int k = 0; k < vitalsOrg.size(); k++) {
			
			ArrayList<CCDAVitalObs> observations = vitalsOrg.get(k).getVitalObs();
			
			for(int j = 0; j < observations.size(); j++) {
				
				log.info(" Iterating through Observations ");
				if(observations.get(j).getVsCode() != null && 
			       observations.get(j).getVsCode().getCode() != null) {
				
					String code = observations.get(j).getVsCode().getCode();
					log.info("Adding vital code = " + code);
					results.put(code, observations.get(j));
				}
			}// for	
		}// for
		
		return results;
	}

	public void log() {
		
		if(sectionCode != null)
			log.info(" Vital Signs Section Code = " + sectionCode.getCode());
		
		for(int j = 0; j < templateIds.size(); j++) {
			log.info(" Tempalte Id [" + j + "] = " + templateIds.get(j).getRootValue());
			log.info(" Tempalte Id Ext [" + j + "] = " + templateIds.get(j).getExtValue());
		}
			
		for(int k = 0; k < vitalsOrg.size(); k++) {
			vitalsOrg.get(k).log();
		}
	}
	
	public ArrayList<CCDAII> getTemplateIds() {
		return templateIds;
	}

	public void setTemplateIds(ArrayList<CCDAII> ids) {
		
		if(ids != null)
			this.templateIds = ids;
	}

	public CCDACode getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(CCDACode sectionCode) {
		this.sectionCode = sectionCode;
	}

	public ArrayList<CCDAVitalOrg> getVitalsOrg() {
		return vitalsOrg;
	}

	public void setVitalsOrg(ArrayList<CCDAVitalOrg> vos) {
		
		if(vos != null)
			this.vitalsOrg = vos;
	}

	public CCDAVitalSigns()
	{
		templateIds = new ArrayList<CCDAII>();
		vitalsOrg = new ArrayList<CCDAVitalOrg>();
	}
}
