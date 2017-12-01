package org.sitenv.ccdaaggregator.parsers;

import org.apache.log4j.Logger;
import org.sitenv.ccdaaggregator.model.CCDAPatient;
import org.sitenv.ccdaaggregator.model.CCDAPreferredLanguage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import java.util.ArrayList;

public class CCDAHeaderParser {
	
	private static Logger log = Logger.getLogger(CCDAHeaderParser.class.getName());

	static public CCDAPatient getPatient(Document doc) throws XPathExpressionException{
		
		CCDAPatient patient = null;
		
		// Retrieve the patient role element.
		NodeList nodeList = (NodeList) CCDAConstants.PATIENT_ROLE_EXP.evaluate(doc, XPathConstants.NODESET);
		
		for (int i = 0; i < nodeList.getLength(); i++) {
	    	
			log.info("Found Patient");
			
			// Retrieve the elements for population
			Element patientRoleElement = (Element) nodeList.item(i);
		    
	        patient= new CCDAPatient();
	        
	        patient.setAddresses(ParserUtilities.readAddressList((NodeList) CCDAConstants.REL_ADDR_EXP.
    					evaluate(patientRoleElement, XPathConstants.NODESET)));
	         
	        patient.setBirthPlace(ParserUtilities.readAddress((Element) CCDAConstants.REL_PATIENT_BIRTHPLACE_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE)));
	            
	        //Getting name of the patient
	        readName((Element) CCDAConstants.REL_PATIENT_NAME_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE), patient);
	        
	        // Read PRevious Name
	        readPreviousName((Element) CCDAConstants.REL_PATIENT_PREV_NAME_EXP.
    				evaluate(patientRoleElement, XPathConstants.NODE), patient);
	           
	        //Get Gender of the patient
	        patient.setAdminGender(ParserUtilities.readCode((Element) CCDAConstants.REL_PATIENT_ADMINGEN_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE)));
	            
	        //Get Birth time of the patient
	        patient.setDob(ParserUtilities.readDataElement((Element) CCDAConstants.REL_PATIENT_BIRTHTIME_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE)));
	            
	        //Get Marital status of the patient 
	        patient.setMaritalStatus(ParserUtilities.readCode((Element) CCDAConstants.REL_PATIENT_MARITAL_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE)));
	            
	        //Get religious affiliation Code
	        patient.setReligiousAffiliation(ParserUtilities.readCode((Element) CCDAConstants.REL_PATIENT_RELIGION_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE)));
	            
	        readRaceCodes((NodeList) CCDAConstants.REL_PATIENT_RACE_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODESET), patient);
	            
	        //Get ethnic Group code
	        patient.setEthnicity(ParserUtilities.readCode((Element) CCDAConstants.REL_PATIENT_ETHNICITY_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODE)));
	            
	        patient.setLanguageCommunication(readPreferredLanguage((NodeList) CCDAConstants.REL_PATIENT_LANGUAGE_EXP.
	    				evaluate(patientRoleElement, XPathConstants.NODESET)));	
	            
	        patient.setTelecom(ParserUtilities.readDataElementList((NodeList) CCDAConstants.REL_TELECOM_EXP.
	            					evaluate(patientRoleElement, XPathConstants.NODESET)));
	   }
		
		
		return patient;
	}
	
	public static void readRaceCodes(NodeList raceCodeList, CCDAPatient patient)
	{
		Element raceCodeElement= null;
		for (int i = 0; i < raceCodeList.getLength(); i++) {
			
			raceCodeElement = (Element) raceCodeList.item(i);
			if(raceCodeElement.getTagName().equals(CCDAConstants.RACE_EL_NAME))
			{
				patient.addRaceCode(ParserUtilities.readCode(raceCodeElement));
			}else
			{
				patient.addRaceCodeExt(ParserUtilities.readCode(raceCodeElement));
			}
		}
		
	}
	
	
	public static void readName(Element nameElement,CCDAPatient patient) throws XPathExpressionException
	{
		log.info(" Reading Name ");
		if(nameElement != null)
		{
			patient.setFirstName(ParserUtilities.readTextContext((Element) CCDAConstants.REL_GIVEN_NAME_EXP.
					evaluate(nameElement, XPathConstants.NODE)));
			patient.setMiddleName(ParserUtilities.readTextContext((Element) CCDAConstants.REL_MIDDLE_NAME_EXP.
					evaluate(nameElement, XPathConstants.NODE)));
			patient.setLastName(ParserUtilities.readTextContext((Element) CCDAConstants.REL_FAMILY_NAME_EXP.
					evaluate(nameElement, XPathConstants.NODE)));
			patient.setSuffix(ParserUtilities.readTextContext((Element) CCDAConstants.REL_SUFFIX_EXP.
					evaluate(nameElement, XPathConstants.NODE)));
			
			if(patient.getSuffix() != null && 
			   patient.getSuffix().getValue() != null) {
				log.info("Removing Special Characters in Suffix");
				patient.getSuffix().removeSpecialCharacters(".", "");
			}
		}
	}
	
	public static void readPreviousName(Element nameElement,CCDAPatient patient) throws XPathExpressionException
	{
		log.info(" Reading Previous Name ");
		if(nameElement != null)
		{
			patient.setPreviousName(ParserUtilities.readTextContext((Element) CCDAConstants.REL_GIVEN_PREV_NAME_EXP.
					evaluate(nameElement, XPathConstants.NODE)));
		}
	}
	
	public static ArrayList<CCDAPreferredLanguage> readPreferredLanguage(NodeList languageCommElementList ) throws XPathExpressionException
	{
		ArrayList<CCDAPreferredLanguage> preferredLanguageList = new ArrayList<>();
		CCDAPreferredLanguage preferredLanguage = null;
		for (int i = 0; i < languageCommElementList.getLength(); i++) {
			Element languageCommElement = (Element) languageCommElementList.item(i);
			if(languageCommElement != null)
			{
				preferredLanguage = new CCDAPreferredLanguage();
				preferredLanguage.setLanguageCode(ParserUtilities.readCode((Element) CCDAConstants.REL_LANG_CODE_EXP.
    				evaluate(languageCommElement, XPathConstants.NODE)));
				preferredLanguage.setModeCode(ParserUtilities.readCode((Element) CCDAConstants.REL_LANG_MODE_EXP.
    				evaluate(languageCommElement, XPathConstants.NODE)));
				preferredLanguage.setPreferenceInd(ParserUtilities.readDataElement((Element) CCDAConstants.REL_LANG_PREF_EXP.
    				evaluate(languageCommElement, XPathConstants.NODE)));
				preferredLanguageList.add(preferredLanguage);
			}
		}
		return preferredLanguageList;
	}
}
