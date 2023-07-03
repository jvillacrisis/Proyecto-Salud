/* CONSULTA TABLA
SELECT tbmedico.IdMedico, tbmedico.NombreM, tbmedico.ApellidoM, 
tbmedico.IdEspecialidad, tbmedico.IdHorario, tbmedico.Dni, 
tbmedico.Consultorio, tbespecialidad.Especialidad, tbhorario.HorarioN 
from tbmedico 
INNER JOIN tbhorario on tbmedico.IdHorario=tbhorario.IdHorario 
INNER JOIN tbespecialidad on tbmedico.IdEspecialidad=tbespecialidad.IDEspecialidad
 */
package com.uwiener.das.javaweb;

import static com.uwiener.das.javaweb.BDConexion.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DoctorServlet", urlPatterns = {"/Doctor"})
public class DoctorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx;
        String sHtml = "";
        VHtml objVHtml = new VHtml();
        String sTabla = "";
        try {
            cnx = initializeDatabases();
            PreparedStatement st = cnx.prepareStatement("SELECT tbmedico.IdMedico, tbmedico.NombreM, tbmedico.ApellidoM, "
                    + "tbmedico.IdEspecialidad, tbmedico.IdHorario, tbmedico.Dni, tbmedico.Consultorio, "
                    + "tbespecialidad.Especialidad, tbhorario.HorarioN "
                    + "from tbmedico "
                    + "INNER JOIN tbhorario on tbmedico.IdHorario=tbhorario.IdHorario "
                    + "INNER JOIN tbespecialidad on tbmedico.IdEspecialidad=tbespecialidad.IDEspecialidad");
            ResultSet rs = st.executeQuery();
            sHtml = objVHtml.getHeader() + objVHtml.getBody()
                    + "<div class=\"container\">\n"
                    + "<h3 class=\"text-center\">Lista de Doctores</h3> <br>"
                    + "                    <a href=\"nuevomedico.jsp\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">\n"
                    + "                            Nuevo Medico</button></a>\n"
                    +"                          <br>"
                    +"                          <br>"
                    + "                    <table class=\"table table-striped\">\n"
                    + "                        <tr>\n"
                    + "                            <th>ID</th>\n"
                    + "                            <th>Nombre</th>\n"
                    + "                            <th>Apellido</th>\n"
                    + "                            <th>Especialidad</th>\n"
                    + "                            <th>Horario</th>\n"
                    + "                            <th>DNI</th>\n"
                    + "                            <th>Consultorio</th>\n"
                    + "                            <th>Editar</th>\n"
                    + "                            <th>Borrar</th>\n"
                    + "                        </tr>\n";
            while (rs.next()) {
                sTabla += "<tr>\n"
                        + "   <td>" + rs.getInt(1) + "</td>\n"
                        + "   <td>" + rs.getString(2) + "</td>\n"
                        + "   <td>" + rs.getString(3) + "</td>\n"
                        + "   <td>" + rs.getString(8) + "</td>\n"
                        + "   <td>" + rs.getString(9) + "</td>\n"
                        + "   <td>" + rs.getInt(6) + "</td>\n"
                        + "   <td>" + rs.getInt(7) + "</td>\n"
                        + "   <td><a href=\"./editardoctor.jsp?IdMedico=" + rs.getInt(1) + "&NombreM=" + rs.getString(2) + "&ApellidoM=" + rs.getString(3) + "&IdEspecialidad=" + rs.getInt(4) + "&IdHorario=" + rs.getInt(5) + "&Dni=" + rs.getInt(6) + "&Consultorio=" + rs.getInt(7) + "\"><button class=\"btn btn-warning\"> Editar</button></a></td>\n"
                        + "   <td><a href=\"./borrardoctor.jsp?IdMedico=" + rs.getInt(1) + "&NombreM=" + rs.getString(2) + "&ApellidoM=" + rs.getString(3) + "&IdEspecialidad=" + rs.getInt(4) + "&IdHorario=" + rs.getInt(5) + "&Dni=" + rs.getInt(6) + "&Consultorio=" + rs.getInt(7) + "\"><button class=\"btn btn-danger\"> Borrar</button></a></td>\n"
                        + "</tr>\n";
            }
            sHtml += sTabla + "</table>" + objVHtml.getFooter();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(sHtml);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.toString();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx;
        try {
            cnx = initializeDatabases();
            PreparedStatement st = null;
            if (request.getParameter("accion").equals("IM")) {
                st = cnx.prepareStatement("insert into tbmedico (IdMedico, NombreM, ApellidoM, IdEspecialidad, IdHorario, Dni, Consultorio) values (?,?,?,?,?,?,?)");
                st.setString(1, request.getParameter("IdMedico").toString());
                st.setString(2, request.getParameter("NombreM").toString());
                st.setString(3, request.getParameter("ApellidoM").toString());
                st.setString(4, request.getParameter("IdEspecialidad").toString());
                st.setString(5, request.getParameter("IdHorario").toString());
                st.setString(6, request.getParameter("Dni").toString());
                st.setString(7, request.getParameter("Consultorio").toString());
                st.executeUpdate();
                response.sendRedirect("./Doctor");
            } else if (request.getParameter("accion").equals("EM")) {
                st = cnx.prepareStatement("update tbmedico set NombreM=?,ApellidoM=?,IdEspecialidad=?,IdHorario=?,Dni=?,Consultorio=? where IdMedico=?");
                st.setString(1, request.getParameter("NombreM").toString());
                st.setString(2, request.getParameter("ApellidoM").toString());
                st.setString(3, request.getParameter("IdEspecialidad").toString());
                st.setString(4, request.getParameter("IdHorario").toString());
                st.setString(5, request.getParameter("Dni").toString());
                st.setString(6, request.getParameter("Consultorio").toString());
                st.setString(7, request.getParameter("IdMedico"));
                st.executeUpdate();
                response.sendRedirect("./Doctor");
            } else if (request.getParameter("accion").equals("BM")) {
                st = cnx.prepareStatement("delete from tbmedico where IdMedico=?");
                st.setString(1, request.getParameter("IdMedico"));
                st.executeUpdate();
                response.sendRedirect("./Doctor");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex.toString()
                    + " - " + request.getParameter("NombreM")
                    + " - " + request.getParameter("ApellidoM")
                    + " - " + request.getParameter("IdEspecialidad")
                    + " - " + request.getParameter("IdHorario")
                    + " - " + request.getParameter("Dni")
                    + " - " + request.getParameter("Consultorio")
                    + " - " + request.getParameter("IdMedico"));
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
