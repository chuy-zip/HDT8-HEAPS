
public class Patient implements Comparable<Patient>{
	
	private String name;
	private String condition;
	private String Priority;
	
	Patient(String Name, String cond, String prio){
		name = Name;
		condition = cond;
		Priority = prio;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}

	@Override
	public int compareTo(Patient o) {
		if(Priority.equals(o.getPriority())) {
			return 0;
		}
		
		else if(Priority.compareToIgnoreCase(o.getPriority()) < 0) {
			return -1;
		}
		return 1;
	}
	
	

}
