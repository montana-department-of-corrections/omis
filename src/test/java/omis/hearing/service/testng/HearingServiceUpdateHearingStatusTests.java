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
package omis.hearing.service.testng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.testng.annotations.Test;

import omis.address.domain.Address;
import omis.address.domain.ZipCode;
import omis.address.service.delegate.AddressDelegate;
import omis.address.service.delegate.ZipCodeDelegate;
import omis.country.domain.Country;
import omis.country.service.delegate.CountryDelegate;
import omis.datatype.DateRange;
import omis.exception.DuplicateEntityFoundException;
import omis.hearing.domain.Hearing;
import omis.hearing.domain.HearingCategory;
import omis.hearing.domain.HearingStatus;
import omis.hearing.domain.HearingStatusCategory;
import omis.hearing.service.HearingService;
import omis.hearing.service.delegate.HearingDelegate;
import omis.hearing.service.delegate.HearingStatusDelegate;
import omis.location.domain.Location;
import omis.location.service.delegate.LocationDelegate;
import omis.offender.domain.Offender;
import omis.offender.service.delegate.OffenderDelegate;
import omis.organization.domain.Organization;
import omis.organization.service.delegate.OrganizationDelegate;
import omis.person.domain.Person;
import omis.person.service.delegate.PersonDelegate;
import omis.region.domain.City;
import omis.region.domain.State;
import omis.region.service.delegate.CityDelegate;
import omis.region.service.delegate.StateDelegate;
import omis.testng.AbstractHibernateTransactionalTestNGSpringContextTests;
import omis.user.domain.UserAccount;
import omis.user.service.delegate.UserAccountDelegate;
import omis.util.PropertyValueAsserter;

/**
 * Tests method to update hearing statuses.
 *
 * @author Josh Divine
 * @version 0.1.0 (May 4, 2018)
 * @since OMIS 3.0
 */
@Test
public class HearingServiceUpdateHearingStatusTests
	extends AbstractHibernateTransactionalTestNGSpringContextTests {

	/* Delegates. */

	@Autowired
	private HearingStatusDelegate hearingStatusDelegate;

	@Autowired
	private HearingDelegate hearingDelegate;

	@Autowired
	private LocationDelegate locationDelegate;

	@Autowired
	private UserAccountDelegate userAccountDelegate;
	
	@Autowired
	private OrganizationDelegate organizationDelegate;
	
	@Autowired
	private CountryDelegate countryDelegate;
	
	@Autowired
	private StateDelegate stateDelegate;
	
	@Autowired
	private CityDelegate cityDelegate;
	
	@Autowired
	private ZipCodeDelegate zipCodeDelegate;
	
	@Autowired
	private AddressDelegate addressDelegate;
	
	@Autowired
	private PersonDelegate personDelegate;

	@Autowired
	private OffenderDelegate offenderDelegate;

	/* Services. */

	@Autowired
	@Qualifier("hearingService")
	private HearingService hearingService;

	/* Test methods. */

	/**
	 * Tests the update of the description for a hearing status.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateHearingStatusDescription() 
			throws DuplicateEntityFoundException {
		// Arrangements
		String description = "Description";
		Date date = this.parseDateText("05/04/2017");
		HearingStatusCategory category = HearingStatusCategory.HELD;
		HearingStatus hearingStatus = this.hearingStatusDelegate.create(
				createHearing(), description, date, category);
		String newDescription = "New Description";

		// Action
		hearingStatus = this.hearingService.updateHearingStatus(hearingStatus,
				newDescription, date, category);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("description", newDescription)
			.addExpectedValue("date", date)
			.addExpectedValue("category", category)
			.performAssertions(hearingStatus);
	}
	
	/**
	 * Tests the update of the date for a hearing status.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateHearingStatusDate() 
			throws DuplicateEntityFoundException {
		// Arrangements
		String description = "Description";
		Date date = this.parseDateText("05/04/2017");
		HearingStatusCategory category = HearingStatusCategory.HELD;
		HearingStatus hearingStatus = this.hearingStatusDelegate.create(
				createHearing(), description, date, category);
		Date newDate = this.parseDateText("05/05/2017");

		// Action
		hearingStatus = this.hearingService.updateHearingStatus(hearingStatus, 
				description, newDate, category);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("description", description)
			.addExpectedValue("date", newDate)
			.addExpectedValue("category", category)
			.performAssertions(hearingStatus);
	}
	
	/**
	 * Tests the update of the category for a hearing status.
	 * 
	 * @throws DuplicateEntityFoundException if duplicate entity exists
	 */
	@Test
	public void testUpdateHearingStatusCategory() 
			throws DuplicateEntityFoundException {
		// Arrangements
		String description = "Description";
		Date date = this.parseDateText("05/04/2017");
		HearingStatusCategory category = HearingStatusCategory.HELD;
		HearingStatus hearingStatus = this.hearingStatusDelegate.create(
				createHearing(), description, date, category);
		HearingStatusCategory newCategory = HearingStatusCategory.DELAYED;

		// Action
		hearingStatus = this.hearingService.updateHearingStatus(hearingStatus, 
				description, date, newCategory);

		// Assertions
		PropertyValueAsserter.create()
			.addExpectedValue("description", description)
			.addExpectedValue("date", date)
			.addExpectedValue("category", newCategory)
			.performAssertions(hearingStatus);
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
		String description = "Description";
		Date date = this.parseDateText("05/04/2017");
		HearingStatusCategory category = HearingStatusCategory.HELD;
		Hearing hearing = createHearing();
		this.hearingStatusDelegate.create(hearing, description, date, 
				category);
		Date secondDate = this.parseDateText("05/05/2017");
		HearingStatus hearingStatus = this.hearingStatusDelegate.create(hearing, 
				description, secondDate, category);
		
		// Action
		hearingStatus = this.hearingService.updateHearingStatus(hearingStatus, 
				description, date, category);
	}

	// Creates a hearing
	private Hearing createHearing() throws DuplicateEntityFoundException {
		Organization organization = this.organizationDelegate.create(
				"Organization", "org", null);
		Country country = this.countryDelegate.create("Country", "USA", true);
		State state = this.stateDelegate.create("State", "ST", country, true, 
				true);
		City city = this.cityDelegate.create("City", true, state, country);
		ZipCode zipCode = this.zipCodeDelegate.create(city, "12345", null, true);
		Address address = this.addressDelegate.findOrCreate("123", "321", null,
				null, zipCode);
		Person person = this.personDelegate.create("Pennyworth", "Alfred", "J", 
				null);
		Location location = this.locationDelegate.create(organization,
				new DateRange(this.parseDateText("01/01/2001"),
						this.parseDateText("01/01/2020")), address);
		Offender offender = this.offenderDelegate.createWithoutIdentity("Wayne", 
				"Bruce", "Alen", null);;
		UserAccount officer = this.userAccountDelegate.create(person, "USER", 
				"", null, 0, true);
		return this.hearingDelegate.create(location, offender, false, 
				this.parseDateText("05/04/2017"), HearingCategory.DISCIPLINARY, 
				officer);
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