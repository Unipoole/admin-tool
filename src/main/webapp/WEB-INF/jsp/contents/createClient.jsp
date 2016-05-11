<%-- 
    Document   : createClient
    Created on : 01 Aug 2013, 1:36:21 PM
    Author     : OpenCollab
--%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>Client creator</h2>
<c:if test="${!empty fn:trim(error_message)}" >
    <div id="error_message" name="error_message"  class="alert alert-error" >
        ${error_code}: ${error_message}
    </div>
    <div id="error_instruction" name="error_instruction"  class="alert alert-error" >
        ${error_instruction}
    </div>
</c:if>
 <c:if test="${!empty fn:trim(name)}" >
     <h4>${name}</h4>
 </c:if>
 <c:if test="${!empty fn:trim(description)}" >
     <h4>${description}</h4>
 </c:if>
 <c:if test="${!empty fn:trim(url)}" >
     <a href="${url}" title="Client creator download link." >Click to download the Client</a><br/>
 </c:if>
    