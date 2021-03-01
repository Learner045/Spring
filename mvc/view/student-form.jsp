<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body>

<h2>HTML Forms</h2>

<form:form  action="processForm" modelAttribute="student">
	
	First Name:<form:input path="firstName"/>
	<br><br>
	Last Name:<form:input path="lastName"/>
	<br><br>
	<input type="submit" value="Submit" />

</form:form>
</body>
</html>