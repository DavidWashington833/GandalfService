/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import com.gandalf.DAO.ClientDAO;
import com.gandalf.models.Cliente;
import com.gandalf.models.Endereco;

/**
 *
 * @author David Washington
 */
public class AddressDTO {
    
    public int id;    
    public int idClient;
    public String name;
    public String publicPlace;
    public String number;
    public String CEP;
    public String complement;
    public String city;
    public String country;
    public String UF;
    
}
