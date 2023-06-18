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

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String sHtml = "";
            VHtml objVHtml = new VHtml();
            sHtml = objVHtml.getHeader()+objVHtml.getBody()+
                    "<h3 class=\"text-primary text-center\">MENU DEL SISTEMA</h3>"
                    + "<br>"
                    + "<a href=\"./Paciente\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/paciente.png\" Width=\"100\" />"
                    + "PACIENTES</a>"
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./Doctor\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/doctor.png\" Width=\"100\" />"
                    + "DOCTOR</a>"
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./Cita\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/citamedica.png\" Width=\"100\" />"
                    + "CITA</a>"
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./Historial\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/historial.png\" Width=\"100\" />"
                    + "HISTORIAL</a>"      
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./EditarDatos\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/paciente.png\" Width=\"100\" />"
                    + "Editar Datos</a>"      
                                        + "<br>"
                                        + "<br>"                    
                    + "<br><a href=\"./\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">" 
                    + "Salir</button></a>"
                    +objVHtml.getFooter();
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println(sHtml);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        Connection cnx;
        String sNombre="";
        String sHtml = "";
        VHtml objVHtml = new VHtml();
        try{
            cnx = initializeDatabases();
            PreparedStatement st = cnx.prepareStatement("Select * from tbusuario where nombre =? and password =?");
            st.setString(1,request.getParameter("nombre").toString());
            st.setString(2,request.getParameter("password").toString());
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                sNombre= rs.getString(1);
            }
            if(sNombre.equals(""))
                response.sendRedirect("index.html");
            else
            {
                sHtml = objVHtml.getHeader()+objVHtml.getBody()+
                    "<h3 class=\"text-primary text-center\">MENU DEL SISTEMA</h3>"
                    + "<br>"
                    + "<a href=\"./Paciente\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/paciente.png\" Width=\"100\" />"
                    + "PACIENTES</a>"
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./Doctor\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/doctor.png\" Width=\"100\" />"
                    + "DOCTORES</a>"
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./Cita\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/citamedica.png\" Width=\"100\" />"
                    + "CITAS</a>"
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./Historial\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/historial.png\" Width=\"100\" />"
                    + "HISTORIAL</a>"      
                                        + "<br>"
                                        + "<br>"
                    + "<a href=\"./EditarDatos\">"
                    + "<img class=\"img-responsive center-block\" src=\"img/paciente.png\" Width=\"100\" />"
                    + "Editar Datos</a>"      
                                        + "<br>"
                                        + "<br>"                            
                    + "<br><a href=\"./\"><button class=\"btn btn-success glyphicon glyphicon-new-window\">" 
                    + "Salir</button></a>"
                    +objVHtml.getFooter();
                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.println(sHtml);
            }
        }catch(SQLException | ClassNotFoundException ex){
            ex.toString();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
