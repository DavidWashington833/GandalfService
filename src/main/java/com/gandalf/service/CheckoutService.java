/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gandalf.DAO.CheckoutDAO;
import com.gandalf.DAO.ClienteDAO;
import com.gandalf.DTO.CheckoutDTO;
import com.gandalf.DTO.PedidoDTO;
import com.gandalf.DTO.ItemPedidoDTO;
import com.gandalf.DTO.PedidoDTO;
import com.gandalf.Helpers;
import com.gandalf.models.Cliente;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author David Washington
 */
@Path("/checkout")
public class CheckoutService {
    
    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response post(String json) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Gson gson = new Gson();
        
        Response response = null;
        
        try {
            ItemPedidoDTO[] itens = gson.fromJson(Helpers.getSubArrayJson(json, "itemPedidosDTO"), ItemPedidoDTO[].class);
            PedidoDTO pedido = gson.fromJson(Helpers.getSubObjectJson(json, "pedidoDTO"), PedidoDTO.class);

            CheckoutDAO checkoutDAO = new CheckoutDAO();
            CheckoutDTO checkoutDTO = new CheckoutDTO();
            checkoutDTO.setItemPedidosDTO(itens);
            checkoutDTO.setPedidoDTO(pedido);
            checkoutDAO.add(checkoutDTO);
            String checkoutJSON = gson.toJson(checkoutDTO.getItemPedidosDTO());
            response = Response.status(200).entity(checkoutJSON).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            response = Response.status(500).entity(null).build();
        }
        
        return response;
    }

    
}
