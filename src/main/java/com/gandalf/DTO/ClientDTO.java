/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import com.gandalf.models.Cliente;
import java.util.Date;

/**
 *
 * @author David Washington
 */
public class ClientDTO {
    
    public int id;
    public String fullName;
    public String email;
    public String password;
    public String CPF;
    public String cellPhone;
    public String commercialPhone;
    public String homePhone;
    public Date birthDay;
    public Boolean acceptNewsletter;
  
}
