<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Editar Doctor</title>
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
                    <h3>Editar Doctor</h3>
                    <form class="form" action="./Doctor" method="POST">
                        <br>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="IdMedico" class="form-label">ID</label>
                                        <input class="form-control" value="<%= request.getParameter("IdMedico")%>"  name="IdMedico" type="text" placeholder="Ingrese ID" readonly="readonly"/>
                                    </div>
                                </div>     
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  for="NombreM" class="form-label">Nombre</label>
                                        <input class="form-control"  name="NombreM" value="<%= request.getParameter("NombreM")%>" type="text" placeholder="Ingrese Nombre"/>
                                    </div>
                                </div>    
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  for="ApellidoM" class="form-label">Apellido</label>
                                        <input class="form-control"  name="ApellidoM" value="<%= request.getParameter("ApellidoM")%>" type="text" placeholder="Ingrese Apellido"/>
                                    </div>
                                </div>   
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  for="IdEspecialidad" class="form-label">Especialidad</label>
                                        <select class="form-control" name="IdEspecialidad"> 
                                            <option value="-1">Selecciona una especialidad</option>
                                            <%
                                                try {
                                                    String Query = "SELECT * FROM tbespecialidad";
                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigci", "root", "");
                                                    Statement stm = conn.createStatement();
                                                    ResultSet rs = stm.executeQuery(Query);
                                                    while (rs.next()) {
                                            %>
                                            <option value="<%=rs.getInt("IdEspecialidad")%>" <% if (rs.getString("IdEspecialidad").equals((request.getParameter("IdEspecialidad")))) {
                                                    out.println("SELECTED");
                                                }%> > <%=rs.getString("Especialidad")%></option>

                                            <%
                                                    }
                                                } catch (Exception ex) {
                                                    ex.printStackTrace();
                                                    out.println("Error: " + ex.getMessage());
                                                }
                                            %>  
                                        </select> 
                                    </div>
                                </div>    
                            </div>
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="IdHorario" class="form-label">Turno</label>
                                        <select class="form-control" name="IdHorario"> 
                                            <option value="-1">Selecciona un turno</option>
                                            <%
                                                try {
                                                    String Query = "SELECT * FROM tbhorario";
                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigci", "root", "");
                                                    Statement stm = conn.createStatement();
                                                    ResultSet rs = stm.executeQuery(Query);
                                                    while (rs.next()) {
                                            %>
                                            <option value="<%=rs.getInt("IdHorario")%>" <% if (rs.getString("IdHorario").equals((request.getParameter("IdHorario")))) {
                                                    out.println("SELECTED");
                                                }%> ><%=rs.getString("HorarioN")%></option>

                                            <%
                                                    }
                                                } catch (Exception ex) {
                                                    ex.printStackTrace();
                                                    out.println("Error: " + ex.getMessage());
                                                }
                                            %>  
                                        </select> 
                                    </div>
                                </div>     
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="Dni" class="form-label">DNI</label>
                                        <input class="form-control" name="Dni" value="<%= request.getParameter("Dni")%>" type="text" placeholder="Ingrese Dni"/>
                                    </div>
                                </div>    
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="Consultorio" class="form-label">Consultorio</label>
                                        <input class="form-control" name="Consultorio" value="<%= request.getParameter("Consultorio")%>" type="text" placeholder="Ingrese Consultorio"/>
                                    </div>
                                </div>    
                            </div>
                        </div>

                        <input type="hidden" value="EM" name="accion" />
                        <br>
                        <div class="col-md-12 text-center center-block">
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </div>
                    </form>
                    <br>
                    <div class="col-md-12 text-center center-block">
                        <a href="./Doctor"><button class="btn btn-secondary">Cancelar</button></a>
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

