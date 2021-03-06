package omis.task.web.form;

/**
 * TaskItemOperation.java
 * 
 *@author Annie Jacques 
 *@version 0.1.0 (Jun 13, 2017)
 *@since OMIS 3.0
 *
 */
public enum TaskItemOperation {
	
	/** Create. */
	CREATE,
	
	/** Update. */
	UPDATE,
	
	/** Remove. */
	REMOVE;
	
	/**
	 * Returns the name of the {@code this}.
	 * 
	 * @return name of {@code this}
	 */
	public String getName() {
		return this.name();
	}
	
	/**
	 * Returns the name.
	 * 
	 * @return name
	 */
	@Override
	public String toString() {
		return this.name();
	}
	
}
