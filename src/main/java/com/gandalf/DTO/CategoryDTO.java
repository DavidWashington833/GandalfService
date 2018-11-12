/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DTO;

import com.gandalf.models.Categoria;
import com.gandalf.models.Produto;
import com.google.gson.annotations.Expose;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author David Washington
 */
public class CategoryDTO {

    public int idCategoria;
    public String nomeCategoria;
    public String descCategoria;

    public CategoryDTO() {}
   
    public CategoryDTO(Categoria category) {
        this.idCategoria = category.getIdCategoria();
        this.nomeCategoria = category.getNomeCategoria();
        this.descCategoria = category.getDescCategoria();
    }
    
}
