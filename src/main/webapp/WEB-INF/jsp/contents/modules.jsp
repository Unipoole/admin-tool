<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="mainPage">
    <%-- TODO Report errors on the page --%>
    <h2>Select for Modules to create Unipoole clients</h2>
    <div id="searchCriteria">
        </br>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Module Code</th>
                    <th>Description</th>
                    <th>Id</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="mods" items="${command}" varStatus="status">
                    <tr>
                        <td>
                            ${mods.name}
                        </td>
                        <td>
                            ${mods.description}
                        </td>
                        <td>
                            ${mods.id}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/module/${mods.name}/${mods.id}">View</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>