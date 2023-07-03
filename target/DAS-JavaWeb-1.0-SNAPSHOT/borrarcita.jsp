<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Borrar Cita</title>
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
                    <h3>Borrar Cita</h3
                    <br><br>
                    <form class="form" action="./Cita" method="POST">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="IDCita" class="form-label">ID Cita</label>
                                        <input class="form-control" value="<%= request.getParameter("IDCita")%>"  name="IDCita" type="text" placeholder="Ingrese ID" readonly="readonly" />
                                    </div>  
                                </div>
                                <div class="col-md-2">
                                    <div class="form-group">
                                        <label  for="IdTipoCita" class="form-label">Tipo de Cita</label>
                                        <select class="form-control" name="IdTipoCita" readonly="readonly">
                                            <option value="-1">Tipo de cita</option>
                                            <%
                                                try {
                                                    String Query = "SELECT * FROM tbtipocita";
                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigci", "root", "");
                                                    Statement stm = conn.createStatement();
                                                    ResultSet rs = stm.executeQuery(Query);
                                                    while (rs.next()) {
                                            %>
                                            <option value="<%=rs.getInt("IdTipoCita")%>" <% if (rs.getString("IdTipoCita").equals((request.getParameter("IdTipoCita")))) {
                                                    out.println("SELECTED");
                                                }%> > <%=rs.getString("TipoCita")%></option>
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
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  for="IdMedico" class="form-label">Apellido Paterno</label>
                                        <select class="form-control" name="IdMedico" readonly="readonly"> 
                                            <option value="-1">Selecciona especialidad</option>
                                            <%
                                                try {
                                                    String Query = "SELECT * FROM tbmedico";
                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigci", "root", "");
                                                    Statement stm = conn.createStatement();
                                                    ResultSet rs = stm.executeQuery(Query);
                                                    while (rs.next()) {
                                            %>
                                            <option value="<%=rs.getInt("IdMedico")%>" <% if (rs.getString("IdMedico").equals((request.getParameter("IdMedico")))) {
                                                    out.println("SELECTED");
                                                }%> > <%=rs.getString("ApellidoM")%></option>
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
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label  for="IdUsuario" class="form-label">Apellido Materno</label>
                                        <select class="form-control" name="IdUsuario" readonly="readonly"> 
                                            <option value="-1">Selecciona especialidad</option>
                                            <%
                                                try {
                                                    String Query = "SELECT * FROM tbusuario";
                                                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigci", "root", "");
                                                    Statement stm = conn.createStatement();
                                                    ResultSet rs = stm.executeQuery(Query);
                                                    while (rs.next()) {
                                            %>
                                            <option value="<%=rs.getInt("IdUsuario")%>" <% if (rs.getString("IdUsuario").equals((request.getParameter("IdUsuario")))) {
                                                    out.println("SELECTED");
                                                }%> > <%=rs.getString("DNI")%></option>
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
                                        <label  for="Fecha" class="form-label">ID Fecha</label>
                                        <input class="form-control" value="<%= request.getParameter("Fecha")%>"  name="Fecha" type="date" placeholder="Ingrese Fecha" readonly="readonly"/>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <input type="hidden" value="BC" name="accion" />
                        <br>
                        <div class="col-md-12 text-center center-block">
                            <button type="submit" class="btn btn-success">Borrar</button>
                        </div>

                    </form>
                    <br>
                    <div class="col-md-12 text-center center-block">
                        <a href="./Cita"><button class="btn btn-secondary">Cancelar</button></a>
                    </div>
                </div>
                <div class="md-4"></div>
            </div>
        </div>
    </body>
</html>
