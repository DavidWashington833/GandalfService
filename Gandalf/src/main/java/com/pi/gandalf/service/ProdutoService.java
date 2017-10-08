/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.ProdutoDAO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Produto;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Silva
 */
@Path("/produto")
public class ProdutoService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        List<Produto> produtos = null;
        Response response = null;
        
        try {
            produtos = new ProdutoDAO().get();
            String produtosJSON = gson.toJson(produtos);
            response = Response.status(200).entity(produtosJSON).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (produtos == null) {
            return Response.status(404).entity(produtos).build();
        }
        
        return response;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        Produto produto = null;
        Response response = null;
        
        try {
            produto = new ProdutoDAO().get(id);
            String produtoJSON = gson.toJson(produto);
            response = Response.status(200).entity(produtoJSON).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (produto == null) {
            return Response.status(404).entity(produto).build();
        }
        
        return response;
    }
    
}
