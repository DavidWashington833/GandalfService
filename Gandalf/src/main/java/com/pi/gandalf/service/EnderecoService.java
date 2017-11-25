/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.ClienteDAO;
import com.pi.gandalf.DAO.EnderecoDAO;
import com.pi.gandalf.DTO.ClienteDTO;
import com.pi.gandalf.DTO.EnderecoDTO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Endereco;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
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
 * @author Silva
 */
@Path("/endereco")
public class EnderecoService {
      
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(EnderecoDTO enderecoDTO) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        Response response = null;
        Endereco endereco = enderecoDTO.getEndereco();
        
        try {
            enderecoDAO.add(endereco);
            response = Response.status(200).entity(endereco).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (response == null) {
            return Response.status(404).entity(endereco).build();
        }
        
        return response;
    }
    
    @GET
    @Path("/cliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForCliente(@PathParam("id") int id) {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        List<Endereco> endereco = new ArrayList<>();
        Response response = null;
        
        try {
            endereco = new EnderecoDAO().getForCliente(id);
            response = Response.status(200).entity(gson.toJson(endereco)).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (endereco == null) {
            response = Response.status(404).entity(endereco).build();
        }
        
        return response;
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        Endereco endereco = null;
        Response response = null;
        
        try {
            endereco = new EnderecoDAO().get(id);
            response = Response.status(200).entity(gson.toJson(endereco)).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (endereco == null) {
            response = Response.status(404).entity(endereco).build();
        }
        
        return response;
    }
}
