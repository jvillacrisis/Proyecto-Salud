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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/styles.css">
    </head>
    <body>
        <nav class="nav nav-system">
            <div class="container">
                <div class="row">
                    <div class="col-md-4"></div>
                    <div class="col-md-4 text-center"><img src="img/SIGCI.png"></div>
                    <div class="col-md-4"> <a href="index.html"><button class="btn btn-danger glyphicon glyphicon-new-window">Salir</button></a></div>
                </div>
            </div>
        </nav>
        <div class="row">
            <div class="container lateral">
                <a href="./Cita">
                    <img class="img-responsive center-block" src="img/citamedica.png" />
                    <br>
                    Reservar Cita</a>
                <a href="./Paciente">
                    <img class="img-responsive center-block" src="img/paciente.png" />
                    <br>
                    Pacientes</a>
                <a href="./Doctor">
                    <img class="img-responsive center-block" src="img/doctor.png" />
                    <br>
                    Doctores</a>
                <a href="./Historial">
                    <img class="img-responsive center-block" src="img/historial.png" />
                    <br>
                    Historial</a>     
                <a href="./EditarDatos">
                    <img class="img-responsive center-block" src="img/edit.png"  />
                    <br>
                    Editar Datos Personales</a>      
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="md-4"></div>
                <div class="md-4">
                    <h3>Editar Paciente</h3>
                    <br>
                    <form class="form" action="./Paciente" method="POST">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="idusuario" class="form-label">ID</label>
                                        <input class="form-control" name="idusuario" value="<%= request.getParameter("idusuario")%>" type="text" placeholder="Ingrese ID"/>
                                    </div>   
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  for="nombre" class="form-label">Nombre</label>
                                        <input class="form-control" name="nombre" value="<%= request.getParameter("nombre")%>" type="text" placeholder="Ingrese Nombre"/>
                                    </div>
                                </div>
                                <div class="col-md-3">           
                                    <div class="form-group">
                                        <label  for="apellido" class="form-label">Apellido</label>
                                        <input class="form-control" name="apellido" value="<%= request.getParameter("apellido")%>" type="text" placeholder="Ingrese Apellido"/>
                                    </div>         
                                </div>
                                <div class="col-md-3">  
                                    <div class="form-group">
                                        <label  for="correo" class="form-label">Correo</label>
                                        <input class="form-control" name="correo" type="text"  value="<%= request.getParameter("correo")%>"placeholder="Ingrese Correo"/>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="dni" class="form-label">DNI</label>
                                        <input class="form-control" name="dni" value="<%= request.getParameter("dni")%>" type="text" placeholder="Ingrese DNI"/>
                                    </div>
                                </div>   
                                <div class="col-md-3">  
                                    <div class="form-group">
                                        <label for="password" class="form-label">Clave</label>
                                        <input class="form-control" name="password" type="text" value="<%=request.getParameter("password")%>" placeholder="Ingrese Contraseña">
                                    </div>
                                </div>
                                <div class="col-md-6">  
                                    <div class="form-group">
                                        <label for="direccion" class="form-label">Direccion</label>
                                        <input class="form-control" name="direccion" type="text" value="<%=request.getParameter("direccion")%>" placeholder="Ingrese Contraseña">
                                    </div>
                                </div>
                            </div>

                        </div>

                        <input type="hidden" value="E" name="accion"/>
                        <br>
                        <div class="col-md-12 text-center center-block">
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>
                    </form>
                    <br>
                    <div class="col-md-12 text-center center-block">
                        <a href="./Paciente"><button class="btn btn-secondary">Cancelar</button></a>
                    </div>
                </div>
                <div class="md-4"></div>
            </div>
        </div>

        <footer>
            <p>&copy; 2023 UNIVERSIDAD NORBERT WIENER - Grupo 6</p>
        </footer>
    </body>
</html>
