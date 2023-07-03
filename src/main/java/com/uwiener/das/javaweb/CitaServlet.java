/*
"SELECT tbcita.IDCita, tbcita.IdTipoCita, tbcita.IdEspecialidad, "
                    + "tbcita.IdMedico, tbcita.Fecha, tbcita.IdUsuario,"
                    + "tbtipocita.TipoCita, tbespecialidad.Especialidad, tbmedico.ApellidoM, "
                    + "tbusuario.DNI "
                    + "FROM tbcita "
                    + "INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita "
                    + "INNER JOIN tbespecialidad on tbcita.IdEspecialidad=tbespecialidad.IDEspecialidad "
                    + "INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico "
                    + "INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario"


SELECT tbcita.IDCita, tbcita.IdTipoCita, tbcita.IdEspecialidad, tbcita.IdMedico, tbcita.Fecha, tbcita.IdUsuario, tbtipocita.TipoCita, tbespecialidad.Especialidad, tbmedico.ApellidoM, tbusuario.DNI FROM tbcita INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita INNER JOIN tbespecialidad on tbcita.IdEspecialidad=tbespecialidad.IDEspecialidad INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario


CONSULTA UTIL:
SELECT tbcita.IDCita, tbcita.IdTipoCita, tbtipocita.TipoCita, tbcita.IdMedico, tbmedico.ApellidoM, tbmedico.IdEspecialidad, tbespecialidad.Especialidad, tbmedico.IdHorario, tbhorario.HorarioN, tbmedico.Consultorio, tbcita.IdUsuario, tbusuario.DNI, tbcita.Fecha FROM tbcita INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario INNER JOIN tbespecialidad on tbespecialidad.IDEspecialidad=tbmedico.IdEspecialidad INNER JOIN tbhorario on tbhorario.IdHorario=tbmedico.IdHorario
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

@WebServlet(name = "CitaServlet", urlPatterns = {"/Cita"})
public class CitaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx;
        String sHtml = "";
        VHtml objVHtml = new VHtml();
        String sTabla = "";
        try {
            cnx = initializeDatabases();
            PreparedStatement st = cnx.prepareStatement("SELECT tbcita.IDCita, tbcita.IdTipoCita, tbtipocita.TipoCita, "
                    + "tbcita.IdMedico, tbmedico.ApellidoM, tbmedico.IdEspecialidad, "
                    + "tbespecialidad.Especialidad, tbmedico.IdHorario, tbhorario.HorarioN, "
                    + "tbmedico.Consultorio, tbcita.IdUsuario, tbusuario.DNI, tbcita.Fecha "
                    + "FROM tbcita "
                    + "INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita "
                    + "INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico "
                    + "INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario "
                    + "INNER JOIN tbespecialidad on tbespecialidad.IDEspecialidad=tbmedico.IdEspecialidad "
                    + "INNER JOIN tbhorario on tbhorario.IdHorario=tbmedico.IdHorario ORDER BY tbcita.IDCita");
            ResultSet rs = st.executeQuery();
            sHtml = objVHtml.getHeader() + objVHtml.getBody()
                    + "<div class=\"container\">\n"
                    + "<h3 class=\"text-center\">Reservar cita</h3> <br>"
                    + "                    <a href=\"nuevacita.jsp\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">\n"
                    + "                            Nueva Cita</button></a>\n"
                    + "                          <br>"
                    + "                          <br>"
                    + "                        <table class=\"table table-striped\">\n"
                    + "                        <tr>\n"
                    + "                            <th>IdCita</th>\n"
                    + "                            <th>TipoCita</th>\n"
                    + "                            <th>Apellido Medico</th>\n"
                    + "                            <th>Especialidad</th>\n"
                    + "                            <th>Horario</th>\n"
                    + "                            <th>Consultorio</th>\n"
                    + "                            <th>DNI</th>\n"
                    + "                            <th>Fecha</th>\n"
                    + "                            <th>Editar</th>\n"
                    + "                            <th>Borrar</th>\n"
                    + "                        </tr>\n";
            while (rs.next()) {
                sTabla += "<tr>\n"
                        + "   <td>" + rs.getInt(1) + "</td>\n"
                        + "   <td>" + rs.getString(3) + "</td>\n"
                        + "   <td>" + rs.getString(5) + "</td>\n"
                        + "   <td>" + rs.getString(7) + "</td>\n"
                        + "   <td>" + rs.getString(9) + "</td>\n"
                        + "   <td>" + rs.getInt(10) + "</td>\n"
                        + "   <td>" + rs.getInt(12) + "</td>\n"
                        + "   <td>" + rs.getString(13) + "</td>\n"
                        + "   <td><a href=\"./editarcita.jsp?IDCita=" + rs.getInt(1) + "&IdTipoCita=" + rs.getInt(2) + "&IdMedico=" + rs.getInt(4) + "&IdUsuario=" + rs.getInt(11) + "&Fecha=" + rs.getString(13) + "\"><button class=\"btn btn-warning\"> Editar</button></a></td>\n"
                        + "   <td><a href=\"./borrarcita.jsp?IDCita=" + rs.getInt(1) + "&IdTipoCita=" + rs.getInt(2) + "&IdMedico=" + rs.getInt(4) + "&IdUsuario=" + rs.getInt(11) + "&Fecha=" + rs.getString(13) + "\"><button class=\"btn btn-danger\"> Borrar</button></a></td>\n"
                        + "</tr>\n"; 
            }
            sHtml += sTabla + "</table>" 
                        +"</div>\n"+
                    objVHtml.getFooter();
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
            if (request.getParameter("accion").equals("IC")) {
                st = cnx.prepareStatement("insert into tbcita (IDCita, IdTipoCita, IdMedico, IdUsuario, Fecha) values (?,?,?,?,?)");
                st.setString(1, request.getParameter("IDCita").toString());
                st.setString(2, request.getParameter("IdTipoCita").toString());
                st.setString(3, request.getParameter("IdMedico").toString());
                st.setString(4, request.getParameter("IdUsuario").toString());
                st.setString(5, request.getParameter("Fecha").toString());
                st.executeUpdate();
                response.sendRedirect("./Cita");
            } else if (request.getParameter("accion").equals("EC")) {
                st = cnx.prepareStatement("update tbcita set IdTipoCita=?, IdMedico=?, IdUsuario=?, Fecha=? where IDCita=?");
                st.setString(1, request.getParameter("IdTipoCita").toString());
                st.setString(2, request.getParameter("IdMedico").toString());
                st.setString(3, request.getParameter("IdUsuario").toString());
                st.setString(4, request.getParameter("Fecha").toString());
                st.setString(5, request.getParameter("IDCita").toString());
                st.executeUpdate();
                response.sendRedirect("./Cita");
            } else if (request.getParameter("accion").equals("BC")) {
                st = cnx.prepareStatement("delete from tbcita where IDCita=?");
                st.setString(1, request.getParameter("IDCita").toString());
                st.executeUpdate();
                response.sendRedirect("./Cita");
            }

        } catch (SQLException | ClassNotFoundException ex) {
                        ex.toString();
        }
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
