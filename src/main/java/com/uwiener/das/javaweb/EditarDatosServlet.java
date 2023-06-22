/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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

@WebServlet(name = "EditarDatosServlet", urlPatterns = {"/EditarDatos"})
public class EditarDatosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection cnx;
        String sHtml = "";
        VHtml objVHtml = new VHtml();
        String sTabla = "";
        try {
            cnx = initializeDatabases();
            PreparedStatement st = cnx.prepareStatement("SELECT idusuario, nombre, apellido, dni, correo, password, direccion FROM tbusuario WHERE idusuario=1");
            ResultSet rs = st.executeQuery();
            sHtml = objVHtml.getHeader() + objVHtml.getBody()
                    +"<div class=\"container\">\n"
                    + "<h3 class=\"text-center\">Editar Datos</h3> <br>"

                    + "                        <table class=\"table table-striped\">\n"
                    + "                        <tr>\n"
                    + "                            <th>Idusuario</th>\n"
                    + "                            <th>Nombre</th>\n"
                    + "                            <th>Apellido</th>\n"
                    + "                            <th>DNI</th>\n"
                    + "                            <th>Correo</th>\n"
                    + "                            <th>Clave</th>\n"
                    + "                            <th>Direccion</th>\n"
                    + "                            <th>Editar</th>\n"
                    + "                        </tr>\n";
            while (rs.next()) {
                sTabla += "<tr>\n"
                        + "   <td>" + rs.getInt(1) + "</td>\n"
                        + "   <td>" + rs.getString(2) + "</td>\n"
                        + "   <td>" + rs.getString(3) + "</td>\n"
                        + "   <td>" + rs.getInt(4) + "</td>\n"
                        + "   <td>" + rs.getString(5) + "</td>\n"
                        + "   <td>" + rs.getString(6) + "</td>\n"
                        + "   <td>" + rs.getString(7) + "</td>\n"
                        + "   <td><a href=\"./EditarDatosPaciente.jsp?idusuario=" + rs.getInt(1) + "&nombre=" + rs.getString(2) + "&apellido=" + rs.getString(3) + "&dni=" + rs.getInt(4) + "&correo=" + rs.getString(5) + "&password=" + rs.getString(6) + "&direccion=" + rs.getString(7) + "\"><button class=\"btn btn-warning\"> Editar</button></a></td>\n"
                        + "</tr>\n";
            }
            sHtml += sTabla + "</table>"
                         +"</div>\n"
                    + objVHtml.getFooter();
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
            if (request.getParameter("accion").equals("IDP")) {
                st = cnx.prepareStatement("insert into tbusuario (idusuario, nombre, apellido, dni, correo, password, direccion) values (?,?,?,?,?,?,?)");
                st.setString(1, request.getParameter("idusuario").toString());
                st.setString(2, request.getParameter("nombre").toString());
                st.setString(3, request.getParameter("apellido").toString());
                st.setString(4, request.getParameter("dni").toString());
                st.setString(5, request.getParameter("correo").toString());
                st.setString(6, request.getParameter("password").toString());
                st.setString(7, request.getParameter("direccion").toString());
                st.executeUpdate();
                response.sendRedirect("./");
            } else if (request.getParameter("accion").equals("EDP")) {
                st = cnx.prepareStatement("update tbusuario set nombre=?, apellido=?, dni=?, correo=?, password=?, direccion=? where idusuario=?");
                st.setString(1, request.getParameter("nombre").toString());
                st.setString(2, request.getParameter("apellido").toString());
                st.setString(3, request.getParameter("dni").toString());
                st.setString(4, request.getParameter("correo").toString());
                st.setString(5, request.getParameter("password").toString());
                st.setString(6, request.getParameter("direccion").toString());
                st.setString(7, request.getParameter("idusuario").toString());
                st.executeUpdate();
                response.sendRedirect("./EditarDatos");
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
