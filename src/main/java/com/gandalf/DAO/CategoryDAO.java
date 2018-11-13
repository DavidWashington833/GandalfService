/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gandalf.DAO;

import com.gandalf.DTO.CategoryDTO;
import com.gandalf.HibernateUtil;
import com.gandalf.models.Categoria;
import com.gandalf.models.Produto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author David Washington
 */
public class CategoryDAO {
    private Session session;
    
    public CategoryDAO() {
        session = new HibernateUtil().getSession();
    }
    
    public List<Categoria> get() {
        return session.createCriteria(Categoria.class).list();
    }
    
    public CategoryDTO getCategoryDTO(Categoria category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.idCategoria = category.getIdCategoria();
        categoryDTO.nomeCategoria = category.getNomeCategoria();
        categoryDTO.descCategoria = category.getDescCategoria();
        return categoryDTO;
    }
}
