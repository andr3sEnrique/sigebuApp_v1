<%--
  Created by IntelliJ IDEA.
  User: aenri
  Date: 15/07/2022
  Time: 03:11 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../../js/javascript.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
          crossorigin="anonymous">
    <title>Actualizar</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="card mt-5">
                <div class="card-header">REGISTRO DE USUARIO</div>
                <div class="card-body">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-12">
                                <form class="needs-validation" novalidate action="save-usuario" method="POST">
                                    <div class="form-group mb-3">
                                        <div class="row">
                                            <div class="col">
                                                <label class="fw-bold" for="usuario">Nombre</label>
                                                <input name="nombre" id="usuario" required
                                                class="form-control" value="${usuario.nombre}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                                <input type="hidden" name="id" value="${usuario.id}">
                                            </div>
                                            <div class="col">
                                                <label class="fw-bold" for="apellidos">Apellidos</label>
                                                <input name="apellidos" id="apellidos" required
                                                       class="form-control" value="${usuario.apellidos}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <div class="row">
                                            <div class="col">
                                                <label class="fw-bold" for="curp">Curp</label>
                                                <input name="curp" id="curp" required
                                                       class="form-control" value="${usuario.curp}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>
                                            <div class="col">
                                                <label class="fw-bold" for="matricula">Matricula</label>
                                                <input name="matricula" id="matricula" required
                                                       class="form-control" value="${usuario.matricula}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <div class="row">
                                            <div class="col">
                                                <label class="fw-bold" for="edad">Edad</label>
                                                <input name="edad" id="edad" required
                                                       class="form-control" value="${usuario.edad}" type="number"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>
                                            <div class="col">
                                                <label class="fw-bold" for="tipo">Tipo</label>
                                                <input name="tipo" id="tipo" required
                                                       class="form-control" value="${usuario.tipo}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <div class="row">
                                            <div class="col">
                                                <label class="fw-bold" for="direccion">Dirección</label>
                                                <input name="direccion" id="direccion" required
                                                       class="form-control" value="${usuario.direccion}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>
                                            <div class="col">
                                                <label class="fw-bold" for="email">Correo</label>
                                                <input name="email" id="email" required
                                                       class="form-control" value="${usuario.tipo}" type="email"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>

                                        </div>
                                    </div>
                                    <div class="form-group mb-3">
                                        <div class="row">
                                            <div class="col">
                                                <label class="fw-bold" for="password">Contraseña</label>
                                                <input name="password" id="password" required
                                                       class="form-control" value="${usuario.password}"/>
                                                <div class="invalid-feedback">Campo Obligatorio</div>
                                            </div>
                                            <div class="col">
                                                <button type="button" class="btn btn-danger btn-sm">Cancelar</button>
                                                <button type="submit" class="btn btn-warning btn-sm">Actualizar</button>
                                            </div>

                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
