package omis.hearing.web.validator;

import java.util.Date;
import java.util.EnumSet;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import omis.hearing.domain.DispositionCategory;
import omis.hearing.domain.HearingStatusCategory;
import omis.hearing.domain.ResolutionClassificationCategory;
import omis.hearing.web.form.ResolutionForm;

/**
 * ResolutionFormValidator.java
 * 
 *@author Annie Jacques 
 *@version 0.1.0 (Apr 20, 2017)
 *@since OMIS 3.0
 *
 */
public class ResolutionFormValidator implements Validator {
	
	private static final String CATEGORY_REQUIRED_MSG_KEY = "category.empty";
	
	private static final String STATUS_DESCRIPTION_REQUIRED_MSG_KEY =
			"description.required";
	
	private static final String ADJUDICATE_IN_FUTURE_MSG_KEY =
			"hearingStatus.adjudicate.inFuture";
	
	private static final String DISPOSITION_REQUIRED_MSG_KEY =
			"resolution.disposition.empty";
	
	private static final String SANCTION_REQUIRED_MESSAGE_KEY =
			"imposedSanction.sanction.empty";
	
	private static final String SANCTION_ONLY_ON_GUILTY_MSG_KEY =
			"imposedSanction.sanction.notOnGuilty";
	
	private static final String DECISION_REQUIRED_MSG_KEY =
			"resolution.decision.empty";
	
	private static final String REASON_REQUIRED_MSG_KEY =
			"resolution.reason.empty";
	
	private static final String DATE_REQUIRED_MSG_KEY = "date.empty";

	private static final String DECIDED_BY_REQUIRED_MSG_KEY =
			"resolution.authority.empty";

	/**{@inheritDoc} */
	@Override
	public boolean supports(final Class<?> clazz) {
		return ResolutionForm.class.isAssignableFrom(clazz);
	}

	/**{@inheritDoc} */
	@Override
	public void validate(final Object target, final Errors errors) {
		ResolutionForm form = (ResolutionForm) target;
		
		if(ResolutionClassificationCategory.FORMAL.equals(
				form.getResolutionCategory())){
			//validate hearing status properties
			ValidationUtils.rejectIfEmpty(errors, "date",
					DATE_REQUIRED_MSG_KEY);
			ValidationUtils.rejectIfEmpty(errors, "category",
					CATEGORY_REQUIRED_MSG_KEY);
			if(EnumSet.of(HearingStatusCategory.UPHELD,
					HearingStatusCategory.MODIFIED).contains(form.getCategory())){
				ValidationUtils.rejectIfEmptyOrWhitespace(errors,
						"statusDescription", STATUS_DESCRIPTION_REQUIRED_MSG_KEY);
			}
			if(form.getDate() != null){
				if(form.getDate().getTime() > new Date().getTime()){
					errors.rejectValue("date",
							ADJUDICATE_IN_FUTURE_MSG_KEY);
				}
			}
		}
		for(int i = 0; i < form.getViolationItems().size(); i++){
			switch (form.getResolutionCategory()){
				case FORMAL:
					//validate disposition
					ValidationUtils.rejectIfEmpty(errors,
							"violationItems[" + i + "].disposition",
							DISPOSITION_REQUIRED_MSG_KEY);
					if(!(DispositionCategory.GUILTY.equals(
							form.getViolationItems().get(i).getDisposition()))
							&& (form.getViolationItems().get(i).getSanction()
							!= null &&
							!form.getViolationItems().get(i).getSanction()
							.equals(""))){
						//Sanction is disabled when disposition is not Guilty,
						//but if anyone fiddled with the html source code,
						//then this will ensure that it remains only available
						//on Guilty dispositions
						errors.rejectValue("violationItems[" + i + "].sanction",
								SANCTION_ONLY_ON_GUILTY_MSG_KEY);
					}
				case INFORMAL:
					//validate sanction
					if((ResolutionClassificationCategory.FORMAL.equals(
							form.getResolutionCategory())
							&& DispositionCategory.GUILTY.equals(
									form.getViolationItems().get(i).getDisposition()))
							|| ResolutionClassificationCategory.INFORMAL.equals(
							form.getResolutionCategory())){
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"violationItems[" + i + "].sanction",
							SANCTION_REQUIRED_MESSAGE_KEY);
					}
				case DISMISSED:
					//if not formal, validate decision
					if(!(ResolutionClassificationCategory.FORMAL.equals(
							form.getResolutionCategory()))){
						ValidationUtils.rejectIfEmptyOrWhitespace(errors,
								"violationItems[" + i + "].decision",
								DECISION_REQUIRED_MSG_KEY);
					}
					//validate date and reason
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"violationItems[" + i + "].reason",
							REASON_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
							"violationItems[" + i + "].date",
							DATE_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
							"violationItems[" + i + "].authority",
							DECIDED_BY_REQUIRED_MSG_KEY);
				break;
				default:
					//validate resolutionCategory!
					throw new UnsupportedOperationException(
							"Resolution Category is not supported.");
			}
			if(form.getGroupEdit()) {
				break;
			}
		}
		
		if(form.getViolationItem() != null) {
			switch (form.getResolutionCategory()){
				case FORMAL:
					//validate disposition
					ValidationUtils.rejectIfEmpty(errors,
							"violationItem.disposition",
							DISPOSITION_REQUIRED_MSG_KEY);
					if(!(DispositionCategory.GUILTY.equals(
							form.getViolationItem().getDisposition()))
							&& (form.getViolationItem().getSanction()
									!= null &&
									!form.getViolationItem().getSanction()
									.equals(""))){
						errors.rejectValue("violationItem.sanction",
								SANCTION_ONLY_ON_GUILTY_MSG_KEY);
					}
				case INFORMAL:
					//validate sanction
					if((ResolutionClassificationCategory.FORMAL.equals(
							form.getResolutionCategory())
							&& DispositionCategory.GUILTY.equals(
									form.getViolationItem().getDisposition()))
							|| ResolutionClassificationCategory.INFORMAL.equals(
							form.getResolutionCategory())){
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"violationItem.sanction",
							SANCTION_REQUIRED_MESSAGE_KEY);
					}
				case DISMISSED:
					//if not formal, validate decision
					if(!(ResolutionClassificationCategory.FORMAL.equals(
							form.getResolutionCategory()))){
						ValidationUtils.rejectIfEmptyOrWhitespace(errors,
								"violationItem.decision",
								DECISION_REQUIRED_MSG_KEY);
					}
					//validate date and reason
					ValidationUtils.rejectIfEmptyOrWhitespace(errors,
							"violationItem.reason",
							REASON_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
							"violationItem.date",
							DATE_REQUIRED_MSG_KEY);
					ValidationUtils.rejectIfEmpty(errors,
							"violationItem.authority",
							DECIDED_BY_REQUIRED_MSG_KEY);
				break;
				default:
					//validate resolutionCategory!
					throw new UnsupportedOperationException(
							"Resolution Category is not supported.");
			}
		}
	}
}