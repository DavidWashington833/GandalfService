/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cabelo.senac.pi4.gandalf;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author david.wfsilva
 */
public class Database {
    private static Database instance = null;

    private Database () {};

    public static Database get () {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public Connection conn () throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://gandalf-pi.database.windows.net;user=TSI@gandalf-pi.database.windows.net;password=SistemasInternet123;database=gandalf");
        return conn;
    }
}
