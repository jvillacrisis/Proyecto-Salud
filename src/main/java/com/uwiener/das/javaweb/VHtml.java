package com.uwiener.das.javaweb;

import java.util.HashSet;
import java.util.Set;

public class VHtml {

    private String Header;
    private String Body;
    private String Footer;

    public VHtml() {
        this.setHeader("<!doctype html>\n"
                + "<html class=\"no-js\" lang=\"\"> <!--<![endif]-->\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n"
                + "        <title>Desarrollo de Aplicaciones en Salud</title>\n"
                + "        <meta name=\"description\" content=\"\">\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                + "        <link rel=\"apple-touch-icon\" href=\"apple-touch-icon.png\">\n"
                + "\n"
                + "        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"css/bootstrap-theme.min.css\">\n"
                + "        <link rel=\"stylesheet\" href=\"css/styles.css\">\n"
                + "        <style>\n"
                + "            body {\n"
                + "                padding-bottom: 20px;\n"
                + "            }\n"
                + "        </style>\n"
                + "        <link rel=\"stylesheet\" href=\"webjars/bootstrap/5.2.2/css/bootstrap.css\">\n"
                + "    </head>");

        this.setFooter("        </div>\n"
                + "        <div class=\"col-md-2\"></div>\n"
                + "      </div>      \n"
                + "      <footer>\n"
                + "        <p>&copy; 2023 UNIVERSIDAD NORBERT WIENER - Grupo 6</p>\n"
                + "      </footer>\n"
                + "    </div> \n"
                + "        <!-- /container -->        \n"
                + "        <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n"
                + "        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.11.2.min.js\"><\\/script>')</script>\n"
                + "\n"
                + "        <script src=\"js/vendor/bootstrap.min.js\"></script>\n"
                + "\n"
                + "        <script src=\"js/main.js\"></script>\n"
                + "        <script src=\"jquery/js.js\"></script>\n"
                + "\n"
                + "        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->\n"
                + "        <script>\n"
                + "            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=\n"
                + "            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;\n"
                + "            e=o.createElement(i);r=o.getElementsByTagName(i)[0];\n"
                + "            e.src='//www.google-analytics.com/analytics.js';\n"
                + "            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));\n"
                + "            ga('create','UA-XXXXX-X','auto');ga('send','pageview');\n"
                + "        </script>\n"
                + "    </body>\n"
                + "</html>\n"
                + "");
        this.setBody("<body>\n"
                + "<nav class=\"nav nav-system\">\n"
                + "  <div class=\"container\">\n"
                + "     <div class=\"row\">\n"
                + "          <div class=\"col-md-4\"></div>\n"
                + "          <div class=\"col-md-4 text-center\"><img src=\"img/SIGCI.png\"></div>\n"
                + "          <div class=\"col-md-4\"> <a href=\"index.html\"><button class=\"btn btn-danger glyphicon glyphicon-new-window\">Salir</button></a></div>\n"
                + "     </div>\n"
                + "</div>"
                + "</nav>"
                + "<div class=\"row\">\n"
                + "     <div class=\"container lateral\">\n"
                + "             <a href=\"./Cita\">"
                + "             <img class=\"img-responsive center-block\" src=\"img/citamedica.png\" />"
                + "             <br>"
                + "             Reservar Cita</a>"
                + "             <a href=\"./Paciente\">"
                + "             <img class=\"img-responsive center-block\" src=\"img/paciente.png\" />"
                + "             <br>"
                + "             Pacientes</a>"
                + "             <a href=\"./Doctor\">"
                + "             <img class=\"img-responsive center-block\" src=\"img/doctor.png\" />"
                + "             <br>"
                + "             Doctores</a>"
                + "             <a href=\"./Historial\">"
                + "             <img class=\"img-responsive center-block\" src=\"img/historial.png\" />"
                + "             <br>"
                + "             Historial</a>"      
                + "             <a href=\"./EditarDatos\">"
                + "             <img class=\"img-responsive center-block\" src=\"img/edit.png\"  />"
                + "             <br>"
                + "             Editar Datos Personales</a>"                
                + "         </div>\n"
                + "     </div>\n"
                + "</div>");
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String Header) {
        this.Header = Header;
    }

    public String getFooter() {
        return Footer;
    }

    public void setFooter(String Footer) {
        this.Footer = Footer;
    }
    
        public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }
}
