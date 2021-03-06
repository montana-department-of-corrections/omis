/*
 * OMIS - Offender Management Information System
 * Copyright (C) 2011 - 2017 State of Montana
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package omis.presentenceinvestigation.report;

import java.util.Date;
import java.util.List;
import omis.person.domain.Person;
import omis.presentenceinvestigation.domain.PresentenceInvestigationRequest;
import omis.user.domain.UserAccount;

/** 
 * Report service for presentence investigation request summary.
 * 
 * @author Ryan Johns
 * @author Annie Wahl
 * @author Josh Divine
 * @version 0.1.4 (Jan 25, 2019)
 * @since OMIS 3.0
 */
public interface PresentenceInvestigationRequestSummaryReportService {
	
	/** 
	 * Returns a list of presentence investigation request summaries by staff 
	 * member that have been submitted.
	 * 
	 * @param user user
	 * @param startDate start date
	 * @param endDate end date
	 * @return list of presentence investigation summaries. 
	 */
	List<PresentenceInvestigationRequestSummary> 
		findSubmittedPresentenceInvestigationRequestSummariesByUser(
				UserAccount user, Date startDate, Date endDate);
	
	/**
	 * Returns a list of presentence investigation request summaries by
	 * offender.
	 * 
	 * @param offender - Person
	 * @return list of presentence investigation request summaries by offender
	 */
	List<PresentenceInvestigationRequestSummary> 
		findPresentenceInvestigationRequestSummariesByOffender(
				Person offender);
	
	/**
	 * Returns a presentence investigation request summary by specified
	 * presentence investigation request.
	 * 
	 * @param presentenceInvestigationRequest - presentence investigation 
	 * request
	 * @return presentence investigation request summary by specified
	 * presentence investigation request
	 */
	PresentenceInvestigationRequestSummary summarize(
			PresentenceInvestigationRequest presentenceInvestigationRequest);
	
	/**
	 * Returns a list of presentence investigation request summaries by staff 
	 * member that have not yet been submitted.
	 * 
	 * @param user user
	 * @param startDate start date
	 * @param endDate end date
	 * @return list of presentence investigation request summaries
	 */
	List<PresentenceInvestigationRequestSummary> 
			findUnsubmittedPresentenceInvestigationRequestSummariesByUser(
					UserAccount user, Date startDate, Date endDate);
	
	/**
	 * Returns a list of unsubmitted Presentence Investigation Request Summaries
	 * for the requests with subjects with the given name.
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param startDate start date
	 * @param endDate end date
	 * @return List of unsubmitted Presentence Investigation Request Summaries
	 * for the requests with subjects with the given name.
	 */
	List<PresentenceInvestigationRequestSummary>
		findUnsubmittedPresentenceInvestigationRequestSummariesByName(
			String firstName, String lastName, Date startDate, Date endDate);

	/**
	 * Returns a list of submitted Presentence Investigation Request Summaries
	 * for the requests with subjects with the given name.
	 * 
	 * @param firstName first name
	 * @param lastName last name
	 * @param startDate start date
	 * @param endDate end date
	 * @return List of submitted Presentence Investigation Request Summaries
	 * for the requests with subjects with the given name.
	 */
	List<PresentenceInvestigationRequestSummary>
		findSubmittedPresentenceInvestigationRequestSummariesByName(
			String firstName, String lastName, Date startDate, Date endDate);
}