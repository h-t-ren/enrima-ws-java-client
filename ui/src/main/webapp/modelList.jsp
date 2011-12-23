<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp" %>
<script type="text/javascript" charset="utf-8">
$(document).ready(
 function(){
	 $('#highlight').dataTable(
			 {
				 "sPaginationType": "full_numbers"
			 }
			 );
 }		
);

</script>

<fieldset><legend>Model list:</legend>
  <table class="display" id="highlight">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Version</th>
            <th>Description</th>
            <th>Creator</th>
            <th>Created</th>
            <th>Operation</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="model" items="${modelList}">
            <tr>
                <td>${model.id}</td>
                <td>${model.name}</td>
                <td>${model.version}</td>
                <td>${model.description}</td>
                <td>${model.auditable.createdBy.login}</td>
                <td>${model.auditable.creationDate}</td>
               <td> <a href="<c:url value="/model?id=${model.id}" />">
                 <img src="<c:url value="resources/images/crud/edit.png" />" title="Edit this model description" />
               </a>
               </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</fieldset>

<%@ include file="footer.jsp" %>