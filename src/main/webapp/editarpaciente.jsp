<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Registrar Paciente</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="webjars/bootstrap/5.2.2/css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="md-4"></div>
                <div class="md-4">
                    <h3>Editar Paciente</h3>
                    <form class="form" action="./Paciente" method="POST">
                        <div class="form-group">
                            <label  for="IDUsuario" class="form-label">ID</label>
                            <input class="form-control" name="IDUsuario" value="<%= request.getParameter("idusuario") %>" type="text" placeholder="Ingrese ID"/>
                        </div>
                        <div class="form-group">
                            <label  for="nombre" class="form-label">Nombre</label>
                            <input class="form-control" name="nombre" value="<%= request.getParameter("nombre") %>" type="text" placeholder="Ingrese Nombre"/>
                        </div>
                        <div class="form-group">
                            <label  for="direccion" class="form-label">apellido</label>
                            <input class="form-control" name="apellido" value="<%= request.getParameter("apellido") %>" type="text" placeholder="Ingrese Apellido"/>
                        </div>
                        <div class="form-group">
                            <label  for="dni" class="form-label">DNI</label>
                            <input class="form-control" name="dni" value="<%= request.getParameter("dni") %>" type="text" placeholder="Ingrese DNI"/>
                        </div>
                        <div class="form-group">
                            <label  for="correo" class="form-label">Correo</label>
                            <input class="form-control" name="correo" type="text"  value="<%= request.getParameter("correo") %>"placeholder="Ingrese Correo"/>
                        </div>
                        <div class="form-group">
                            <label  for="password" class="form-label">Clave</label>
                            <input class="form-control" name="password" type="text"  value="<%= request.getParameter("password") %>"placeholder="Ingrese Clave"/>
                        </div>
                        <div class="form-group">
                            <label  for="direccion" class="form-label">Direccion</label>
                            <input class="form-control" name="direccion" type="text"  value="<%= request.getParameter("direccion") %>"placeholder="Ingrese Direccion"/>
                        </div>
                        <input type="hidden" value="E" name="accion"/>
                        <br>
                        <button type="submit" class="btn btn-success">Guardar</button>
                    </form>
                    <a href="./Login"><button class="btn btn-warning">Cancelar</button></a>
                </div>
                <div class="md-4"></div>
            </div>
        </div>
    </body>
</html>
