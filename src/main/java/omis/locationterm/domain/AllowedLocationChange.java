package omis.locationterm.domain;

import java.io.Serializable;

import omis.location.domain.Location;
import omis.supervision.domain.CorrectionalStatus;

/**
 * Allowed location change.
 *
 * @author Stephen Abson
 * @version 0.0.1 (Mar 4, 2015)
 * @since OMIS 3.0
 */
public interface AllowedLocationChange
		extends Serializable {

	/**
	 * Sets ID.
	 * 
	 * @param id ID
	 */
	void setId(Long id);
	
	/**
	 * Returns ID.
	 * 
	 * @return ID
	 */
	Long getId();
	
	/**
	 * Sets action.
	 * 
	 * @param action action
	 */
	void setAction(LocationTermChangeAction action);
	
	/**
	 * Returns action.
	 * 
	 * @return action
	 */
	LocationTermChangeAction getAction();
	
	/**
	 * Sets correctional status.
	 * 
	 * @param correctionalStatus correctional status
	 */
	void setCorrectionalStatus(CorrectionalStatus correctionalStatus);
	
	/**
	 * Returns correctional status.
	 * 
	 * @return correctional status
	 */
	CorrectionalStatus getCorrectionalStatus();
	
	/**
	 * Sets location.
	 * 
	 * @param location location
	 */
	void setLocation(Location location);
	
	/**
	 * Returns location.
	 * 
	 * @return location
	 */
	Location getLocation();
	
	/**
	 * Compares {@code this} and {@code obj} for equality.
	 * 
	 * <p>Any mandatory property may be used in the comparison. If a  mandatory
	 * property of {@code this} that is used in the comparison is {@code null}
	 * an {@code IllegalStateException} will be thrown.
	 * 
	 * @param obj reference object with which to compare {@code this}
	 * @return {@code true} if {@code this} and {@code obj} are equal;
	 * {@code false} otherwise
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the comparison is {@code null} 
	 */
	@Override
	boolean equals(Object obj);
	
	/**
	 * Returns a hash code for {@code this}.
	 * 
	 * <p>Any mandatory property of {@code this} may be used in the hash code.
	 * If a mandatory property that is used in the hash code is {@code null} an
	 * {@code IllegalStateException} will be thrown.
	 * 
	 * @return hash code
	 * @throws IllegalStateException if a mandatory property of {@code this}
	 * that is used in the hash code is {@code null}
	 */
	@Override
	int hashCode();
}