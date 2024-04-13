package ar.edu.unq.po2.tp3;

import java.util.List;

public class WorkTeam {

	private String name;
	private List<Person> members;
	
	public WorkTeam(String name, List<Person> members) {
		super();
		this.setName(name);
		this.setMembers(members);
	}
	private void setName(String name) {
		this.name = name;
	}
	private void setMembers(List<Person> members) {
		this.members = members;
	}
	public String getName() {
		return name;
	}
	public List<Person> getMembers() {
		return members;
	}
	public double averageAge() {
		return members.stream()
				.mapToDouble(member -> member.age())
				.average().getAsDouble();
				//collect(Collectors.averagingDouble(member -> member.age()));
	}

}
