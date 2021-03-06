<?xml version="1.0" encoding="UTF-8"?>

<%--
 - OMIS - Offender Management Information System
 - Copyright (C) 2011 - 2017 State of Montana
 -
 - This program is free software: you can redistribute it and/or modify
 - it under the terms of the GNU General Public License as published by
 - the Free Software Foundation, either version 3 of the License, or
 - (at your option) any later version.
 -
 - This program is distributed in the hope that it will be useful,
 - but WITHOUT ANY WARRANTY; without even the implied warranty of
 - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 - GNU General Public License for more details.
 -
 - You should have received a copy of the GNU General Public License
 - along with this program.  If not, see <http://www.gnu.org/licenses/>.
 --%>

<%--
 - Screen to list tracked document receival.
 -
 - Author: Yidong Li
 - Version: 0.1.0 (Dec 15, 2017)
 - Since: OMIS 3.0
 -
 --%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- 
 - Author: Yidong Li
 - Version: 0.1.0 (Dec 15, 2017)
 - Since: OMIS 3.0
 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<fmt:bundle basename="omis.trackeddocument.msgs.trackedDocument">
<head>
	<title>
		<fmt:message key="documentTrackingListHeader"/>
		<jsp:include page="/WEB-INF/views/offender/includes/offenderNameSummary.jsp"/>
	</title>
	<jsp:include page="/WEB-INF/views/common/includes/headerOffenderListResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/toolsResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/linksResources.jsp"/>
	<jsp:include page="/WEB-INF/views/common/includes/messageResolverResources.jsp"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/trackeddocument/scripts/listTrackingDocument.js"> </script>
</head>
 <body>
 	<c:if test="${not empty offenderSummary}">
 	<jsp:include page="/WEB-INF/views/offender/includes/offenderHeader.jsp"/>
 	</c:if>
 	<h1>
		<a class="actionMenuItem" id="trackedDocumentListActionMenuLink" href="${pageContext.request.contextPath}/trackedDocumentReport/trackedDocumentListScreenActionMenu.html?offender=${offender.id}"></a><span class="visibleLinkLabel"/>
		<fmt:message key="documentTrackingListHeader"/>
	</h1>
	<jsp:include page="includes/listTable.jsp"/>
</body>
</fmt:bundle>
</html>