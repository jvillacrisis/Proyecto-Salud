<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Editar Cita</title>
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
                    <h3>Editar Cita</h3>
                    <form class="form" action="./Cita" method="POST">
                        <div class="form-group">
                            <label  for="IDCita" class="form-label">ID Cita</label>
                            <input class="form-control" value="<%= request.getParameter("IDCita")%>"  name="IDCita" type="text" placeholder="Ingrese ID" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label  for="IdUsuario" class="form-label">DNI USUARIO</label>
                            <input class="form-control" value="<%= request.getParameter("IdUsuario")%>" name="IdUsuario" type="text" placeholder="Ingrese ID Usuario" readonly="readonly"/>
                        </div>
                        <div class="form-group">
                            <label  for="TipoCita" class="form-label">Tipo Cita</label>
                            <select class="form-control" style="width: 250px" name="TipoCita">
                                <option value="-1">Selecciona el tipo de cita</option>
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
                        <div class="form-group">
                            <label  for="IdTipoCita" class="form-label">ID Cita</label>
                            <input class="form-control" value="<%= request.getParameter("IdTipoCita")%>"  name="IdTipoCita" type="text" placeholder="Ingrese ID Tipo Cita"/>
                        </div>
                        <div class="form-group">
                            <label  for="Especialidad" class="form-label">Tipo de especialidad</label>
                            <select class="form-control" style="width: 250px" name="Especialidad">
                                <option value="-1">Selecciona el tipo de cita</option>
                                <%
                                    try {
                                        String Query = "SELECT * FROM tbespecialidad";
                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sigci", "root", "");
                                        Statement stm = conn.createStatement();
                                        ResultSet rs = stm.executeQuery(Query);
                                        while (rs.next()) {
                                %>
                                <option value="<%=rs.getInt("IDEspecialidad")%>" <% if (rs.getString("IDEspecialidad").equals((request.getParameter("IDEspecialidad")))) {
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
                        <div class="form-group">
                            <label  for="IdEspecialidad" class="form-label">ID Cita</label>
                            <input class="form-control" value="<%= request.getParameter("IdEspecialidad")%>"  name="IdEspecialidad" type="text" placeholder="Ingrese ID Tipo Cita"/>
                        </div>
                        <div class="form-group">
                            <label  for="ApellidoM" class="form-label">Apellido M.</label>
                            <select class="form-control" style="width: 250px" name="ApellidoM"> 
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
                        <div class="form-group">
                            <label  for="IdMedico" class="form-label">ID Cita</label>
                            <input class="form-control" value="<%= request.getParameter("IdMedico")%>"  name="IdMedico" type="text" placeholder="Ingrese ID Tipo Cita"/>
                        </div>
                        <div class="form-group">
                            <label  for="Fecha" class="form-label">ID Fecha</label>
                            <input class="form-control" value="<%= request.getParameter("Fecha")%>"  name="Fecha" type="date" placeholder="Ingrese Fecha"/>
                        </div>
                        <input type="hidden" value="EC" name="accion" />
                        <br>
                        <button type="submit" class="btn btn-success">Editar</button>
                    </form>
                    <br>
                    <a href="./Cita"><button class="btn btn-success">Cancelar</button></a>
                </div>
                <div class="md-4"></div>
            </div>
        </div>
    </body>
</html>