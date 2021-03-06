<?xml version="1.0" encoding="UTF-8"?>
<%-- Author: Ryan Johns
 - Version: 0.1.0 (Mar 14, 2016)
 - Since: OMIS 3.0 --%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:bundle basename="omis.courtcase.msgs.courtCase">
	<div class="profileItem">
		<a href="${pageContext.request.contextPath}/courtCase/listCharges.html?defendant=${offenderSummary.id}">
			<span>
    			<fmt:message key="chargeCountLabel">
    				<fmt:param value="${chargeCount}"/>
    			</fmt:message>
    		</span>
    	</a>
    </div>
</fmt:bundle>