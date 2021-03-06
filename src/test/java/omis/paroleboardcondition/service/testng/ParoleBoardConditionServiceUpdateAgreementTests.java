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
package omis.paroleboardcondition.service.testng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import omis.condition.domain.Agreement;
import omis.condition.domain.AgreementCategory;
import omis.condition.service.delegate.AgreementDelegate;
import omis.exception.DuplicateEntityFoundException;
import omis.offender.domain.Offender;
import omis.offender.service.delegate.OffenderDelegate;
import omis.paroleboardcondition.service.ParoleBoardConditionService;
import omis.testng.AbstractHibernateTransactionalTestNGSpringContextTests;
import omis.util.PropertyValueAsserter;

/**
 * Tests method to update agreements.
 *
 * @author Josh Divine
 * @version 0.0.1
 * @since OMIS 3.0
 */
@Test
public class ParoleBoardConditionServiceUpdateAgreementTests
	extends AbstractHibernateTransactionalTestNGSpringContextTests {

	/* Delegates. */

	@Autowired
	private OffenderDelegate offenderDelegate;
	
	@Autowired
	private AgreementDelegate agreementDelegate;
	
	/* Services. */

	@Autowired
	@Qualifier("paroleBoardConditionService")
	private ParoleBoardConditionService paroleBoardConditionService;

	/* Test methods. */

	/**
	 * Tests the update of the category for an agreement.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateAgreementCategory() 
			throws DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity(
				"Wayne", "Bruce", "Alen", null);
		Date startDate = this.parseDateText("05/12/2017");
		Date endDate = this.parseDateText("05/15/2019");
		String description = "Agreement Description";
		AgreementCategory agreementCategory =
				AgreementCategory.BOARD_PARDONS_PAROLE;
		Agreement agreement = this.agreementDelegate.create(offender, startDate, 
				endDate, description, agreementCategory);
		AgreementCategory newAgreementCategory = AgreementCategory.COURT_CASE;
		
		// Action
		agreement = this.paroleBoardConditionService.updateAgreement(agreement, 
				startDate, endDate, description, newAgreementCategory);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("offender", offender)
			.addExpectedValue("dateRange.startDate", startDate)
			.addExpectedValue("dateRange.endDate", endDate)
			.addExpectedValue("description", description)
			.addExpectedValue("category", newAgreementCategory)
			.performAssertions(agreement);
	}
	
	/**
	 * Tests the update of the start date for an agreement.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateAgreementStartDate() 
			throws DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity(
				"Wayne", "Bruce", "Alen", null);
		Date startDate = this.parseDateText("05/12/2017");
		Date endDate = this.parseDateText("05/15/2019");
		String description = "Agreement Description";
		AgreementCategory agreementCategory =
				AgreementCategory.BOARD_PARDONS_PAROLE;
		Agreement agreement = this.agreementDelegate.create(offender, startDate, 
				endDate, description, agreementCategory);
		Date newStartDate = this.parseDateText("05/13/2017");
		
		// Action
		agreement = this.paroleBoardConditionService.updateAgreement(agreement, 
				newStartDate, endDate, description, agreementCategory);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("offender", offender)
			.addExpectedValue("dateRange.startDate", newStartDate)
			.addExpectedValue("dateRange.endDate", endDate)
			.addExpectedValue("description", description)
			.addExpectedValue("category", agreementCategory)
			.performAssertions(agreement);
	}
	
	/**
	 * Tests the update of the end date for an agreement.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateAgreementEndDate() 
			throws DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity(
				"Wayne", "Bruce", "Alen", null);
		Date startDate = this.parseDateText("05/12/2017");
		Date endDate = this.parseDateText("05/15/2019");
		String description = "Agreement Description";
		AgreementCategory agreementCategory =
				AgreementCategory.BOARD_PARDONS_PAROLE;
		Agreement agreement = this.agreementDelegate.create(offender, startDate, 
				endDate, description, agreementCategory);
		Date newEndDate = this.parseDateText("05/15/2019");
		
		// Action
		agreement = this.paroleBoardConditionService.updateAgreement(agreement, 
				startDate, newEndDate, description, agreementCategory);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("offender", offender)
			.addExpectedValue("dateRange.startDate", startDate)
			.addExpectedValue("dateRange.endDate", newEndDate)
			.addExpectedValue("description", description)
			.addExpectedValue("category", agreementCategory)
			.performAssertions(agreement);
	}
	
	/**
	 * Tests the update of the description for an agreement.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateAgreementDescription() 
			throws DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity(
				"Wayne", "Bruce", "Alen", null);
		Date startDate = this.parseDateText("05/12/2017");
		Date endDate = this.parseDateText("05/15/2019");
		String description = "Agreement Description";
		AgreementCategory agreementCategory =
				AgreementCategory.BOARD_PARDONS_PAROLE;
		Agreement agreement = this.agreementDelegate.create(offender, startDate, 
				endDate, description, agreementCategory);
		String newDescription = "New Agreement Description";

		// Action
		agreement = this.paroleBoardConditionService.updateAgreement(agreement, 
				startDate, endDate, newDescription, agreementCategory);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("offender", offender)
			.addExpectedValue("dateRange.startDate", startDate)
			.addExpectedValue("dateRange.endDate", endDate)
			.addExpectedValue("description", newDescription)
			.addExpectedValue("category", agreementCategory)
			.performAssertions(agreement);
	}

	/**
	 * Tests {@code DuplicateEntityFoundException} is thrown.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test(expectedExceptions = {DuplicateEntityFoundException.class})
	public void testDuplicateEntityFoundException() 
			throws DuplicateEntityFoundException {
		// Arrangements
		Offender offender = this.offenderDelegate.createWithoutIdentity(
				"Wayne", "Bruce", "Alen", null);
		Date startDate = this.parseDateText("05/12/2017");
		Date endDate = this.parseDateText("05/15/2019");
		String description = "Agreement Description";
		AgreementCategory agreementCategory =
				AgreementCategory.BOARD_PARDONS_PAROLE;
		this.agreementDelegate.create(offender, startDate, endDate, description, 
				agreementCategory);
		Date secondStartDate = this.parseDateText("05/13/2017");
		Agreement agreement = this.agreementDelegate.create(offender, 
				secondStartDate, endDate, description, agreementCategory);
		
		// Action
		agreement = this.paroleBoardConditionService.updateAgreement(agreement, 
				startDate, endDate, description, agreementCategory);
	}

	// Parses date text
	private Date parseDateText(final String text) {
		try {
			return new SimpleDateFormat("MM/dd/yyyy").parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("Parse error", e);
		}
	}
}