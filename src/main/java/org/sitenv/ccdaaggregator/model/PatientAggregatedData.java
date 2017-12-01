package org.sitenv.ccdaaggregator.model;

import java.util.ArrayList;
import java.util.List;

public class PatientAggregatedData {
	
	private CCDAPatient        patient;
	private List<CCDACareTeamMember> members;
	private List<CCDAEncounter>      encounters;
	private List<CCDAAdmissionDiagnosis> admissionDiagnosis;
	private List<CCDADischargeDiagnosis> dischargeDiagnosis;
	private List<CCDAAllergy>      allergies;
	private List<CCDAMedication>     medications;
	private List<CCDADischargeMedication> dischargeMedications;
	private List<CCDAImmunization>   immunizations;
	private List<CCDALabResult>      labResults;
	private List<CCDALabResult>  	   labTests;
	private List<CCDAProcedure>      procedures;
	private List<CCDASocialHistory>  socialHistory;
	private List<CCDAVitalSigns>     vitalSigns;
	private List<CCDAProblem>        problems;
	private List<CCDAPlanOfTreatment> planOfTreatment;
	private List<CCDAGoals>          goals;
	private List<CCDAHealthConcerns> hcs;
	private List<CCDAMedicalEquipment> medEquipments;
	private ArrayList<CCDAUDI> udi;
	public CCDAPatient getPatient() {
		return patient;
	}
	public void setPatient(CCDAPatient patient) {
		this.patient = patient;
	}
	public List<CCDACareTeamMember> getMembers() {
		return members==null? new ArrayList<CCDACareTeamMember>():members;
	}
	public void setMembers(List<CCDACareTeamMember> members) {
		this.members = members;
	}
	public List<CCDAEncounter> getEncounters() {
		return encounters==null? new ArrayList<CCDAEncounter>():encounters;
	}
	public void setEncounters(List<CCDAEncounter> encounters) {
		this.encounters = encounters;
	}
	public List<CCDAAdmissionDiagnosis> getAdmissionDiagnosis() {
		return admissionDiagnosis==null? new ArrayList<CCDAAdmissionDiagnosis>():admissionDiagnosis;
	}
	public void setAdmissionDiagnosis(List<CCDAAdmissionDiagnosis> admissionDiagnosis) {
		this.admissionDiagnosis = admissionDiagnosis;
	}
	public List<CCDADischargeDiagnosis> getDischargeDiagnosis() {
		return dischargeDiagnosis==null? new ArrayList<CCDADischargeDiagnosis>():dischargeDiagnosis;
	}
	public void setDischargeDiagnosis(List<CCDADischargeDiagnosis> dischargeDiagnosis) {
		this.dischargeDiagnosis = dischargeDiagnosis;
	}
	public List<CCDAAllergy> getAllergies() {
		return allergies==null? new ArrayList<CCDAAllergy>():allergies;
	}
	public void setAllergies(List<CCDAAllergy> allergies) {
		this.allergies = allergies;
	}
	public List<CCDAMedication> getMedications() {
		return medications==null? new ArrayList<CCDAMedication>():medications;
	}
	public void setMedications(List<CCDAMedication> medications) {
		this.medications = medications;
	}
	public List<CCDADischargeMedication> getDischargeMedications() {
		return dischargeMedications==null? new ArrayList<CCDADischargeMedication>():dischargeMedications;
	}
	public void setDischargeMedications(List<CCDADischargeMedication> dischargeMedications) {
		this.dischargeMedications = dischargeMedications;
	}
	public List<CCDAImmunization> getImmunizations() {
		return immunizations==null? new ArrayList<CCDAImmunization>():immunizations;
	}
	public void setImmunizations(List<CCDAImmunization> immunizations) {
		this.immunizations = immunizations;
	}
	public List<CCDALabResult> getLabResults() {
		return labResults==null? new ArrayList<CCDALabResult>():labResults;
	}
	public void setLabResults(List<CCDALabResult> labResults) {
		this.labResults = labResults;
	}
	public List<CCDALabResult> getLabTests() {
		return labTests==null? new ArrayList<CCDALabResult>():labTests;
	}
	public void setLabTests(List<CCDALabResult> labTests) {
		this.labTests = labTests;
	}
	public List<CCDAProcedure> getProcedures() {
		return procedures==null? new ArrayList<CCDAProcedure>():procedures;
	}
	public void setProcedures(List<CCDAProcedure> procedures) {
		this.procedures = procedures;
	}
	public List<CCDASocialHistory> getSocialHistory() {
		return socialHistory==null? new ArrayList<CCDASocialHistory>():socialHistory;
	}
	public void setSocialHistory(List<CCDASocialHistory> socialHistory) {
		this.socialHistory = socialHistory;
	}
	public List<CCDAVitalSigns> getVitalSigns() {
		return vitalSigns==null? new ArrayList<CCDAVitalSigns>():vitalSigns;
	}
	public void setVitalSigns(List<CCDAVitalSigns> vitalSigns) {
		this.vitalSigns = vitalSigns;
	}
	public List<CCDAProblem> getProblems() {
		return problems==null? new ArrayList<CCDAProblem>():problems;
	}
	public void setProblems(List<CCDAProblem> problems) {
		this.problems = problems;
	}
	public List<CCDAPlanOfTreatment> getPlanOfTreatment() {
		return planOfTreatment==null? new ArrayList<CCDAPlanOfTreatment>():planOfTreatment;
	}
	public void setPlanOfTreatment(List<CCDAPlanOfTreatment> planOfTreatment) {
		this.planOfTreatment = planOfTreatment;
	}
	public List<CCDAGoals> getGoals() {
		return goals==null? new ArrayList<CCDAGoals>():goals;
	}
	public void setGoals(List<CCDAGoals> goals) {
		this.goals = goals;
	}
	public List<CCDAHealthConcerns> getHcs() {
		return hcs==null? new ArrayList<CCDAHealthConcerns>():hcs;
	}
	public void setHcs(List<CCDAHealthConcerns> hcs) {
		this.hcs = hcs;
	}
	public List<CCDAMedicalEquipment> getMedEquipments() {
		return medEquipments==null? new ArrayList<CCDAMedicalEquipment>():medEquipments;
	}
	public void setMedEquipments(List<CCDAMedicalEquipment> medEquipments) {
		this.medEquipments = medEquipments;
	}
	public ArrayList<CCDAUDI> getUdi() {
		return udi;
	}
	public void setUdi(ArrayList<CCDAUDI> udi) {
		this.udi = udi;
	}
}
