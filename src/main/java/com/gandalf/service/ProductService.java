/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.service;

import com.gandalf.DAO.ProductDAO;
import com.gandalf.DTO.ProductDTO;
import com.gandalf.models.Produto;
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
 * @author David Washington
 */
@Path("/product")
public class ProductService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 
        
        try {
            List<Produto> products = new ProductDAO().get();
     
            if (products == null) {
                return Response.status(404).entity(products).build();
            }
            
            for(Produto product : products){
                if (product.getAtivoProduto() == 49) {
                    productsDTO.add(new ProductDTO(product));
                }
            }

            return Response.status(200).entity(productsDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        try {
            Produto product = new ProductDAO().get(id);
        
            if (product == null) {
                return Response.status(404).entity(product).build();
            }
            
            ProductDTO productDTO = new ProductDTO(product);
            return Response.status(200).entity(productDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/categoria/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForCategoria(@PathParam("id") int id) {
        ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 
        
        try {
            List<Produto> products = new ProductDAO().getForCategoria(id);
     
            if (products == null) {
                return Response.status(404).entity(products).build();
            }
            
            for(Produto product : products){
                if (product.getAtivoProduto() == 49) {
                    productsDTO.add(new ProductDTO(product));
                }
            }

            return Response.status(200).entity(productsDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/search/{nomeProduto}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("nomeProduto") String nomeProduto) {
        ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 
        
        try {
            List<Produto> products = new ProductDAO().like(nomeProduto);
     
            if (products == null) {
                return Response.status(404).entity(products).build();
            }
            
            for(Produto product : products){
                if (product.getAtivoProduto() == 49) {
                    productsDTO.add(new ProductDTO(product));
                }
            }

            return Response.status(200).entity(productsDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
}
