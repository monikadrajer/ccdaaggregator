package org.sitenv.ccdaaggregator.service;

import org.sitenv.ccdaaggregator.configuration.CCDAAggregatorSingleton;
import org.sitenv.ccdaaggregator.model.AggregatedData;
import org.sitenv.ccdaaggregator.model.CCDARefModel;
import org.sitenv.ccdaaggregator.model.PatientAggregatedData;
import org.sitenv.ccdaaggregator.parsers.CCDAParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Component
public class CcdaAggregatorService {

	@Autowired
	private CCDAParser parser;

	public void processCcdaFiles(String queryId, List<MultipartFile> ccdaFiles) throws IOException {
		
		PatientAggregatedData patientAggregateData = new PatientAggregatedData();
		AggregatedData aggregatedData = new AggregatedData();
		CCDARefModel ccdaRefModel = null;
		for(MultipartFile ccdaFile : ccdaFiles){
			ccdaRefModel = parser.parse(ccdaFile.getInputStream());
			populatePatientAggregateData(patientAggregateData, ccdaRefModel);
		}
		
		aggregatedData.getAggregatedDataMap().put(queryId, patientAggregateData);
		CCDAAggregatorSingleton.getInstance().getAggregatorList().add(aggregatedData);
	}

	private void populatePatientAggregateData(PatientAggregatedData patientAggregatedData, CCDARefModel ccdaRefModel)
	{
		if(ccdaRefModel!=null){
			if(patientAggregatedData.getPatient() == null && ccdaRefModel.getPatient()!=null){
				patientAggregatedData.setPatient(ccdaRefModel.getPatient());
			}
			
			if(ccdaRefModel.getMembers()!=null){
				patientAggregatedData.getMembers().add(ccdaRefModel.getMembers());
			}
			
			if(ccdaRefModel.getEncounter()!=null){
				patientAggregatedData.getEncounters().add(ccdaRefModel.getEncounter());
			}
			
			if(ccdaRefModel.getAdmissionDiagnosis()!=null){
				patientAggregatedData.getAdmissionDiagnosis().add(ccdaRefModel.getAdmissionDiagnosis());
			}
			
			if(ccdaRefModel.getDischargeDiagnosis()!=null){
				patientAggregatedData.getDischargeDiagnosis().add(ccdaRefModel.getDischargeDiagnosis());
			}
			
			if(ccdaRefModel.getAllergy()!=null){
				patientAggregatedData.getAllergies().add(ccdaRefModel.getAllergy());
			}
			
			if(ccdaRefModel.getMedication()!=null){
				patientAggregatedData.getMedications().add(ccdaRefModel.getMedication());
			}
			
			if(ccdaRefModel.getDischargeDiagnosis()!=null){
				patientAggregatedData.getDischargeDiagnosis().add(ccdaRefModel.getDischargeDiagnosis());
			}
			
			if(ccdaRefModel.getImmunization()!=null){
				patientAggregatedData.getImmunizations().add(ccdaRefModel.getImmunization());
			}
			
			if(ccdaRefModel.getLabResults()!=null){
				patientAggregatedData.getLabResults().add(ccdaRefModel.getLabResults());
			}
			
			if(ccdaRefModel.getLabTests()!=null){
				patientAggregatedData.getLabTests().add(ccdaRefModel.getLabTests());
			}
			
			if(ccdaRefModel.getProcedure()!=null){
				patientAggregatedData.getProcedures().add(ccdaRefModel.getProcedure());
			}
			
			if(ccdaRefModel.getSocialHistory()!=null){
				patientAggregatedData.getSocialHistory().add(ccdaRefModel.getSocialHistory());
			}
			
			if(ccdaRefModel.getVitalSigns()!=null){
				patientAggregatedData.getVitalSigns().add(ccdaRefModel.getVitalSigns());
			}
			
			if(ccdaRefModel.getProblem()!=null){
				patientAggregatedData.getProblems().add(ccdaRefModel.getProblem());
			}
			
			if(ccdaRefModel.getPlanOfTreatment()!=null){
				patientAggregatedData.getPlanOfTreatment().add(ccdaRefModel.getPlanOfTreatment());
			}
			
			if(ccdaRefModel.getGoals()!=null){
				patientAggregatedData.getGoals().add(ccdaRefModel.getGoals());
			}
			
			if(ccdaRefModel.getHcs()!=null){
				patientAggregatedData.getHcs().add(ccdaRefModel.getHcs());
			}
			
			if(ccdaRefModel.getMedEquipments()!=null){
				patientAggregatedData.getMedEquipments().add(ccdaRefModel.getMedEquipments());
			}
				
		}
		
		
	}
}
