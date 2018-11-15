/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.service;

import com.google.gson.Gson;
import com.gandalf.DAO.ClientDAO;
import com.gandalf.DAO.AddressDAO;
import com.gandalf.DAO.ProductDAO;
import com.gandalf.DTO.ClientDTO;
import com.gandalf.DTO.AddressDTO;
import com.gandalf.DTO.ProductDTO;
import com.gandalf.models.Cliente;
import com.gandalf.models.Endereco;
import com.gandalf.models.ErrorMessage;
import com.gandalf.models.Produto;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author David Washington
 */
@Path("/address")
public class AddressService {
      
    @POST
    public Response post(AddressDTO addressDTO) {
        try {
            AddressDAO addressDAO = new AddressDAO();
            Endereco address = addressDAO.getAddress(addressDTO);
            addressDAO.add(address);
            return Response.status(201).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @GET
    @Path("/client/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getForClient(@PathParam("id") int id) {
        try {
            ArrayList<AddressDTO> addressesDTO = new ArrayList<AddressDTO>(); 
            AddressDAO addressDAO = new AddressDAO();
            List<Endereco> addresses = addressDAO.getForClient(id);
            
            for(Endereco address : addresses){
                addressesDTO.add(addressDAO.getAddressDTO(address));
            }
     
            if (addressesDTO.size() == 0) {
                return Response.status(404).build();
            }

            return Response.status(200).entity(addressesDTO).build();
        }        
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, AddressDTO addressDTO) {
        try {
            AddressDAO addressDAO = new AddressDAO();
            Endereco address = addressDAO.get(id);
            
            if (address == null) {
                return Response.status(404).entity(new ErrorMessage("Address not found.")).build();
            }
                
            addressDAO.put(address, addressDTO);
            return Response.status(200).build();
        }  
        catch (Exception exception) {
            exception.printStackTrace();
            return Response.status(500).build();
        }
    }
}
