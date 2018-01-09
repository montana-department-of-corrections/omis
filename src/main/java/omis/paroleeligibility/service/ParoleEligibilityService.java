package omis.paroleeligibility.service;

import java.util.Date;
import java.util.List;

import omis.exception.DuplicateEntityFoundException;
import omis.offender.domain.Offender;
import omis.paroleeligibility.domain.AppearanceCategory;
import omis.paroleeligibility.domain.EligibilityStatusCategory;
import omis.paroleeligibility.domain.EligibilityStatusReason;
import omis.paroleeligibility.domain.ParoleEligibility;
import omis.paroleeligibility.domain.ParoleEligibilityNote;

/**
 * Parole eligibility service.
 *
 * @author Trevor Isles
 * @version 0.1.0 (Nov 8, 2017)
 * @since OMIS 3.0
 */
public interface ParoleEligibilityService {
	
	/**
	 * Creates a new parole eligibility.
	 * 
	 * @param offender - offender
	 * @param hearingEligibilityDate - hearing eligibility date
	 * @param appearanceCategory - appearance category
	 * @param statusCategory - eligibility status category
	 * @param statusDate - eligibility status date
	 * @param statusReason - eligibility status reason
	 * @param statusComment - eligibility status comment
	 * @param reviewDate - review date
	 * @throws DuplicateEntityFoundException if new parole eligibility already
	 * exists
	 */
	ParoleEligibility create(
			Offender offender, Date hearingEligibilityDate, 
			AppearanceCategory appearanceCategory, 
			EligibilityStatusCategory statusCategory, Date statusDate,
			EligibilityStatusReason statusReason, String statusComment,
			Date reviewDate)
		throws DuplicateEntityFoundException;
	
	/**
	 * Updates an existing parole eligibility.
	 * 
	 * @param paroleEligibility - parole eligibility
	 * @param hearingEligibilityDate - hearing eligibility date
	 * @param appearanceCategory - appearance category
	 * @param statusCategory - eligibility status category
	 * @param statusDate - eligibility status date
	 * @param statusReason - eligibility status reason
	 * @param statusComment - eligibility status comment
	 * @param reviewDate - review date
	 * @throws DuplicateEntityFoundException if new parole eligibility already
	 * exists
	 */
	ParoleEligibility update(
			ParoleEligibility paroleEligibility, Date hearingEligibilityDate, 
			AppearanceCategory appearanceCategory, 
			EligibilityStatusCategory statusCategory, Date statusDate,
			EligibilityStatusReason statusReason, String statusComment,
			Date reviewDate)
		throws DuplicateEntityFoundException;
	
	/**
	 * Removes an existing parole eligibility.
	 * 
	 * @param paroleEligibility - parole eligibility
	 *
	 */
	void remove(ParoleEligibility paroleEligibility);
	
	/**
	 * Creates a new parole eligibility note.
	 * 
	 * @param paroleEligibility - parole eligibility
	 * @param date - date
	 * @param description - description
	 * 
	 * @return created new parole eligibility note
	 * @throws DuplicateEntityFoundException if new parole eligibility note
	 * already exists.
	 */
	ParoleEligibilityNote createParoleEligibilityNote(
			ParoleEligibility paroleEligibility, Date date, 
			String description)
				throws DuplicateEntityFoundException;
	
	/**
	 * Updates a parole eligibility note for the specified offender.
	 * 
	 * @param note parole eligibility note
	 */		
	ParoleEligibilityNote updateParoleEligibilityNote(
			ParoleEligibilityNote paroleEligibilityNote, Date date, 
			String description)
				throws DuplicateEntityFoundException;
	
	/**
	 * Removes a parole eligibility note for the specified offender.
	 * 
	 * @param note parole eligibility note
	 */	
	void removeParoleEligiblityNote(ParoleEligibilityNote paroleEligibilityNote);
	
	/**
	 * Returns a list of parole eligibility notes by parole eligibility.
	 * 
	 * @return list of parole eligibility notes by parole eligibility
	 */
	List<ParoleEligibilityNote> findParoleEligibilityNotesByParoleEligibility(
			ParoleEligibility paroleEligibility);
	
	/**
	 * Returns a list of eligibility status reasons.
	 * 
	 * @return list of eligibility status reasons
	 */
	List<EligibilityStatusReason> findEligibilityStatusReasons();
	
	/**
	 * Returns a list of appearance categories.
	 * 
	 * @return list of appearance categories
	 */
	List<AppearanceCategory> findAppearanceCategories();
	
}