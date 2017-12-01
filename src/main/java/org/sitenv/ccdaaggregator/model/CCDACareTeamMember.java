package org.sitenv.ccdaaggregator.model;

import java.util.ArrayList;

public class CCDACareTeamMember {
	
	private ArrayList<CCDAParticipant> members;
	
	public void log() {
		
		for (int i = 0; i < members.size(); i++) {
			members.get(i).log();
		}
	}
	
	public CCDACareTeamMember()
	{
		members = new ArrayList<CCDAParticipant>();
	}

	public ArrayList<CCDAParticipant> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<CCDAParticipant> ms) {
		
		if(ms != null)
			this.members = ms;
	}
}
