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
    
    public int idCliente;
    public String nomeEndereco;
    public String logradouroEndereco;
    public String numeroEndereco;
    public String CEPEndereco;
    public String complementoEndereco;
    public String cidadeEndereco;
    public String paisEndereco;
    public String UFEndereco;
    
}
