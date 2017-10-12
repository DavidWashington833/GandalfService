/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.ClienteDAO;
import com.pi.gandalf.DAO.ProdutoDAO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Produto;
import java.util.List;
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
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{teste}")
    public Response post(@PathParam("teste") String teste) {
//        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
//        ClienteDAO clienteDAO = new ClienteDAO();
//        Cliente cliente = null;
//        Response response = null;
//        
//        cliente = new Cliente();
//        cliente.setNomeCompletoCliente("Hebert");
//        cliente.setEmailCliente("hebert@gmail.com");
//        cliente.setSenhaCliente("123131");
//        cliente.setCpfcliente("123123");
//        
//        try {
//            clienteDAO.add(cliente);
//            String clienteJSON = gson.toJson(cliente);
//            response = Response.status(200).entity(clienteJSON).build();
//        }        
//        catch (Exception exception) {
//            exception.printStackTrace();
//            response = Response.status(500).entity(null).build();
//        }
//        
//        if (cliente == null) {
//            return Response.status(404).entity(cliente).build();
//        }
//        
//        return response;
        return Response.status(200).entity(teste).build();
    }
    
}
