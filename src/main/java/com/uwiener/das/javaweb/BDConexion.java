package com.uwiener.das.javaweb;

import com.sun.org.apache.bcel.internal.classfile.ElementValue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexion {
protected static Connection initializeDatabases() 
        throws SQLException, ClassNotFoundException
{
    String bdDriver ="com.mysql.jdbc.Driver";
    String bdURL="jdbc:mysql://localhost:3306/";
    String bdUser="root";
    String bdPass="";
    String bdDataBase="sigci";
    Class.forName(bdDriver);
    Connection cnx = DriverManager.getConnection(bdURL + bdDataBase, bdUser, bdPass);
    return cnx;
}
    
}
