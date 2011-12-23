<%@ include file="header.jsp" %>
<form method="post">
<fieldset><legend>Model description:</legend>
  <table style="width:400px;">
     <tr><th style="text-align:right">Id<th><td>${model.id}</td></tr>
     <tr><th style="text-align:right">Name<th><td><input type="text" name="name" value="${model.name}" /></td></tr>
     <tr><th style="text-align:right">Version<th><td><input type="text" name="version" value="${model.version}" /></td></tr>
     <tr><th style="text-align:right">Description<th><td><input type="text" name="description" value="${model.description}"/></td></tr>
     <tr><th style="text-align:right">Creator<th><td>${model.auditable.createdBy.login}</td></tr>
     <tr><th style="text-align:right">Created<th><td>${model.auditable.creationDate}</td></tr>
    </table>
</fieldset>
<input type="hidden" name="idModel" value="${model.id}" />
<input type="submit" name="_save" value="Save" /> <input type="submit" name="_cancel" value="Cancel" />
</form>
<%@ include file="footer.jsp" %>



