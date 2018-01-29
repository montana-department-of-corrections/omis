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
package omis.trackeddocument.report.impl.hibernate;

import java.util.Date;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import omis.offender.domain.Offender;
import omis.trackeddocument.report.TrackedDocumentProfileItemReportService;

/**
 * Hibernate implementation of tracked document profile item.
 *
 * @author Sheronda Vaughn
 * @version 0.1.0 (Jan 16, 2018)
 * @since OMIS 3.0
 */
public class TrackedDocumentProfileItemReportServiceHibernateImpl 
	implements TrackedDocumentProfileItemReportService {

	private static final String 
		FIND_TRACKED_DOCUMENT_COUNT_BY_OFFENDER_AND_DATE_QUERY_NAME
		= "findTrackedDocumentCountByOffenderAndDate";
	
	private static final String OFFENDER_PARAM_NAME = "offender";
	
	private static final String EFFECTIVE_DATE_PARAM_NAME 
		= "effectiveDate";
	private final SessionFactory sessionFactory;
	
	/** Instantiates an implementation of 
	 * tracked document profile item report service hibernate impl */
	public TrackedDocumentProfileItemReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** {@inheritDoc} */
	@Override
	public Integer findTrackedDocumentsCountByOffenderAndDate(
			final Offender offender, final Date effectiveDate) {
		Query q = this.sessionFactory.getCurrentSession().getNamedQuery(
				FIND_TRACKED_DOCUMENT_COUNT_BY_OFFENDER_AND_DATE_QUERY_NAME);
		q.setEntity(OFFENDER_PARAM_NAME, offender);
		q.setDate(EFFECTIVE_DATE_PARAM_NAME, effectiveDate);
		return ((Long) q.uniqueResult()).intValue();
	}
}