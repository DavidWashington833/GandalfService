/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.CategoriaDAO;
import com.pi.gandalf.DAO.ProdutoDAO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Silva
 */
@Path("/categoria")
public class CategoriaService {
    
    private String driver;
    private String url;
    private String user;
    private String pass;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        List<Categoria> categorias = null;
        Response response = null;
        
        try {
            categorias = new CategoriaDAO().get();
            String categoriasJSON = gson.toJson(categorias);
            response = Response.status(200).entity(categoriasJSON).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (categorias == null) {
            return Response.status(404).entity(categorias).build();
        }
        
        return response;
    }
}
