package omis.search.report.service;

import java.util.List;

import omis.search.report.PersonSearchResult;

/** Service for person searches.
 * @author Ryan Johns
 * @author Annie Wahl
 * @version 0.1.1 (Mar 20, 2019)
 * @since OMIS 3.0 */
public interface PersonSearchReportService {

	/** find by id.
	 * @param id id.
	 * @return person search result. */
	PersonSearchResult findById(Long id);

	/** find person names by unspecified search criteria.
	 * @param searchCriteria search criteria string.
	 * @param includeSsn whether to include ssn search
	 * @return collection of persons. */
	List<PersonSearchResult> findPersonNamesByUnspecified(
			final String searchCriteria, final Boolean includeSsn);

	/** Returns person names with specified name search criteria.
	 * @param name1 first or last
	 * @param name2 first or last
	 * @return list of person names. */
	List<PersonSearchResult> findPersonNamesByNameSearch(final String name1,
			final String name2);

	/** Returns person names with specified name search criteria.
	 * @param first first name.
	 * @param middle middle name.
	 * @param last last name.:w
	 * @return list of person names. */
	List<PersonSearchResult> findPersonNamesByNameSearch(final String first,
			final String middle, final String last);

	/** Returns person names with last name equaling search criteria.
	 * @param name name.
	 * @return list of person names. */
	List<PersonSearchResult> findPersonNamesByLastName(final String name);
}
