<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="mainPage">
    <%-- TODO Report errors on the page --%>
    <h3>Module ${command.module.name}</h3>
    <div id="searchCriteria">
        <form:form name="createClient" id="createClient" method="post" action="/admin-tool/module/createClient">
            <input type="hidden" name="id" value="${command.module.id}">
            <input type="hidden" name="name" value="${command.module.name}">
            <br/>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Id</th>
                        <th>Include</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tools" items="${command.tools}" varStatus="status">
                        <tr>
                            <td>
                                ${tools.title} 
                            </td>
                            <td>
                                ${tools.name}
                            </td>
                            <td>
                                <input name="createTool" id="createTool_${status.index}}" checked="true" type="checkbox" value="${tools.name}" disabled="true" />
                            </td>
                        </tr>
                    </c:forEach>                    
                </tbody>
            </table>
            <br/>
            <table class="table table-striped">
                <tbody>
                    <tr>
                        <td><label path="userName">Name:</label></td>
                        <td><input path="userName" type="text" name="userName" placeholder="John Smith" value="${command.userName}" /></td>
                    </tr>
                    <tr>
                        <td><label path="userEmail">Email Address:</label></td>
                        <td><input path="userEmail" type="text" name="userEmail" placeholder="john@unisa.ac.za" value="${command.userEmail}" /></td>
                    </tr>
                    <tr>
                        <td><label path="clientDestination">Write Client to Destination:</label></td>
                        <td>
                            <input path="clientDestinationCheck" type="checkbox" name="clientDestinationCheck" value="true"/>
                            <input path="clientDestination" type="text" readonly="true" name="clientDestination" placeholder="/unipoole/clients" value="${command.clientDestination}" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <br/>
            <div class="error" id="toolCountError" style="display: none">Please select at least one tool.</div>
            <input type="submit" value="Create Client" />
        </form:form>
    </div>
</div>
<script type="text/javascript" src="/admin-tool/js/module.js" ></script>  
 