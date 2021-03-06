<?xml version="1.0" encoding="UTF-8"?>
<%--
 - Author: Ryan Johns
 - Version: 0.1.0 (Mar 31, 2014)
 - Since: OMIS 3.0
 --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<fmt:bundle basename="omis.health.msgs.health">
<head>
	<title>
		<fmt:message key="selectFacilityTitle"/>
	</title>
	<jsp:include page="/WEB-INF/views/common/includes/headerListResources.jsp"/>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/health/style/referralCenter.css"/>
</head>
<body>
	<h1><fmt:message key="selectFacilityTitle"/></h1>
	<jsp:include page="includes/facilityList.jsp"/>
</body>
</fmt:bundle>
</html>
