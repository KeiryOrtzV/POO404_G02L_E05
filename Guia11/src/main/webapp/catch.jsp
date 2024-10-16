<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!int valor=0;%><%--Declarando variable tipo int--%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <title>Etiquetas JSTL</title>
</head>
<body>
<div class="container">
  <div class="row">&nbsp;</div>
  <div class="row">
    <div class="col-sm-4 col-sm-offset-4">
      <c:catch var="error01">
        <%
          valor=Integer.parseInt(request.getParameter("parametro"));
        %>
      </c:catch>
      <c:if test="${not empty error01}">
        <div class="alert alert-danger">
          <strong>Se produjo un error:</strong> ${error01}
          <br>
        </div>
      </c:if>
      <c:if test="${valor!=0 && empty error01}">
        <div class="alert alert-info">
          <strong>Valor recibido: <%out.print(valor);%></strong>
          <br>
        </div>
      </c:if>
      <form role="form">
        <input type="hidden" name="parametro" value="prueba"/>
        <input type="submit" class="btn btn-info" value="Enviar 'prueba'"/>
      </form>
      <form role="form">
        <input type="hidden" name="parametro" value="1234"/>
        <input type="submit" class="btn btn-info" value="Enviar '1234'"/>
      </form>
      <form role="form">
        <input type="submit" class="btn btn-info" value="No enviar el parámetro"/>
      </form>
    </div>
  </div>
</div>
</body>
</html>