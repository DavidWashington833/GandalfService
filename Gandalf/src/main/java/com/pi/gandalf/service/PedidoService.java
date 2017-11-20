/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.gandalf.service;

import com.google.gson.Gson;
import com.pi.gandalf.DAO.ClienteDAO;
import com.pi.gandalf.DAO.PedidoDAO;
import com.pi.gandalf.DTO.ClienteDTO;
import com.pi.gandalf.Helpers;
import com.pi.gandalf.models.Cliente;
import com.pi.gandalf.models.Pedido;
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
@Path("/pedido")
public class PedidoService { 
    @POST
    @Path("/teste")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(String pedido) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
//        PedidoDAO pedidoDAO = new PedidoDAO();
//        Response response = null;
//        
//        try {
//            pedidoDAO.add(pedido);
//            String pedidoJSON = gson.toJson(pedido);
//            response = Response.status(200).entity(pedido).build();
//        }        
//        catch (Exception exception) {
//            exception.printStackTrace();
//            response = Response.status(500).entity(null).build();
//        }
//        
//        if (pedido == null) {
//            return Response.status(404).entity(pedido).build();
//        }
        
        return Response.status(200).entity(pedido).build();
    }
    
//    @POST;
//    @Path("/change")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response put(Pedido pedido) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        Gson gson = Helpers.excludeFieldsWithoutExposeAnnotation();
//        PedidoDAO pedidoDAO = new PedidoDAO();
//        Response response = null;
//        
//        try {
//            pedidoDAO.add(pedido);
//            String pedidoJSON = gson.toJson(pedido);
//            response = Response.status(200).entity(pedido).build();
//        }        
//        catch (Exception exception) {
//            exception.printStackTrace();
//            response = Response.status(500).entity(null).build();
//        }
//        
//        if (pedido == null) {
//            return Response.status(404).entity(pedido).build();
//        }
//        
//        return response;
//    }
    
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
