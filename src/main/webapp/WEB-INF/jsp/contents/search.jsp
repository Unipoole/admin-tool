<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Search for Modules to create Unipoole clients</h2>
<div id="searchCriteria">
    <c:if test="${info_message ne null }">
        <div id="info_message" class="alert alert-info">${info_message}</div>
    </c:if>
    <form:form method="post" action="search" name="search" id="search">
        <%-- TODO set years from now to x in the future--%>
        <form:label path="year">Year:</form:label> 
        <form:select path="year"  name="year" id="year">
        </form:select>
        <form:label path="moduleCode">Module Code:</form:label> <form:input path="moduleCode" type="text" id="moduleCode" placeholder="AAC411A" /></br>
        <input type="submit" value="Search" id="searchButton" />
    </form:form>
</div>
<script type="text/javascript" src="/admin-tool/js/search.js" ></script>