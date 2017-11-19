/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.PedidoDAO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Silva
 */
@Path("/pedido")
public class PedidoService {
    @GET
    @Path("/cliente/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForCliente(@PathParam("id") int id) {
        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
        List<Pedido> pedidos = new ArrayList<>();
        Response response = null;
        
        try {
            pedidos = new PedidoDAO().getForCliente(id);
            response = Response.status(200).entity(gson.toJson(pedidos)).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        if (pedidos == null) {
            response = Response.status(404).entity(gson.toJson(pedidos)).build();
        }
        
        return response;
    }
}
