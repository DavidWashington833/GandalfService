/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.service;

import com.google.gson.Gson;
import com.gandalf.DAO.ClientDAO;
import com.gandalf.DTO.ClientDTO;
import com.gandalf.Helpers;
import com.gandalf.models.Authentic;
import com.gandalf.models.Cliente;
import com.gandalf.models.ErrorMessage;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author david.wfsilva
 */
@Path("/client")
public class ClientService {
     
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(ClientDTO clienteDTO) {
        try {
            ClientDAO clientDAO = new ClientDAO();
            Cliente client = clientDAO.getClient(clienteDTO);
            ArrayList<ErrorMessage> errors = new ArrayList<ErrorMessage>();
            
            if (clientDAO.hasEmail(client.getEmailCliente())) {
                errors.add(new ErrorMessage("Email is already registered."));
            }
            
            if (clientDAO.hasCPF(client.getCpfcliente())) {
                errors.add(new ErrorMessage("CPF is already registered."));
            }
            
            if (errors.size() > 0) {
                return Response.status(400).entity(errors).build();
            }
            
            clientDAO.add(client);
            return Response.status(201).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @POST
    @Path("/authentic")
    @Produces(MediaType.APPLICATION_JSON)
    public Response authentic(Authentic authentic) {
        try {
            ClientDAO clientDAO = new ClientDAO();
            Cliente client = clientDAO.get(authentic.email, authentic.password);
            
            if (client == null) {
                return Response.status(401).build();
            }
            
            ClientDTO clientDTO = clientDAO.getClientDTO(client);
            return Response.status(200).entity(clientDTO).build();
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
            ClientDAO clientDAO = new ClientDAO();
            Cliente client = clientDAO.get(id);
            
            if (client == null) {
                return Response.status(404).build();
            }
            
            ClientDTO clientDTO = clientDAO.getClientDTO(client);
            return Response.status(200).entity(clientDTO).build();
        }  
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, ClientDTO clientDTO) {
        try {
            ClientDAO clientDAO = new ClientDAO();
            Cliente client = clientDAO.get(id);
            ArrayList<ErrorMessage> errors = new ArrayList<ErrorMessage>();
            
            if (client == null) {
                return Response.status(404).entity(new ErrorMessage("Client not found.")).build();
            }
            
            if (clientDAO.hasEmail(client.getEmailCliente())) {
                errors.add(new ErrorMessage("Email is already registered."));
            }
            
            if (clientDAO.hasCPF(client.getCpfcliente())) {
                errors.add(new ErrorMessage("CPF is already registered."));
            }
            
            if (errors.size() > 0) {
                return Response.status(400).entity(errors).build();
            }
                
            clientDAO.put(client, clientDTO);
            return Response.status(200).build();
        }  
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
   
}
