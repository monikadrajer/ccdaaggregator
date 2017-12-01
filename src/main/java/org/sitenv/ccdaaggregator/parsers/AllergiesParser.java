package org.sitenv.ccdaaggregator.parsers;

import org.apache.log4j.Logger;
import org.sitenv.ccdaaggregator.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import java.util.ArrayList;

public class AllergiesParser {
	
	private static Logger log = Logger.getLogger(AllergiesParser.class.getName());
	
	public static void parse(Document doc, CCDARefModel model) throws XPathExpressionException {
    	
    	log.info(" *** Parsing Allergies *** ");
    	model.setAllergy(retrieveAllergiesDetails(doc));	
	}
	
	public static CCDAAllergy retrieveAllergiesDetails(Document doc) throws XPathExpressionException
	{
		CCDAAllergy allergies = null;
		Element sectionElement = (Element) CCDAConstants.ALLERGIES_EXPRESSION.evaluate(doc, XPathConstants.NODE);
		
		if(sectionElement != null)
		{
			log.info("Adding Allergy ");
			allergies = new CCDAAllergy();
			allergies.setSectionTemplateId(ParserUtilities.readTemplateIdList((NodeList) CCDAConstants.REL_TEMPLATE_ID_EXP.
							evaluate(sectionElement, XPathConstants.NODESET)));
			
			allergies.setSectionCode(ParserUtilities.readCode((Element) CCDAConstants.REL_CODE_EXP.
					evaluate(sectionElement, XPathConstants.NODE)));
			
			allergies.setAllergyConcern(readAllergyConcern((NodeList) CCDAConstants.REL_ACT_ENTRY_EXP.
					evaluate(sectionElement, XPathConstants.NODESET)));
		}
		return allergies;
	}
	
	public static ArrayList<CCDAAllergyConcern> readAllergyConcern(NodeList allergyConcernNodeList) throws XPathExpressionException
	{
		ArrayList<CCDAAllergyConcern> allergyConcernList = new ArrayList<>();;
		CCDAAllergyConcern allergyConcern;
		
		for (int i = 0; i < allergyConcernNodeList.getLength(); i++) {
			
			log.info("Adding Allergy Concern ");
			allergyConcern = new CCDAAllergyConcern();
			Element allergyConcernElement = (Element) allergyConcernNodeList.item(i);
			allergyConcern.setTemplateId(ParserUtilities.readTemplateIdList((NodeList) CCDAConstants.REL_TEMPLATE_ID_EXP.
																evaluate(allergyConcernElement, XPathConstants.NODESET)));
			
			allergyConcern.setConcernCode(ParserUtilities.readCode((Element) CCDAConstants.REL_CODE_EXP.
					evaluate(allergyConcernElement, XPathConstants.NODE)));
			
			allergyConcern.setStatusCode(ParserUtilities.readCode((Element) CCDAConstants.REL_STATUS_CODE_EXP.
					evaluate(allergyConcernElement, XPathConstants.NODE)));
			
			allergyConcern.setEffTime(ParserUtilities.readEffectiveTime((Element) CCDAConstants.REL_EFF_TIME_EXP.
					evaluate(allergyConcernElement, XPathConstants.NODE)));
			
			NodeList allergyObservationNodeList = (NodeList) CCDAConstants.REL_ENTRY_RELSHIP_OBS_EXP.
								evaluate(allergyConcernElement, XPathConstants.NODESET);
			
			allergyConcern.setAllergyObs(readAllergyObservation((NodeList) CCDAConstants.REL_ENTRY_RELSHIP_OBS_EXP.
					evaluate(allergyConcernElement, XPathConstants.NODESET)));
			
			allergyConcernList.add(allergyConcern);
		}
		return allergyConcernList;
	}
	
	
	public static ArrayList<CCDAAllergyObs> readAllergyObservation(NodeList allergyObservationNodeList) throws XPathExpressionException
	{
		ArrayList<CCDAAllergyObs> allergyObservationList = new ArrayList<>();;
		CCDAAllergyObs allergyObservation;
		
		for (int i = 0; i < allergyObservationNodeList.getLength(); i++) {
			
			log.info("Adding Allergy Observation ");
			allergyObservation = new CCDAAllergyObs();
			Element allergyObservationElement = (Element) allergyObservationNodeList.item(i);
			allergyObservation.setTemplateId(ParserUtilities.readTemplateIdList((NodeList) CCDAConstants.REL_TEMPLATE_ID_EXP.
												evaluate(allergyObservationElement, XPathConstants.NODESET)));
			
			allergyObservation.setAllergyIntoleranceType(ParserUtilities.readCode((Element) CCDAConstants.REL_VAL_EXP.
					evaluate(allergyObservationElement, XPathConstants.NODE)));
			
			allergyObservation.setAllergySubstance(ParserUtilities.readCode((Element) CCDAConstants.REL_PART_PLAY_ENTITY_CODE_EXP.
					evaluate(allergyObservationElement, XPathConstants.NODE)));
			
			allergyObservation.setEffTime(ParserUtilities.readEffectiveTime((Element) CCDAConstants.REL_EFF_TIME_EXP.
					evaluate(allergyObservationElement, XPathConstants.NODE)));
			
			allergyObservation.setReactions(readAllergyReaction((NodeList) CCDAConstants.REL_ALLERGY_REACTION_EXPRESSION.
																evaluate(allergyObservationElement, XPathConstants.NODESET)));
		
			allergyObservationList.add(allergyObservation);
		}
	    return allergyObservationList;
	}
	
	
	public static ArrayList<CCDAAllergyReaction> readAllergyReaction(NodeList allergyReactionNodeList) throws XPathExpressionException 
	{
			CCDAAllergyReaction allergyReaction = null;
			Element allergyReactionElement = null;
			ArrayList<CCDAAllergyReaction> allergyReactionList = new ArrayList<>();
			
			for (int j = 0; j < allergyReactionNodeList.getLength(); j++) {
				
				log.info("Adding Allergy Reaction ");
				allergyReaction = new CCDAAllergyReaction();
				allergyReactionElement = (Element) allergyReactionNodeList.item(j);
				
				allergyReaction.setTemplateIds(ParserUtilities.readTemplateIdList((NodeList) CCDAConstants.REL_TEMPLATE_ID_EXP.
													evaluate(allergyReactionElement, XPathConstants.NODESET)));
				
				allergyReaction.setReactionCode(ParserUtilities.readCode((Element) CCDAConstants.REL_VAL_EXP.
						evaluate(allergyReactionElement, XPathConstants.NODE)));
			
				allergyReaction.setSeverity(readAllergySeverity((Element) CCDAConstants.REL_ALLERGY_SEVERITY_EXPRESSION.
																evaluate(allergyReactionElement, XPathConstants.NODE)));
				allergyReactionList.add(allergyReaction);
			}
			return allergyReactionList;		
	}
	
	public static CCDAAllergySeverity readAllergySeverity(Element allergySeverityElement) throws XPathExpressionException
	{
		if (allergySeverityElement != null) {
			log.info("Adding Allergy Severity ");
			
			CCDAAllergySeverity allergySeverity = new CCDAAllergySeverity();
			allergySeverity
					.setTemplateIds(ParserUtilities
							.readTemplateIdList((NodeList) CCDAConstants.REL_TEMPLATE_ID_EXP
									.evaluate(allergySeverityElement,
											XPathConstants.NODESET)));

			allergySeverity.setSeverity(ParserUtilities
					.readCode((Element) CCDAConstants.REL_VAL_EXP.evaluate(
							allergySeverityElement, XPathConstants.NODE)));

			return allergySeverity;
		}
			
		return null;
	}

}
