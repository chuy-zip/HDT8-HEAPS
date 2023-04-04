
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
	    return Priority.compareTo(o.getPriority());
	}
	
	@Override
	public String toString() {
		return "Patient{name='" + name + "', condition='" + condition + "', priority='" + Priority + "'}";
	}
}


