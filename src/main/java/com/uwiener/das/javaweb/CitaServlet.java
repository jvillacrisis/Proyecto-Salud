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
            PreparedStatement st = cnx.prepareStatement("SELECT tbcita.IDCita, tbcita.IdTipoCita, tbcita.IdEspecialidad, "
                    + "tbcita.IdMedico, tbcita.Fecha, tbcita.IdUsuario,"
                    + "tbtipocita.TipoCita, tbespecialidad.Especialidad, tbmedico.ApellidoM, "
                    + "tbusuario.DNI "
                    + "FROM tbcita "
                    + "INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita "
                    + "INNER JOIN tbespecialidad on tbcita.IdEspecialidad=tbespecialidad.IDEspecialidad "
                    + "INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico "
                    + "INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario");
            ResultSet rs = st.executeQuery();
            sHtml = objVHtml.getHeader() + objVHtml.getBody()
                    + "<h3 class=\"text-primary text-center\">Registro de Citas</h3> <br>"
                    + "                    <a href=\"./Login\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">\n"
                    + "                            Regresar</button></a>\n"
                    + "                    <a href=\"nuevacita.jsp\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">\n"
                    + "                            Nueva Cita</button></a>\n"
                    + "                    <table class=\"table table-striped\">\n"
                    + "                        <tr>\n"
                    + "                            <th>ID</th>\n" /*1*/
                    + "                            <th>DNI</th>\n" /*1*/
                    + "                            <th>Especialidad</th>\n" /*7*/
                    + "                            <th>Apellido M</th>\n" /*8*/
                    + "                            <th>Tipo Cita</th>\n" /*6*/
                    + "                            <th>Fecha</th>\n" /*5*/
                    + "                            <th>Editar</th>\n" /**/
                    + "                            <th>Borrar</th>\n"/**/
                    + "                        </tr>\n";
            while (rs.next()) {
                sTabla += "<tr>\n"
                        + "   <td>" + rs.getInt(1) + "</td>\n"
                        + "   <td>" + rs.getInt(10) + "</td>\n"
                        + "   <td>" + rs.getString(8) + "</td>\n"
                        + "   <td>" + rs.getString(9) + "</td>\n"
                        + "   <td>" + rs.getString(7) + "</td>\n"
                        + "   <td>" + rs.getString(5) + "</td>\n"
                        + "   <td><a href=\"./editarcita.jsp?IDCita=" + rs.getInt(1) + "&IdTipoCita=" + rs.getInt(2) + "&IdEspecialidad=" + rs.getInt(3) + "&IdMedico=" + rs.getInt(4) + "&Fecha=" + rs.getString(5) + "&IdUsuario=" + rs.getInt(6) + "&TipoCita=" + rs.getString(7) + "&Especialidad=" + rs.getString(8) + "&ApellidoM=" + rs.getString(9) + "&DNI=" + rs.getString(10) + "\"><button class=\"btn btn-warning\"> Editar</button></a></td>\n"
                        + "   <td><a href=\"./borrarcita.jsp?IDCita=" + rs.getInt(1) + "&IdTipoCita=" + rs.getInt(2) + "&IdEspecialidad=" + rs.getInt(3) + "&IdMedico=" + rs.getInt(4) + "&Fecha=" + rs.getString(5) + "&IdUsuario=" + rs.getInt(6) + "&TipoCita=" + rs.getString(7) + "&Especialidad=" + rs.getString(8) + "&ApellidoM=" + rs.getString(9) + "&DNI=" + rs.getString(10) + "\"><button class=\"btn btn-danger\"> Borrar</button></a></td>\n"
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
            if (request.getParameter("accion").equals("IC")) {
                st = cnx.prepareStatement("insert into tbcita (IDCita, IdTipoCita, IdEspecialidad, IdMedico, Fecha, IdUsuario) values (?,?,?,?,?,?)");
                st.setString(1, request.getParameter("IDCita").toString());
                st.setString(2, request.getParameter("IdTipoCita").toString());
                st.setString(3, request.getParameter("IdEspecialidad").toString());
                st.setString(4, request.getParameter("IdMedico").toString());
                st.setString(5, request.getParameter("Fecha").toString());
                st.setString(6, request.getParameter("IdUsuario").toString());
                st.executeUpdate();
                response.sendRedirect("./Cita");
            } else if (request.getParameter("accion").equals("EC")) {
                st = cnx.prepareStatement("update tbcita set IdTipoCita=?,IdEspecialidad=?,IdMedico=?,Fecha=?, IdUsuario=? where IDCita=?");
                st.setString(1, request.getParameter("IdTipoCita").toString());
                st.setString(2, request.getParameter("IdEspecialidad").toString());
                st.setString(3, request.getParameter("IdMedico").toString());
                st.setString(4, request.getParameter("Fecha").toString());
                st.setString(6, request.getParameter("IdUsuario").toString());
                st.setString(5, request.getParameter("IDCita"));
                st.executeUpdate();
                response.sendRedirect("./Cita");
            } else if (request.getParameter("accion").equals("BC")) {
                st = cnx.prepareStatement("delete from tbcita where IDCita=?");
                st.setString(1, request.getParameter("IDCita"));
                st.executeUpdate();
                response.sendRedirect("./Cita");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(ex.toString()
                    + " - " + request.getParameter("IdTipoCita")
                    + " - " + request.getParameter("IdEspecialidad")
                    + " - " + request.getParameter("IdMedico")
                    + " - " + request.getParameter("Fecha")
                    + " - " + request.getParameter("IDCita"));
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
