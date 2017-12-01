package org.sitenv.ccdaaggregator.model;

import org.apache.log4j.Logger;
import org.sitenv.ccdaaggregator.dto.ContentValidationResult;
import org.sitenv.ccdaaggregator.dto.enums.ContentValidationResultLevel;

import java.util.ArrayList;

public class CCDAEffTime {
	
	private static Logger log = Logger.getLogger(CCDAEffTime.class.getName());

	private CCDADataElement low;
	private Boolean         lowPresent;
	private CCDADataElement high;
	private Boolean         highPresent;
	private CCDADataElement value;
	private Boolean         valuePresent;
	private String 			singleAdministration;
	
	public Boolean hasValidData() {
		
		if( (lowPresent || highPresent || valuePresent) )
			return true;
		else
			return false;
	}
	
	public void compare(CCDAEffTime subTime, ArrayList<ContentValidationResult> results, String elementName) {
		
		String refTime;
		String submittedtime;
		log.info(" Comparing Effective Times for " + elementName);
		
		// Compare low time values
		if(lowPresent && subTime.getLowPresent() ) {

			if(low.getValue().length() >= 8)
				refTime = low.getValue().substring(0,8);
			else 
				refTime = low.getValue();
			
			if(subTime.getLow().getValue().length() >= 8)
				submittedtime = subTime.getLow().getValue().substring(0,8);
			else 
				submittedtime = subTime.getLow().getValue();
			
			if(refTime.equalsIgnoreCase(submittedtime) ) {
				log.info("Low Time element matches");
			}
			else {
				String error = "The " + elementName + " (Effective Time: low time value) is " + low.getValue() + " , but submitted CCDA (Effective Time: low time value) is " + subTime.getLow().getValue() + " which does not match ";
				ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
				results.add(rs);
			}
			
						
		}
		else if(lowPresent && !subTime.getLowPresent()) {
			
			String error = "The " + elementName + " (low time value) is required, but submitted CCDA does not contain the (low time value) for " + elementName;
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
		}
		else if(!lowPresent && subTime.getLowPresent()) {
			
			String error = "The " + elementName + " (low time value) is not required, but submitted CCDA contains the (low time value) for " + elementName;
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
		}
		else {
			log.info("Low value absent in both refernce and submitted models ");
		}
		
		// Compare High Times values
		if(highPresent && subTime.getHighPresent() ) {

			if(high.getValue().length() >= 8)
				refTime = high.getValue().substring(0,8);
			else 
				refTime = high.getValue();
			
			if(subTime.getHigh().getValue().length() >= 8)
				submittedtime = subTime.getHigh().getValue().substring(0,8);
			else 
				submittedtime = subTime.getHigh().getValue();
			
			if(refTime.equalsIgnoreCase(submittedtime) ) {
				log.info("High Time element matches");
			}
			else {
				String error = "The " + elementName + " (Effective Time: High time value) is " + high.getValue() + " , but submitted CCDA (Effective Time: High time value) is " + subTime.getHigh().getValue() + " which does not match ";
				ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
				results.add(rs);
			}
						
		}
		else if(highPresent && !subTime.getHighPresent()) {
			
			String error = "The " + elementName + " (high time value) is required, but submitted CCDA does not contain the (high time value) for " + elementName;
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
		}
		else if(!highPresent && subTime.getHighPresent()) {
			
			String error = "The " + elementName + " (high time value) is not required, but submitted CCDA contains the (high time value) for " + elementName;
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
		}
		else {
			log.info("High value absent in both refernce and submitted models ");
		}
	 
		// Compare Time value element
/*		if(valuePresent && subTime.getValuePresent() ) {

			if(value.getValue().length() >= 8)
				refTime = value.getValue().substring(0,8);
			else 
				refTime = value.getValue();

			if(subTime.getValue().getValue().length() >= 8)
				submittedtime = subTime.getValue().getValue().substring(0,8);
			else 
				submittedtime = subTime.getValue().getValue();

			if(refTime.equalsIgnoreCase(submittedtime) ) {
				log.info("Value Time element matches");
			}
			else {
				String error = "The " + elementName + " (Effective Time: Value ) is " + value.getValue() + " , but submitted CCDA (Effective Time: Value ) is " + subTime.getValue().getValue() + " which does not match ";
				ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
				results.add(rs);
			}

		}
		else if(valuePresent && !subTime.getValuePresent()) {

			String error = "The " + elementName + " (value time element ) is required, but submitted CCDA does not contain the (value time element) for " + elementName;
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
		}
		else if(!valuePresent && subTime.getValuePresent()) {

			String error = "The " + elementName + " (value time element) is not required, but submitted CCDA contains the (value time element) for " + elementName;
			ContentValidationResult rs = new ContentValidationResult(error, ContentValidationResultLevel.ERROR, "/ClinicalDocument", "0" );
			results.add(rs);
		}
		else {
			log.info("Value Time elements absent in both refernce and submitted models ");
		}*/
	}
	
	public void log() {
		
		log.info("Eff Time Low = " + (lowPresent ? low.getValue() : "No Low"));
		log.info("Eff Time High = " + (highPresent ? high.getValue() : "No High"));
		log.info("Eff Time Value = " + (valuePresent ? value.getValue() : "No Value"));
		log.info(" Single Admin = " + singleAdministration);
	}
	
	public String getSingleAdministration() {
		return singleAdministration;
	}

	public void setSingleAdministration(String singleAdministration) {
		this.singleAdministration = singleAdministration;
	}

	public CCDADataElement getLow() {
		return low;
	}

	public void setLow(CCDADataElement l) {
		
		if(l != null)
		{
			this.low = l;
			lowPresent = true;
		}
	}

	public Boolean getLowPresent() {
		return lowPresent;
	}

	public CCDADataElement getHigh() {
		return high;
	}

	public void setHigh(CCDADataElement h) {
		
		if(h != null)
		{
			this.high = h;
			highPresent = true;
		}
	}

	public Boolean getHighPresent() {
		return highPresent;
	}

	public CCDADataElement getValue() {
		return value;
	}

	public void setValue(CCDADataElement v) {
		
		if(v != null)
		{
			this.value = v;
			valuePresent = true;
		}
	}

	public Boolean getValuePresent() {
		return valuePresent;
	}

	public CCDAEffTime()
	{
		valuePresent = false;
		lowPresent = false;
		highPresent = false;
	}
}
