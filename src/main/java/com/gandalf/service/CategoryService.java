package com.gandalf.service;

import com.gandalf.DAO.CategoryDAO;
import com.gandalf.DTO.CategoryDTO;
import com.gandalf.models.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/category")
public class CategoryService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        ArrayList<CategoryDTO> categoriesDTO = new ArrayList<CategoryDTO>();

        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Categoria> categories = categoryDAO.get();

            if (categories.isEmpty()) {
                return Response.status(404).entity(categories).build();
            }

            for (Categoria category : categories) {
                categoriesDTO.add(categoryDAO.getCategoryDTO(category));
            }

            return Response.status(200).entity(categoriesDTO).build();
        } catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
}
