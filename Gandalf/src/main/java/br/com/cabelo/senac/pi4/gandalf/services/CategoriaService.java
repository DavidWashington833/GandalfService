/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cabelo.senac.pi4.gandalf.services;

import br.com.cabelo.senac.pi4.gandalf.Categoria;
import br.com.cabelo.senac.pi4.gandalf.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david.wfsilva
 */
@Path ("/categoria")
public class CategoriaService {
    
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategoria(@PathParam("param") String idCategoria) {
        String id = idCategoria;
        Categoria categoria = null;

        try {
            Connection conn = Database.get().conn();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM categoria WHERE idCategoria = ?");
            ps.setInt(1, Integer.parseInt(id));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                categoria = new Categoria();
                categoria.setNomeCategoria(rs.getString("nomeCategoria"));
                categoria.setDescCategoria(rs.getString("descCategoria"));
                categoria.setIdCategoria(rs.getInt("idCategoria"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.status(500).entity(null).build();
        }
        if (categoria == null) {
            return Response.status(404).entity(categoria).build();
        }
        else {
            return Response.status(200).entity(categoria).build();
        }
    }
	
}
