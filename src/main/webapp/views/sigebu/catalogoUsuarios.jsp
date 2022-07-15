<%--
  Created by IntelliJ IDEA.
  User: aenri
  Date: 15/07/2022
  Time: 11:41 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:include page="../../templates/head.jsp"></jsp:include>
    <title>Usuarios</title>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8"/>
</head>
<body>
<jsp:include page="../../templates/navbar.jsp"></jsp:include>
<div class="container">
    <c:if test="${param['result']}">
        <p><c:out value="${param['message']}"></c:out></p>
    </c:if>
    <a href="create-usuario" class="btn btn-outline-success btn-sm">Registrar usuario</a>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>curp</th>
            <th>matricula</th>
            <th>tipo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="usuario" items="${usuarios}" varStatus="status">
            <tr>
                <td>
                    <c:out value="${status.count}"></c:out>
                </td>
                <td>
                    <c:out value="${usuario.nombre}"></c:out>
                </td>
                <td>
                    <c:out value="${usuario.apellidos}"></c:out>
                </td>
                <td>
                    <c:out value="${usuario.curp}"></c:out>
                </td>
                <td>
                    <c:out value="${usuario.matricula}"></c:out>
                </td>
                <td>
                    <c:out value="${usuario.tipo}"></c:out>
                </td>
                <td>
                    <a href="get-usuario?id=${usuario.id}" class="btn btn-warning btn-sm">EDITAR</a>
                    <a href="delete-usuario?id=${usuario.id}" class="btn btn-danger btn-sm">ELIMINAR</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<jsp:include page="../../templates/footer.jsp"></jsp:include>
</body>
</html>
