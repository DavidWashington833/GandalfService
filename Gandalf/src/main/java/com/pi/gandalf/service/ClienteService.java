/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.ClienteDAO;
import com.pi.gandalf.DTO.ClienteDTO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Cliente;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david.wfsilva
 */
@Path("/cliente")
public class ClienteService {
     
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(ClienteDTO clienteDTO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        ClienteDAO clienteDAO = new ClienteDAO();
        Response response = null;
        Cliente cliente = clienteDTO.getCliente();
        
        try {
            clienteDAO.add(cliente);
            String clienteJSON = gson.toJson(cliente);
            response = Response.status(200).entity(cliente).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (cliente == null) {
            return Response.status(404).entity(cliente).build();
        }
        
        return response;
    }
    
    @GET
    @Path("/authentic/{email}/{password}")
    public Response authentic(@PathParam("email") String email, @PathParam("password") String password) {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        ArrayList<Cliente> clientes = new ClienteDAO().get(email, password);
        return Response.status(200).entity(gson.toJson(clientes)).build();
    }
}
