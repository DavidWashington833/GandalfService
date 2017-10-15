/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.pi.gandalf.DAO.ProdutoDAO;
import com.pi.gandalf.DTO.ItemProdutoDTO;
import com.pi.gandalf.DTO.ItemProdutoListaDTO;
import com.pi.gandalf.models.Produto;
import java.util.ArrayList;
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
        List<Produto> produtos = null;
        Response response = null;
        ArrayList<ItemProdutoListaDTO> itemProdutoListaDTO = new ArrayList<ItemProdutoListaDTO>(); 
        
        try {
            produtos = new ProdutoDAO().get();
            
            for(Produto item : produtos){
                if (item.getAtivoProduto() == 49) {
                    itemProdutoListaDTO.add(new ItemProdutoListaDTO(item));
                }
            }
            
            response = Response.status(200).entity(itemProdutoListaDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (produtos == null) {
            response = Response.status(404).entity(produtos).build();
        }
        
        return response;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Produto produto = null;
        Response response = null;
        ItemProdutoDTO itemProdutoDTO = null;
        
        try {
            produto = new ProdutoDAO().get(id);
            itemProdutoDTO = new ItemProdutoDTO(produto);
            response = Response.status(200).entity(itemProdutoDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (produto == null) {
            response = Response.status(404).entity(produto).build();
        }
        
        return response;
    }
    
    @GET
    @Path("/categoria/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForCategoria(@PathParam("id") int id) {
        List<Produto> produtos = null;
        Response response = null;
        ArrayList<ItemProdutoListaDTO> itemProdutoListaDTO = new ArrayList<ItemProdutoListaDTO>(); 
        
        try {
            produtos = new ProdutoDAO().getForCategoria(id);
            
            for(Produto item : produtos){
                if (item.getAtivoProduto() == 49) {
                    itemProdutoListaDTO.add(new ItemProdutoListaDTO(item));
                }
            }
            
            response = Response.status(200).entity(itemProdutoListaDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (produtos == null) {
            response = Response.status(404).entity(produtos).build();
        }
        
        return response;
    }
    
    @GET
    @Path("/like/{nomeProduto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("nomeProduto") String nomeProduto) {
        List<Produto> produtos = null;
        Response response = null;
        ArrayList<ItemProdutoListaDTO> itemProdutoListaDTO = new ArrayList<ItemProdutoListaDTO>(); 
        
        try {
            produtos = new ProdutoDAO().like(nomeProduto);
            
            for(Produto item : produtos){
                if (item.getAtivoProduto() == 49) {
                    itemProdutoListaDTO.add(new ItemProdutoListaDTO(item));
                }
            }
            
            response = Response.status(200).entity(itemProdutoListaDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (produtos == null) {
            response = Response.status(404).entity(produtos).build();
        }
        
        return response;
    }
}
