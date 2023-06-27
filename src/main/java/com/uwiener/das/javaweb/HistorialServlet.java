/*
SELECT tbcita.IDCita, tbcita.IdTipoCita, tbcita.IdEspecialidad, tbcita.IdMedico, tbcita.Fecha, tbcita.IdUsuario, tbtipocita.TipoCita, tbespecialidad.Especialidad, tbmedico.ApellidoM, tbusuario.DNI FROM tbcita INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita INNER JOIN tbespecialidad on tbcita.IdEspecialidad=tbespecialidad.IDEspecialidad INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario WHERE tbcita.IdUsuario = 1

SELECT tbcita.IDCita, tbcita.IdTipoCita, tbcita.IdEspecialidad, tbcita.IdMedico, tbcita.Fecha, tbcita.IdUsuario, tbtipocita.TipoCita, tbespecialidad.Especialidad, tbmedico.ApellidoM, tbusuario.DNI FROM tbcita INNER JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita INNER JOIN tbespecialidad on tbcita.IdEspecialidad=tbespecialidad.IDEspecialidad INNER JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario WHERE tbusuario.DNI=77889977
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

@WebServlet(name = "HistorialServlet", urlPatterns = {"/Historial"})
public class HistorialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx;
        String sHtml = "";
        VHtml objVHtml = new VHtml();
        String sTabla = "";
        try {
            cnx = initializeDatabases();
            PreparedStatement st = cnx.prepareStatement("SELECT tbcita.IDCita, tbcita.IdTipoCita, tbcita.IdEspecialidad, tbcita.IdMedico, tbcita.Fecha, tbcita.IdUsuario, "
                    + "tbtipocita.TipoCita, tbespecialidad.Especialidad, tbmedico.ApellidoM, tbusuario.DNI "
                    + "FROM tbcita "
                    + "LEFT JOIN tbtipocita on tbcita.IdTipoCita=tbtipocita.IdTipoCita "
                    + "LEFT JOIN tbespecialidad on tbcita.IdEspecialidad=tbespecialidad.IDEspecialidad "
                    + "LEFT JOIN tbmedico on tbcita.IdMedico=tbmedico.IdMedico "
                    + "INNER JOIN tbusuario on tbcita.IdUsuario=tbusuario.IDUsuario WHERE tbusuario.DNI like ? ");
            if (request.getParameter("DNI") != null) {
                st.setString(1, "%" + request.getParameter("DNI").toString() + "%");
            } else {
                st.setString(1, "%%");
            }

            ResultSet rs = st.executeQuery();
            sHtml = objVHtml.getHeader() + objVHtml.getBody()
                    + "<h3 class=\"text-primary text-center\">Historial de Citas</h3> <br>"
                    + "                   <form  action=\"./Historial\">"
                    + "                            <input type=\"text\" name =\"DNI\" />  "
                    + "                           <button type=\"summit\" class=\"btn btn-success\">Buscar</button>\n"
                    + "                   </form>"
                    + "                    <table class=\"table table-striped\">\n"
                    + "                        <tr>\n"
                    + "                            <th>ID</th>\n" /*1*/
                    + "                            <th>DNI</th>\n" /*1*/
                    + "                            <th>Especialidad</th>\n" /*7*/
                    + "                            <th>Apellido M</th>\n" /*8*/
                    + "                            <th>Tipo Cita</th>\n" /*6*/
                    + "                            <th>Fecha</th>\n" /*5*/
                    + "                        </tr>\n";
            while (rs.next()) {
                sTabla += "<tr>\n"
                        + "   <td>" + rs.getInt(1) + "</td>\n"
                        + "   <td>" + rs.getInt(10) + "</td>\n"
                        + "   <td>" + rs.getString(8) + "</td>\n"
                        + "   <td>" + rs.getString(9) + "</td>\n"
                        + "   <td>" + rs.getString(7) + "</td>\n"
                        + "   <td>" + rs.getString(5) + "</td>\n"
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
}
