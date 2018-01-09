<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:bundle basename="omis.violationevent.msgs.violationEvent">
		<div class="profileItem">
		<a href="${pageContext.request.contextPath}/violationEvent/list.html?offender=${offenderSummary.id}">
			<span>
				<fmt:message key="violationEventProfileCountLabel">
					<fmt:param value="${violationEventCount}"/>
				</fmt:message>
			</span>
		</a>
	</div>
</fmt:bundle>