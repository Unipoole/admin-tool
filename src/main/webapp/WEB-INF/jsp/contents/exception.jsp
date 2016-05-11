<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h2><spring:message code="exception.handler.title"/></h2>
<div id="exceptionHandler">
    <div id="exceptionOverview"><spring:message code="exception.handler.overview"/></div>
    <div id="exceptionDetails">
        <ol>
            <li><label><spring:message code="exception.handler.request" />: </label>${exceptionRequest}</li>
            <li><label><spring:message code="exception.handler.message" />: </label>${exceptionMessage}</li>
            <li><label><spring:message code="exception.handler.type" />: </label>${exceptionType}</li>
            <c:if test="${exceptionCauseMessage ne null }">
                <li><label><spring:message code="exception.handler.cause.message" />: </label>${exceptionCauseMessage}</li>
                <li><label><spring:message code="exception.handler.cause.type" />: </label>${exceptionCauseType}</li>
            </c:if>
        </ol>
    </div>
    <div id="exceptionSummary"><spring:message code="exception.handler.summary" /></div>
</div>