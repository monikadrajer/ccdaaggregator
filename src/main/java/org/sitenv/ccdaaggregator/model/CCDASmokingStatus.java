package org.sitenv.ccdaaggregator.model;

import org.apache.log4j.Logger;
import org.sitenv.ccdaaggregator.dto.ContentValidationResult;
import org.sitenv.ccdaaggregator.dto.enums.ContentValidationResultLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CCDASmokingStatus {

	private static Logger log = Logger.getLogger(CCDASmokingStatus.class.getName());
	
	private ArrayList<CCDAII>					smokingStatusTemplateIds;
	private CCDACode							smokingStatusCode;
	private CCDAEffTime							observationTime;
	
	public static void compareSmokingStatus(HashMap<String, CCDASmokingStatus> refStatus, 
			HashMap<String, CCDASmokingStatus> subStatus, 	ArrayList<ContentValidationResult> results) {

		log.info(" Start Smoking Status comparison ");
		// For each Vital Sign Observation in the Ref Model, check if it is present in the subCCDA Model.
		for(Map.Entry<String, CCDASmokingStatus> ent: refStatus.entrySet()) {

			if(subStatus.containsKey(ent.getKey())) {

				log.info("Smoking Status found ");

			} else {
				// Error
				String error = "The scenario contains Smoking Status data with code " + ent.getKey() +
						" , however there is no matching data in the submitted CCDA. ";
				ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
				results.add(rs);
			}
		}
		
	}
	
	public void log() {
		
		if(smokingStatusCode != null)
			log.info(" Smoking Status Code = " + smokingStatusCode.getCode());
		
		for(int j = 0; j < smokingStatusTemplateIds.size(); j++) {
			log.info(" Tempalte Id [" + j + "] = " + smokingStatusTemplateIds.get(j).getRootValue());
			log.info(" Tempalte Id Ext [" + j + "] = " + smokingStatusTemplateIds.get(j).getExtValue());
		}
		
		if(observationTime != null)
			observationTime.log();
	}
	
	public CCDASmokingStatus()
	{
		smokingStatusTemplateIds = new ArrayList<CCDAII>();
	}

	public ArrayList<CCDAII> getSmokingStatusTemplateIds() {
		return smokingStatusTemplateIds;
	}

	public void setSmokingStatusTemplateIds(ArrayList<CCDAII> ids) {
		
		if(ids != null)
			this.smokingStatusTemplateIds = ids;
	}

	public CCDACode getSmokingStatusCode() {
		return smokingStatusCode;
	}

	public void setSmokingStatusCode(CCDACode smokingStatusCode) {
		this.smokingStatusCode = smokingStatusCode;
	}

	public CCDAEffTime getObservationTime() {
		return observationTime;
	}

	public void setObservationTime(CCDAEffTime observationTime) {
		this.observationTime = observationTime;
	}
}
