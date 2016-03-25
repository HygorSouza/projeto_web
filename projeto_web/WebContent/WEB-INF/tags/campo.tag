<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="true" %>

<label for="${name}"> ${value} </label>
<input name="${name}" id="${name}" type="text"/>
