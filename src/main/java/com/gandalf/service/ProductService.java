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
        try {
            ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 
            ProductDAO productDAO = new ProductDAO();
            List<Produto> products = productDAO.get();
            
            for(Produto product : products){
                if (product.getAtivoProduto() == 49) {
                    productsDTO.add(productDAO.getProductDTO(product));
                }
            }
     
            if (productsDTO.size() == 0) {
                return Response.status(404).build();
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
            ProductDAO productDAO = new ProductDAO();
            Produto product = productDAO.get(id);
        
            if (product == null) {
                return Response.status(404).build();
            }
            
            ProductDTO productDTO = productDAO.getProductDTO(product);
            return Response.status(200).entity(productDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForCategoria(@PathParam("id") int id) {
        try {
            ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 
            ProductDAO productDAO = new ProductDAO();
            List<Produto> products = productDAO.getForCategoria(id);
            
            for(Produto product : products){
                if (product.getAtivoProduto() == 49) {
                    productsDTO.add(productDAO.getProductDTO(product));
                }
            }
     
            if (productsDTO.size() == 0) {
                return Response.status(404).build();
            }

            return Response.status(200).entity(productsDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/search/{nameProduct}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@PathParam("nameProduct") String nameProduct) {
        try {
            ArrayList<ProductDTO> productsDTO = new ArrayList<ProductDTO>(); 
            ProductDAO productDAO = new ProductDAO();
            List<Produto> products = productDAO.like(nameProduct);
            
            for(Produto product : products){
                if (product.getAtivoProduto() == 49) {
                    productsDTO.add(productDAO.getProductDTO(product));
                }
            }
            
            if (productsDTO.size() == 0) {
                return Response.status(404).build();
            }

            return Response.status(200).entity(productsDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
}
