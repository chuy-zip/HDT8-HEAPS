
public class Patient implements Comparable<Patient>{
	
	private String name;
	private String condition;
	private String Priority;
	
	public Patient(String Name, String cond, String prio){
		name = Name;
		condition = cond;
		Priority = prio;
	}

	/**
	 * The function returns the name as a string.
	 * 
	 * @return The method `getName()` is returning a `String` value, which is the value of the variable
	 * `name`.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This function sets the name of an object.
	 * 
	 * @param name The parameter "name" is a String type variable that represents the name of an object or
	 * entity. The method "setName" takes in a String value and sets it as the name of the object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This function returns the value of the "condition" variable as a string.
	 * 
	 * @return The method is returning a String value, which is the value of the variable "condition".
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * This is a Java function that sets the value of a variable called "condition".
	 * 
	 * @param condition The parameter "condition" is a String variable that is used to set the condition
	 * of an object. The "this" keyword refers to the current object instance.
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * This function returns the priority as a string.
	 * 
	 * @return The method is returning a String value which is the value of the variable "Priority".
	 */
	public String getPriority() {
		return Priority;
	}

	/**
	 * This is a Java function that sets the priority of a task.
	 * 
	 * @param priority The parameter "priority" is a String type variable that represents the priority of
	 * a task or an item. This method sets the value of the "Priority" variable to the value passed as an
	 * argument to the method.
	 */
	public void setPriority(String priority) {
		Priority = priority;
	}

	@Override
	// `public int compareTo(Patient o)` is a method that is used to compare two `Patient` objects based
	// on their priority. It is implementing the `Comparable` interface, which requires the implementation
	// of the `compareTo` method.
	public int compareTo(Patient o) {
	    return Priority.compareTo(o.getPriority());
	}
	
	@Override
	// The `toString()` method is used to convert an object to a string representation. In this case, the
	// `toString()` method is returning a string that represents the `Patient` object. It includes the
	// name, condition, and priority of the patient, formatted as a string. This method is often used for
	// debugging and logging purposes.
	public String toString() {
		return "Patient{name='" + name + "', condition='" + condition + "', priority='" + Priority + "'}";
	}
}


