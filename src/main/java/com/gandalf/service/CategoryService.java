/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.service;

import com.google.gson.Gson;
import com.gandalf.DAO.CategoryDAO;
import com.gandalf.DAO.ProductDAO;
import com.gandalf.DTO.CategoryDTO;
import com.gandalf.DTO.ProductDTO;
import com.gandalf.Helpers;
import com.gandalf.models.Categoria;
import com.gandalf.models.Produto;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author David Washington
 */
@Path("/category")
public class CategoryService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ArrayList<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();
        
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Categoria> categories = categoryDAO.get();
        
            if (categories.size() == 0) {
                return Response.status(404).entity(categories).build();
            }
            
            for(Categoria category : categories){
                categoriesDTO.add(categoryDAO.getCategoryDTO(category));
            }
            
            return Response.status(200).entity(categoriesDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
}
