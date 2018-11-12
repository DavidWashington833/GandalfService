/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.DTO.CheckoutDTO;
import com.gandalf.DTO.ItemPedidoDTO;
import com.gandalf.DTO.PedidoDTO;
import com.gandalf.HibernateUtil;
import com.gandalf.models.Aplicacao;
import com.gandalf.models.Pedido;
import com.gandalf.models.ItemPedido;
import com.gandalf.models.Pedido;
import com.gandalf.models.StatusPedido;
import com.gandalf.models.TipoPagamento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author David Washington
 */
public class CheckoutDAO {
    private Session session;
    
    public CheckoutDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public Connection getConnection(String driver, String url, String user, String pass) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(url, user, pass);
    }
    
    public String add(CheckoutDTO checkoutDTO) {
        ResultSet rs = null;
        int idPedido = 0;
        try { 
            Connection conn = getConnection(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                "jdbc:sqlserver://gandalf-pi.database.windows.net:1433;databaseName=gandalf",
                "TSI",
                "SistemasInternet123"
            );
            
            String query = "INSERT INTO Pedido VALUES (" + checkoutDTO.getPedidoDTO().getIdCliente() + ", 1, '" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "', " + checkoutDTO.getPedidoDTO().getIdTipoPagto() + ",  " + checkoutDTO.getPedidoDTO().getIdEndereco() + ", 2)";
            PreparedStatement prest;
            prest = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prest.executeUpdate();
            rs = prest.getGeneratedKeys();
            
            if(rs.next())
                idPedido = rs.getInt(1);
            
            conn.close(); 
        } catch (Exception e) { 
        } 
        try { 
            Connection conn2 = getConnection(
                "com.microsoft.sqlserver.jdbc.SQLServerDriver",
                "jdbc:sqlserver://gandalf-pi.database.windows.net:1433;databaseName=gandalf",
                "TSI",
                "SistemasInternet123"
            );


            String query2 = "INSERT INTO ItemPedido VALUES ";
            PreparedStatement prest2 = null;
            ItemPedidoDTO[] item = checkoutDTO.getItemPedidosDTO();
            String t = "";

            for(int i = 0; i < item.length; i++) {
                t = i == 0 ? "" : ",";
                query2 += t + "(" + item[i].getIdProduto() + ", " + idPedido + ", " + item[i].getQtdProduto() + ", " + (new ProductDAO().get(item[i].getIdProduto()).getPrecProduto()) + ")";
            }

            prest2 = conn2.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS);
            prest2.executeUpdate();

            conn2.close(); 
        } catch (Exception e) { 
        } 
        return "";
    }
    
}
