<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"  rel="stylesheet">
    <!-- Font Awesome -->
	  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	 <!-- /Font Awesome -->
  </head>
<body>
    <div class="container">
        <h2>Edit Student</h2>
        <form:form action="${pageContext.request.contextPath}/student/edit" modelAttribute="student" method="post" class="form-horizontal">
            <form:hidden path="id"/>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <form:input path="name" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="apellido">Apellido:</label>
                <form:input path="lastname" class="form-control"/>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <form:input path="email" class="form-control"/>
            </div>

            <button class="btn btn-primary" type="submit">Save</button>
        </form:form>
    </div>
</body>
</html>
