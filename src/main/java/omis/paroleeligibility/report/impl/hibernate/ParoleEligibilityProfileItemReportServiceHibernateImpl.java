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
package omis.paroleeligibility.report.impl.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import omis.offender.domain.Offender;
import omis.paroleeligibility.report.ParoleEligibilityProfileItemReportService;

/**
 * Hibernate implementation of parole eligibility profile item.
 *
 * @author Trevor Isles
 * @version 0.1.0 (Jan 9, 2018)
 * @since OMIS 3.0
 */
public class ParoleEligibilityProfileItemReportServiceHibernateImpl 
	implements ParoleEligibilityProfileItemReportService {
	
	private static final String 
		FIND_PAROLE_ELIGIBILITY_COUNT_BY_ELIGIBILITIES_QUERY_NAME
			= "findParoleEligibilityCountByEligibilities";
	
	private static final String OFFENDER_PARAM_NAME = "offender";
	
	private final SessionFactory sessionFactory;
	
	/** Constructor
	 * @param sessionFactory - session factory
	 */
	public ParoleEligibilityProfileItemReportServiceHibernateImpl(
			final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** {@inheritDoc} */
	@Override
	public Long findParoleEligibilityCountByEligibilities(
			final Offender offender) {
		Query q = this.sessionFactory.getCurrentSession().getNamedQuery(
			FIND_PAROLE_ELIGIBILITY_COUNT_BY_ELIGIBILITIES_QUERY_NAME);
		q.setEntity(OFFENDER_PARAM_NAME, offender);
		return ((Long) q.uniqueResult());
	}
	
}
